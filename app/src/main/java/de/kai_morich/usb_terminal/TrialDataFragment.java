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

import org.apache.commons.collections4.CollectionUtils;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.LazyList;
import org.greenrobot.greendao.query.QueryBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.function.Predicate;

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
import de.kai_morich.usb_terminal.utils.DatabaseManager;
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
                App app = (App) getActivity().getApplication();
                List<Integer> distinctTrialIds = DatabaseManager.getDistinctTrialDataIdFromSignals(app, trialId);

                try {
                    if (distinctTrialIds.isEmpty()) {
                        requireActivity().runOnUiThread(() -> Toast.makeText(getActivity(), "Signal records not found.", Toast.LENGTH_SHORT).show());
                    } else {
                        String dirPath = CSVUtil.getDownloadsDirectory() + File.separator;
                        ExcelExporter exporter = new ExcelExporter(dirPath, String.format(Locale.getDefault(), "%d_trial_data_signals.xlsx", trialNumber), "trials_signals");
                        exporter.addHeadersRow(new ArrayList<>(Arrays.asList("date", "cadence", "position", "torque", "power", "error", "motor_error", "encoder_error", "axis_state", "app_is_running", "heartbeat_host", "loop_time (us)", "vbus", "iq_setpoint", "iq_measured", "iq_filt", "pedal_torque", "pedal_vel", "pedal_pos", "pedal_power", "encoder_pos", "encoder_vel", "vel_cmd", "acc_cmd", "roadfeel", "damping", "inertia", "test")));

                        String commaSeparatedIds = de.kai_morich.usb_terminal.utils.TextUtil.toCommaSeparatedString(distinctTrialIds);

                        Database database = app.getDaoSession().getDatabase();
                        String query = String.format("SELECT TRIAL_DATA_ID, TD.cadence, TD.position, TD.torque, TD.power, TD.date, group_concat(concat) AS concatenated FROM (SELECT TRIAL_DATA_ID, key || '|' || value || '|' || units as concat FROM signals) AS S INNER JOIN trial_data AS TD ON S.TRIAL_DATA_ID = TD.id WHERE TRIAL_DATA_ID IN (%s) GROUP BY TRIAL_DATA_ID", commaSeparatedIds);
                        Cursor cursor = database.rawQuery(query, null);

                        int rowNumber = 1;
                        while (cursor.moveToNext()) {
                            String concatenatedString = cursor.getString(cursor.getColumnIndex("concatenated"));
                            HashMap<String, SignalModel> signals = tokenizeConcatenatedString(concatenatedString);

                            String strError = signals.get("error").getValue();
                            Double error = (strError == null || strError.isEmpty()) ? null : Double.valueOf(strError);

                            String strMotorError = signals.get("motor_error").getValue();
                            Double motorError = (strMotorError == null || strMotorError.isEmpty()) ? null : Double.valueOf(strMotorError);

                            String strEncoderError = signals.get("encoder_error").getValue();
                            Double encoderError = (strEncoderError == null || strEncoderError.isEmpty()) ? null : Double.valueOf(strEncoderError);

                            String strAxisState = signals.get("axis_state").getValue();
                            Double axisState = (strAxisState == null || strAxisState.isEmpty()) ? null : Double.valueOf(strAxisState);

                            String strAppIsRunning = signals.get("app_is_running").getValue();
                            Double appIsRunning = (strAppIsRunning == null || strAppIsRunning.isEmpty()) ? null : Double.valueOf(strAppIsRunning);

                            String strHeartBeatHost = signals.get("heartbeat_host").getValue();
                            Double heartBeatHost = (strHeartBeatHost == null || strHeartBeatHost.isEmpty()) ? null : Double.valueOf(strHeartBeatHost);

                            String strLoopTime = signals.get("loop_time").getValue();
                            Double loopTime = (strLoopTime == null || strLoopTime.isEmpty()) ? null : Double.valueOf(strLoopTime);

                            String strVBus = signals.get("vbus").getValue();
                            Double vBus = (strVBus == null || strVBus.isEmpty()) ? null : Double.valueOf(strVBus);

                            String strIqSetPoint = signals.get("iq_setpoint").getValue();
                            Double iqSetPoint = (strIqSetPoint == null || strIqSetPoint.isEmpty()) ? null : Double.valueOf(strIqSetPoint);

                            String strIqMeasured = signals.get("iq_measured").getValue();
                            Double iqMeasured = (strIqMeasured == null || strIqMeasured.isEmpty()) ? null : Double.valueOf(strIqMeasured);

                            String strIqFilt = signals.get("iq_filt").getValue();
                            Double iqFilt = (strIqFilt == null || strIqFilt.isEmpty()) ? null : Double.valueOf(strIqFilt);

                            String strPedalTorque = signals.get("pedal_torque").getValue();
                            Double pedalTorque = (strPedalTorque == null || strPedalTorque.isEmpty()) ? null : Double.valueOf(strPedalTorque);

                            String strPedalVel = signals.get("pedal_vel").getValue();
                            Double pedalVel = (strPedalVel == null || strPedalVel.isEmpty()) ? null : Double.valueOf(strPedalVel);

                            String strPedalPos = signals.get("pedal_pos").getValue();
                            Double pedalPos = (strPedalPos == null || strPedalPos.isEmpty()) ? null : Double.valueOf(strPedalPos);

                            String strPedalPower = signals.get("pedal_power").getValue();
                            Double pedalPower = (strPedalPower == null || strPedalPower.isEmpty()) ? null : Double.valueOf(strPedalPower);

                            String strEncoderPos = signals.get("encoder_pos").getValue();
                            Double encoderPos = (strEncoderPos == null || strEncoderPos.isEmpty()) ? null : Double.valueOf(strEncoderPos);

                            String strEncoderVel = signals.get("encoder_vel").getValue();
                            Double encoderVel = (strEncoderVel == null || strEncoderVel.isEmpty()) ? null : Double.valueOf(strEncoderVel);

                            String strVelCmd = signals.get("vel_cmd").getValue();
                            Double velCmd = (strVelCmd == null || strVelCmd.isEmpty()) ? null : Double.valueOf(strVelCmd);

                            String strAccCmd = signals.get("acc_cmd").getValue();
                            Double accCmd = (strAccCmd == null || strAccCmd.isEmpty()) ? null : Double.valueOf(strAccCmd);

                            String strRoadFeed = signals.get("roadfeel").getValue();
                            Double roadFeel = (strRoadFeed == null || strRoadFeed.isEmpty()) ? null : Double.valueOf(strRoadFeed);

                            String strDamping = signals.get("damping").getValue();
                            Double damping = (strDamping == null || strDamping.isEmpty()) ? null : Double.valueOf(strDamping);

                            String strInertia = signals.get("inertia").getValue();
                            Double inertia = (strInertia == null || strInertia.isEmpty()) ? null : Double.valueOf(strInertia);

                            String strTest = signals.get("test").getValue();
                            Double test = (strTest == null || strTest.isEmpty()) ? null : Double.valueOf(strTest);

                            List<RowData> cols = new ArrayList<>();
                            cols.add(new RowData(CellType.String, cursor.getString(cursor.getColumnIndex("date"))));
                            cols.add(new RowData(CellType.Double, cursor.getDouble(cursor.getColumnIndex("cadence"))));
                            cols.add(new RowData(CellType.Double, cursor.getDouble(cursor.getColumnIndex("position"))));
                            cols.add(new RowData(CellType.Double, cursor.getDouble(cursor.getColumnIndex("torque"))));
                            cols.add(new RowData(CellType.Double, cursor.getDouble(cursor.getColumnIndex("power"))));
                            cols.add(new RowData(CellType.Double, error));
                            cols.add(new RowData(CellType.Double, motorError));
                            cols.add(new RowData(CellType.Double, encoderError));
                            cols.add(new RowData(CellType.Double, axisState));
                            cols.add(new RowData(CellType.Double, appIsRunning));
                            cols.add(new RowData(CellType.Double, heartBeatHost));
                            cols.add(new RowData(CellType.Double, loopTime));
                            cols.add(new RowData(CellType.Double, vBus));
                            cols.add(new RowData(CellType.Double, iqSetPoint));
                            cols.add(new RowData(CellType.Double, iqMeasured));
                            cols.add(new RowData(CellType.Double, iqFilt));
                            cols.add(new RowData(CellType.Double, pedalTorque));
                            cols.add(new RowData(CellType.Double, pedalVel));
                            cols.add(new RowData(CellType.Double, pedalPos));
                            cols.add(new RowData(CellType.Double, pedalPower));
                            cols.add(new RowData(CellType.Double, encoderPos));
                            cols.add(new RowData(CellType.Double, encoderVel));
                            cols.add(new RowData(CellType.Double, velCmd));
                            cols.add(new RowData(CellType.Double, accCmd));
                            cols.add(new RowData(CellType.Double, roadFeel));
                            cols.add(new RowData(CellType.Double, damping));
                            cols.add(new RowData(CellType.Double, inertia));
                            cols.add(new RowData(CellType.Double, test));

                            exporter.addRow(rowNumber, cols);
                            rowNumber++;
                        }
                        cursor.close();

                        exporter.export();
                        requireActivity().runOnUiThread(() -> Toast.makeText(getActivity(), "File exported at: " + dirPath, Toast.LENGTH_LONG).show());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FirebaseCrashlytics.getInstance().recordException(e);
                    requireActivity().runOnUiThread(() -> Toast.makeText(getActivity(), String.format("ERROR: %s", e.getMessage()), Toast.LENGTH_LONG).show());
                } finally {
                    requireActivity().runOnUiThread(progressDialog::dismiss);
                }
            }
        };

        thread.start();
    }

    private HashMap<String, SignalModel> tokenizeConcatenatedString(String str) {
        HashMap<String, SignalModel> signals = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(str, ",");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            String[] signalTokens = token.split("\\|");

            // See query, we concat signal as key|value|unit
            String key = signalTokens[0];
            String value = signalTokens[1];
            String unit = signalTokens.length == 3 ? signalTokens[2] : "";
            signals.put(key, new SignalModel(key, unit, value));
        }

        return signals;
    }
}