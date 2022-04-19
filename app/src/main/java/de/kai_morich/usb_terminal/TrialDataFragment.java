package de.kai_morich.usb_terminal;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.gun0912.tedpermission.PermissionListener;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.LazyList;
import org.greenrobot.greendao.query.QueryBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import de.kai_morich.usb_terminal.adapters.TrialDataAdapter;
import de.kai_morich.usb_terminal.contracts.PaginationScrollListener;
import de.kai_morich.usb_terminal.entities.Signal;
import de.kai_morich.usb_terminal.entities.SignalDao;
import de.kai_morich.usb_terminal.entities.TrialData;
import de.kai_morich.usb_terminal.entities.TrialDataDao;
import de.kai_morich.usb_terminal.libs.excel.CellType;
import de.kai_morich.usb_terminal.libs.excel.ExcelExporter;
import de.kai_morich.usb_terminal.libs.excel.ExportListener;
import de.kai_morich.usb_terminal.libs.excel.RowData;
import de.kai_morich.usb_terminal.libs.excel.SQLiteToExcel;
import de.kai_morich.usb_terminal.utils.CSVUtil;
import de.kai_morich.usb_terminal.utils.PermissionManager;

public class TrialDataFragment extends Fragment {

    private int currentPage = 0;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private TrialDataDao trialDataDao;

    private RecyclerView mRecyclerView;
    private TextView mEmptyDataView;
    private TrialDataAdapter trialDataAdapter;

    private long trialId;
    private int trialNumber;

    private int EXTERNAL_STORAGE_PERMISSION_CODE = 23;

