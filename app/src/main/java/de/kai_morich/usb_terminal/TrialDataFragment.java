package de.kai_morich.usb_terminal;

import android.Manifest;
import android.app.ProgressDialog;
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

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import org.greenrobot.greendao.query.QueryBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.kai_morich.usb_terminal.adapters.TrialDataAdapter;
import de.kai_morich.usb_terminal.contracts.PaginationScrollListener;
import de.kai_morich.usb_terminal.entities.TrialData;
import de.kai_morich.usb_terminal.entities.TrialDataDao;
import de.kai_morich.usb_terminal.libs.SQLiteToExcel;
import de.kai_morich.usb_terminal.utils.CSVUtil;

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

    private int getTotalPageCount() {
        QueryBuilder<TrialData> queryBuilder = trialDataDao.queryBuilder();
        queryBuilder.where(TrialDataDao.Properties.TrialId.eq(trialId));
        long count = queryBuilder.count();
        return (int) Math.ceil(count / Constants.PAGE_SIZE);
    }

    private void exportTrialDataToCSV() {
        TedPermission.create()
                .setDeniedMessage("Export functionality will not be working properly without this permission\n\nPlease turn on permission from Settings.")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .setPermissionListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        exportToCSV();
                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        Toast.makeText(getActivity(), "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .check();
    }

    private void exportTrialDataToExcel() {
        TedPermission.create()
                .setDeniedMessage("Export functionality will not be working properly without this permission\n\nPlease turn on permission from Settings.")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .setPermissionListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        exportToExcel();
                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        Toast.makeText(getActivity(), "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .check();

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
                    getActivity().runOnUiThread(() -> {
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                    });
                } finally {
                    getActivity().runOnUiThread(() -> {
                        progressDialog.dismiss();
                    });
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

            sqLiteToExcel.exportSingleTable("trial_data", String.format(Locale.getDefault(), "%d_trial_data.xlsx", trialNumber), new SQLiteToExcel.ExportListener() {
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
        }
    }
}