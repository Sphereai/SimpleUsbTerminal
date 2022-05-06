package de.kai_morich.usb_terminal;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.protobuf.InvalidProtocolBufferException;
import com.gun0912.tedpermission.PermissionListener;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import de.kai_morich.usb_terminal.entities.DaoSession;
import de.kai_morich.usb_terminal.entities.Signal;
import de.kai_morich.usb_terminal.entities.SignalDao;
import de.kai_morich.usb_terminal.entities.Trial;
import de.kai_morich.usb_terminal.entities.TrialDao;
import de.kai_morich.usb_terminal.entities.TrialData;
import de.kai_morich.usb_terminal.entities.TrialDataDao;
import de.kai_morich.usb_terminal.utils.CSVUtil;
import de.kai_morich.usb_terminal.utils.DateTimeUtil;
import de.kai_morich.usb_terminal.utils.PermissionManager;

public class CounterFragment extends Fragment {

    private int counter = 1;
    private TextView textView;

    HashMap<String, List<TrivelProtocol.Reply>> signals = new HashMap<>();
    private DaoSession daoSession;

    public CounterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        daoSession = ((App) getActivity().getApplication()).getDaoSession();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);
        textView = view.findViewById(R.id.txt_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_counter, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.csv_export) {
            exportCSV();
          return true;
        } else if (id == R.id.dump_signals) {
            dumpSignals();
            return true;
        } else if (id == R.id.view_trials) {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, new TrialFragment(), "trials")
                    .addToBackStack(null)
                    .commit();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void statusOnUiThread(String msg) {
        if (counter == 20) {
            getActivity().runOnUiThread(() -> {
                SpannableStringBuilder spn = new SpannableStringBuilder(msg + '\n');
                spn.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorStatusText)), 0, spn.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.append(spn);
            });
        }
    }

    private void exportCSV() {
        PermissionManager.askWritePermission(new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Handler mainHandler = new Handler(Looper.getMainLooper());
                ExecutorService executor = Executors.newSingleThreadExecutor();

                executor.execute(() -> CSVUtil.exportSignalsToCSV(getActivity(), mainHandler));
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(getActivity(), "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dumpSignals() {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Inserting Signal Records");
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.setMax(18000);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler mainHandler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            long started = System.currentTimeMillis();

            long trialId = addTrial();
            for (int index = 1; index <= 18000; index++) {
                long trialDataId = addTrialData(trialId);
                addSignals(trialDataId);

                mainHandler.post(() -> {
                    progressDialog.incrementProgressBy(1);
                    progressDialog.incrementSecondaryProgressBy(1);
                });
            }

            long ended = System.currentTimeMillis() - started;
            long minutes = (ended / 1000) / 60;

            mainHandler.post(() -> {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }

                Log.i("#### Task Completed", minutes + "minutes");
                Toast.makeText(getActivity(), "Finished in " + minutes + "minutes", Toast.LENGTH_LONG).show();
            });
        });
    }

    private long addTrial() {
        TrialDao trialDao = daoSession.getTrialDao();
        String date = DateTimeUtil.toLocalDateTime(new Date());

        Trial trial = new Trial();
        trial.setUserId(1);
        trial.setTrialNumber(1111);
        trial.setStartDate(date);
        trial.setLastActionDate(date);
        return trialDao.insert(trial);
    }

    private long addTrialData(long trialId) {
        TrialDataDao trialDataDao = daoSession.getTrialDataDao();
        String date = DateTimeUtil.toLocalDateTime(new Date());

        TrialData trialData = new TrialData();
        trialData.setTrialId(trialId);
        trialData.setDeviceId(1001);
        trialData.setCadence(76.59);
        trialData.setPosition(0d);
        trialData.setTorque(0d);
        trialData.setPower(0d);
        trialData.setDate(date);
        return trialDataDao.insert(trialData);
    }

    private void addSignals(long trialDataId) {
        /*
        Signal signal = new Signal();
        signal.setTrialDataId(trialDataId);
        signal.setError(0);
        signal.setMotorError(0);
        signal.setEncoderError(0);
        signal.setAxisState(0);
        signal.setAppIsRunning(1);
        signal.setHeartBeatHost(0);
        signal.setLoopTime(27);
        signal.setVbus(0d);
        signal.setIqSetpoint(0d);
        signal.setIqMeasured(0d);
        signal.setIqFilt(0d);
        signal.setPedalTorque(0d);
        signal.setPedalVel(0d);
        signal.setPedalPos(56d);
        signal.setPedalPower(0d);
        signal.setEncoderPos(0d);
        signal.setEncoderVel(0d);
        signal.setVelCmd(-10.212);
        signal.setAccCmd(0d);
        signal.setRoadFeel(0d);
        signal.setDamping(12d);
        signal.setInertia(0d);
        signal.setTorqueCmd(0d);
        signal.setTorqueSignal(0d);
        signal.setTest(0d);

        SignalDao signalDao = daoSession.getSignalDao();
        signalDao.insertInTx(signal);
         */
    }
}