    public TrialDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        if (getArguments() != null) {
            trialId = getArguments().getLong("trial_id");
            trialNumber = getArguments().getInt("trial_number");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        trialDataDao = ((App) getActivity().getApplication()).getDaoSession().getTrialDataDao();

        View view = inflater.inflate(R.layout.fragment_trial_data, container, false);
        mRecyclerView = view.findViewById(R.id.trial_data_recycler_view);
        mEmptyDataView = view.findViewById(R.id.empty_data);

        trialDataAdapter = new TrialDataAdapter(new ArrayList<>());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(trialDataAdapter);

        mRecyclerView.addOnScrollListener(new PaginationScrollListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;
                loadNextPage();
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(String.format(Locale.getDefault(), "%d Trial Data", trialNumber));
    }

    @Override
    public void onStart() {
        super.onStart();
        loadFirstPage();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_trial_data, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.csv_export) {
            exportTrialDataToCSV();
            return true;
        } else if (id == R.id.excel_export) {
            exportTrialDataToExcel();
            return true;
        } else if (id == R.id.excel_export_trial_data_signals) {
            exportTrialDataWithSignalsToExcel();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void loadFirstPage() {
        List<TrialData> trialData = getTrialData();
        int totalPages = getTotalPageCount();
        trialDataAdapter.addAllTrialData(trialData);

        if (currentPage < totalPages) {
            trialDataAdapter.addLoading();
        } else {
            isLastPage = true;
        }

        if (trialData.size() > 0) {
            mRecyclerView.setVisibility(View.VISIBLE);
            mEmptyDataView.setVisibility(View.GONE);
        } else {
            mRecyclerView.setVisibility(View.GONE);
            mEmptyDataView.setVisibility(View.VISIBLE);
        }
    }

    private void loadNextPage() {
        trialDataAdapter.removeLoading();
        isLoading = false;

        List<TrialData> trialData = getTrialData();
        int totalPages = getTotalPageCount();
        trialDataAdapter.addAllTrialData(trialData);

        if (currentPage != totalPages) {
            trialDataAdapter.addLoading();
        } else {
            isLastPage = true;
        }
    }

    private List<TrialData> getTrialData() {
        QueryBuilder<TrialData> queryBuilder = trialDataDao.queryBuilder();
        queryBuilder.where(TrialDataDao.Properties.TrialId.eq(trialId));
        queryBuilder.limit(Constants.PAGE_SIZE);
        queryBuilder.offset(currentPage * Constants.PAGE_SIZE);
        return queryBuilder.list();
    }

    private LazyList<Signal> getSignalsWillTrialData() {

        SignalDao signalDao = ((App) getActivity().getApplication()).getDaoSession().getSignalDao();
        QueryBuilder<Signal> queryBuilder = signalDao.queryBuilder();
        queryBuilder.join(SignalDao.Properties.TrialDataId, TrialData.class, TrialDataDao.Properties.Id)
                .where(TrialDataDao.Properties.TrialId.eq(trialId));
        return queryBuilder.build().listLazyUncached();
    }

    private int getTotalPageCount() {
        QueryBuilder<TrialData> queryBuilder = trialDataDao.queryBuilder();
        queryBuilder.where(TrialDataDao.Properties.TrialId.eq(trialId));
        long count = queryBuilder.count();
        return (int) Math.ceil(count / Constants.PAGE_SIZE);
    }

    private void exportTrialDataToCSV() {
        PermissionManager.askWritePermission(new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                exportToCSV();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(getActivity(), "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void exportTrialDataToExcel() {
        PermissionManager.askWritePermission(new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                exportToExcel();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(getActivity(), "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void exportTrialDataWithSignalsToExcel() {
        PermissionManager.askWritePermission(new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                exportAllToExcel();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(getActivity(), "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void exportToCSV() {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Exporting to CSV");
        progressDialog.setMessage("Please wait...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    CSVUtil.exportTrialDataToCSV(getActivity());
                } catch (Exception e) {
                    requireActivity().runOnUiThread(() -> Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show());
                } finally {
                    requireActivity().runOnUiThread(progressDialog::dismiss);
                }
            }
        };

        thread.start();
    }

    private void exportToExcel() {
        try {
            ArrayList<String> columnsToExclude = new ArrayList<>();
            columnsToExclude.add("TRIAL_ID");
            columnsToExclude.add("device_id");

            String dirPath = CSVUtil.getDownloadsDirectory() + File.separator;
            SQLiteToExcel sqLiteToExcel = new SQLiteToExcel(getActivity(), "signals-db", dirPath);
            sqLiteToExcel.setExcludeColumns(columnsToExclude);

            sqLiteToExcel.exportSingleTable("trial_data", String.format(Locale.getDefault(), "%d_trial_data.xlsx", trialNumber), new ExportListener() {
                @Override
                public void onStart() {
                    Toast.makeText(getActivity(), "Exporting Started...", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCompleted(String filePath) {
                    Toast.makeText(getActivity(), "File exported at: " + filePath, Toast.LENGTH_LONG).show();
                }

                @Override
                public void onError(Exception e) {
                    Toast.makeText(getActivity(), "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    private void exportAllToExcel() {

        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Exporting to Excel File");
        progressDialog.setMessage("Please wait...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);

        Thread thread = new Thread() {
            @Override
            public void run() {
                LazyList<Signal> signalLazyList = getSignalsWillTrialData();

                try {
                    if (signalLazyList.isEmpty()) {
                        requireActivity().runOnUiThread(() -> Toast.makeText(getActivity(), "Signal records not found.", Toast.LENGTH_SHORT).show());
                    } else {
                        String dirPath = CSVUtil.getDownloadsDirectory() + File.separator;
                        ExcelExporter exporter = new ExcelExporter(dirPath, String.format(Locale.getDefault(), "%d_trial_data_signals.xlsx", trialNumber), "trials_signals");
                        exporter.addHeadersRow(new ArrayList<>(Arrays.asList("Key", "Value", "Unit", "Type", "Cadence", "Position", "Torque", "Power", "Date")));

                        int rowNumber = 1;

                        for (Signal signal : signalLazyList) {
                            TrialData trialData = signal.getTrialData();

                            List<RowData> cols = new ArrayList<>();
                            cols.add(new RowData(CellType.String, signal.getKey()));
                            cols.add(new RowData(CellType.Double, (signal.getValue() == null || signal.getValue().isEmpty()) ? null : Double.valueOf(signal.getValue())));
                            cols.add(new RowData(CellType.String, signal.getUnits()));
                            cols.add(new RowData(CellType.String, signal.getType()));
                            cols.add(new RowData(CellType.Double, trialData.getCadence()));
                            cols.add(new RowData(CellType.Double, trialData.getPosition()));
                            cols.add(new RowData(CellType.Double, trialData.getTorque()));
                            cols.add(new RowData(CellType.Double, trialData.getPower()));
                            cols.add(new RowData(CellType.String, trialData.getDate()));

                            exporter.addRow(rowNumber, cols);
                            rowNumber++;
                        }

                        exporter.export();

                        requireActivity().runOnUiThread(() -> Toast.makeText(getActivity(), "File exported at: " + dirPath, Toast.LENGTH_LONG).show());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e);
                    requireActivity().runOnUiThread(() -> Toast.makeText(getActivity(), String.format("ERROR: %s", e.getMessage()), Toast.LENGTH_LONG).show());
                } finally {
                    signalLazyList.close();
                    requireActivity().runOnUiThread(progressDialog::dismiss);
                }
            }
        };

        thread.start();
    }
}