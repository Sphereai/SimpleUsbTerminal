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
import de.kai_morich.usb_terminal.utils.DateTimeUtil;

public class CounterFragment extends Fragment {

    private boolean started = false;
    private int counter = 1;

    private Handler mHandler;
    private Runnable mRunnable;
    private HandlerThread mHandlerThread;

    private ScheduledThreadPoolExecutor poolExecutor;

    private static final long DELAY_MILLIS = 200;
    private static final String HANDLER_THREAD_NAME = "HandlerThread";

    private TextView textView;
    private TrivelProtocol.Reply reply;

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

        if (id == R.id.start_stop) {
            if (started) {
                item.setIcon(R.drawable.ic_play_white_24dp);
                stopHandler();
            } else {
                item.setIcon(R.drawable.ic_stop_white_24dp);
                initHandler();
            }
            started = !started;
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

    private void initHandler() {
        poolExecutor = new ScheduledThreadPoolExecutor(1);
        poolExecutor.scheduleAtFixedRate(() -> {
            seedReply();
            saveReplyRecords();
        }, 0L, 200L, TimeUnit.MILLISECONDS);
    }

    private void stopHandler() {
        if (poolExecutor != null) {
            poolExecutor.shutdown();
            poolExecutor = null;
        }
    }

    private void seedReply() {
        reply = TrivelProtocol.Reply.newBuilder()
                .setCadence(1.01)
                .setPosition(1.1)
                .setTorque(20)
                .setPower(30)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("a").setValue(1).setUnits("rpm").build())
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("a").setValue(2).setUnits("rpm").build())
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("a").setValue(3).setUnits("rpm").build())
                .addIntSignals(TrivelProtocol.IntSignal.newBuilder().setKey("r").setValue(11).setUnits("rpm").build())
                .addIntSignals(TrivelProtocol.IntSignal.newBuilder().setKey("r").setValue(12).setUnits("rpm").build())
                .addIntSignals(TrivelProtocol.IntSignal.newBuilder().setKey("r").setValue(13).setUnits("rpm").build())
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("d").setValue(1.11).setUnits("rpm").build())
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("d").setValue(1.22).setUnits("rpm").build())
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("d").setValue(1.33).setUnits("rpm").build())
                .build();
    }

    private void saveReplyRecords() {
        try {
            List<Signal> signals = new ArrayList<>();

            DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
            TrialDataDao trialDataDao = daoSession.getTrialDataDao();
            SignalDao signalDao = daoSession.getSignalDao();

            String date = DateTimeUtil.toLocalDateTime(new Date());

            TrialData trialData = new TrialData();
            trialData.setTrialId(1);
            trialData.setDeviceId(1212);
            trialData.setCadence(reply.getCadence());
            trialData.setPosition(reply.getPosition());
            trialData.setTorque(reply.getTorque());
            trialData.setPower(reply.getPower());
            trialData.setDate(date);
            long lastInsertedTrialDataId = trialDataDao.insert(trialData);

            statusOnUiThread("******* UnsignedInt Signals *******");
            for (int index = 0; index < reply.getUnsignedIntSignalsCount(); index++) {
                TrivelProtocol.UnsignedIntSignal signal = reply.getUnsignedIntSignals(index);
                statusOnUiThread(signal.getKey() + " = " + signal.getValue() + " " + signal.getUnits());

                Signal uIntSignal = new Signal();
                uIntSignal.setTrialDataId(lastInsertedTrialDataId);
                uIntSignal.setType(Constants.SignalType.UINT);
                uIntSignal.setKey(signal.getKey());
                uIntSignal.setValue(String.valueOf(signal.getValue()));
                uIntSignal.setUnits(signal.getUnits());
                signals.add(uIntSignal);
            }

            statusOnUiThread("******* Int Signals *******");
            for (int index = 0; index < reply.getIntSignalsCount(); index++) {
                TrivelProtocol.IntSignal signal = reply.getIntSignals(index);
                statusOnUiThread(signal.getKey() + " = " + signal.getValue() + " " + signal.getUnits());

                Signal intSignal = new Signal();
                intSignal.setTrialDataId(lastInsertedTrialDataId);
                intSignal.setType(Constants.SignalType.INT);
                intSignal.setKey(signal.getKey());
                intSignal.setValue(String.valueOf(signal.getValue()));
                intSignal.setUnits(signal.getUnits());
                signals.add(intSignal);
            }

            statusOnUiThread("******* Double Signals *******");
            for (int index = 0; index < reply.getDoubleSignalsCount(); index++) {
                TrivelProtocol.DoubleSignal signal = reply.getDoubleSignals(index);
                statusOnUiThread(signal.getKey() + " = " + signal.getValue() + " " + signal.getUnits());

                Signal doubleSignal = new Signal();
                doubleSignal.setType(Constants.SignalType.DOUBLE);
                doubleSignal.setTrialDataId(lastInsertedTrialDataId);
                doubleSignal.setKey(signal.getKey());
                doubleSignal.setValue(String.valueOf(signal.getValue()));
                doubleSignal.setUnits(signal.getUnits());
                signals.add(doubleSignal);
            }

            signalDao.insertInTx(signals);

            if (counter == 20) {
                counter = 1;
            } else {
                counter += 1;
            }

        } catch (Exception e) {
            statusOnUiThread("IO_EXCEPTION: " + e.getMessage());
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

    private void dumpSignals() {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Inserting Signal Records");
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler mainHandler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            long started = System.currentTimeMillis();

            long trialId = addTrial();
            for (int index = 1; index <= 18000; index++) {
                long trialDataId = addTrialData(trialId);
                addSignals(trialDataId);
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
        List<Signal> signals = new ArrayList<>();

        Signal errorSignal = new Signal();
        errorSignal.setKey("error");
        errorSignal.setValue("0");
        errorSignal.setUnits("");
        errorSignal.setTrialDataId(trialDataId);
        errorSignal.setType(Constants.SignalType.UINT);
        signals.add(errorSignal);

        Signal motorErrorSignal = new Signal();
        motorErrorSignal.setKey("motor_error");
        motorErrorSignal.setValue("0");
        motorErrorSignal.setUnits("");
        motorErrorSignal.setTrialDataId(trialDataId);
        motorErrorSignal.setType(Constants.SignalType.UINT);
        signals.add(motorErrorSignal);

        Signal encoderErrorSignal = new Signal();
        encoderErrorSignal.setKey("encoder_error");
        encoderErrorSignal.setValue("0");
        encoderErrorSignal.setUnits("");
        encoderErrorSignal.setTrialDataId(trialDataId);
        encoderErrorSignal.setType(Constants.SignalType.UINT);
        signals.add(encoderErrorSignal);

        Signal axisStateSignal = new Signal();
        axisStateSignal.setKey("axis_state");
        axisStateSignal.setValue("0");
        axisStateSignal.setUnits("");
        axisStateSignal.setTrialDataId(trialDataId);
        axisStateSignal.setType(Constants.SignalType.UINT);
        signals.add(axisStateSignal);

        Signal appIsRunningSignal = new Signal();
        appIsRunningSignal.setKey("app_is_running");
        appIsRunningSignal.setValue("1");
        appIsRunningSignal.setUnits("");
        appIsRunningSignal.setTrialDataId(trialDataId);
        appIsRunningSignal.setType(Constants.SignalType.UINT);
        signals.add(appIsRunningSignal);

        Signal heartbeatHostSignal = new Signal();
        heartbeatHostSignal.setKey("heartbeat_host");
        heartbeatHostSignal.setValue("0");
        heartbeatHostSignal.setUnits("");
        heartbeatHostSignal.setTrialDataId(trialDataId);
        heartbeatHostSignal.setType(Constants.SignalType.UINT);
        signals.add(heartbeatHostSignal);

        Signal loopTimeSignal = new Signal();
        loopTimeSignal.setKey("loop_time");
        loopTimeSignal.setValue("27");
        loopTimeSignal.setUnits("us");
        loopTimeSignal.setTrialDataId(trialDataId);
        loopTimeSignal.setType(Constants.SignalType.INT);
        signals.add(loopTimeSignal);

        Signal vbusSignal = new Signal();
        vbusSignal.setKey("vbus");
        vbusSignal.setValue("0");
        vbusSignal.setUnits("V");
        vbusSignal.setTrialDataId(trialDataId);
        vbusSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(vbusSignal);

        Signal iqSetpointSignal = new Signal();
        iqSetpointSignal.setKey("iq_setpoint");
        iqSetpointSignal.setValue("0");
        iqSetpointSignal.setUnits("A");
        iqSetpointSignal.setTrialDataId(trialDataId);
        iqSetpointSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(iqSetpointSignal);

        Signal iqMeasuredSignal = new Signal();
        iqMeasuredSignal.setKey("iq_measured");
        iqMeasuredSignal.setValue("0");
        iqMeasuredSignal.setUnits("A");
        iqMeasuredSignal.setTrialDataId(trialDataId);
        iqMeasuredSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(iqMeasuredSignal);

        Signal iqFiltSignal = new Signal();
        iqFiltSignal.setKey("iq_filt");
        iqFiltSignal.setValue("0");
        iqFiltSignal.setUnits("A");
        iqFiltSignal.setTrialDataId(trialDataId);
        iqFiltSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(iqFiltSignal);

        Signal pedalTorqueSignal = new Signal();
        pedalTorqueSignal.setKey("pedal_torque");
        pedalTorqueSignal.setValue("0");
        pedalTorqueSignal.setUnits("N.m");
        pedalTorqueSignal.setTrialDataId(trialDataId);
        pedalTorqueSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(pedalTorqueSignal);

        Signal pedalVelSignal = new Signal();
        pedalVelSignal.setKey("pedal_vel");
        pedalVelSignal.setValue("0");
        pedalVelSignal.setUnits("rpm");
        pedalVelSignal.setTrialDataId(trialDataId);
        pedalVelSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(pedalVelSignal);

        Signal pedalPosSignal = new Signal();
        pedalPosSignal.setKey("pedal_pos");
        pedalPosSignal.setValue("56");
        pedalPosSignal.setUnits("deg");
        pedalPosSignal.setTrialDataId(trialDataId);
        pedalPosSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(pedalPosSignal);

        Signal pedalPowerSignal = new Signal();
        pedalPowerSignal.setKey("pedal_power");
        pedalPowerSignal.setValue("0");
        pedalPowerSignal.setUnits("W");
        pedalPowerSignal.setTrialDataId(trialDataId);
        pedalPowerSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(pedalPowerSignal);

        Signal encoderPosSignal = new Signal();
        encoderPosSignal.setKey("encoder_pos");
        encoderPosSignal.setValue("0");
        encoderPosSignal.setUnits("turns");
        encoderPosSignal.setTrialDataId(trialDataId);
        encoderPosSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(encoderPosSignal);

        Signal encoderVelSignal = new Signal();
        encoderVelSignal.setKey("encoder_vel");
        encoderVelSignal.setValue("0");
        encoderVelSignal.setUnits("deg/s");
        encoderVelSignal.setTrialDataId(trialDataId);
        encoderVelSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(encoderVelSignal);

        Signal velCmdSignal = new Signal();
        velCmdSignal.setKey("vel_cmd");
        velCmdSignal.setValue("-10.212");
        velCmdSignal.setUnits("deg/s");
        velCmdSignal.setTrialDataId(trialDataId);
        velCmdSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(velCmdSignal);

        Signal accCmdSignal = new Signal();
        accCmdSignal.setKey("acc_cmd");
        accCmdSignal.setValue("0");
        accCmdSignal.setUnits("deg/s/s");
        accCmdSignal.setTrialDataId(trialDataId);
        accCmdSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(accCmdSignal);

        Signal roadFeelSignal = new Signal();
        roadFeelSignal.setKey("roadfeel");
        roadFeelSignal.setValue("0");
        roadFeelSignal.setUnits("");
        roadFeelSignal.setTrialDataId(trialDataId);
        roadFeelSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(roadFeelSignal);

        Signal dampingSignal = new Signal();
        dampingSignal.setKey("damping");
        dampingSignal.setValue("12");
        dampingSignal.setUnits("%");
        dampingSignal.setTrialDataId(trialDataId);
        dampingSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(dampingSignal);

        Signal inertiaSignal = new Signal();
        inertiaSignal.setKey("inertia");
        inertiaSignal.setValue("0");
        inertiaSignal.setUnits("%");
        inertiaSignal.setTrialDataId(trialDataId);
        inertiaSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(inertiaSignal);

        Signal testSignal = new Signal();
        testSignal.setKey("test");
        testSignal.setValue("0");
        testSignal.setUnits("");
        testSignal.setTrialDataId(trialDataId);
        testSignal.setType(Constants.SignalType.DOUBLE);
        signals.add(testSignal);

        SignalDao signalDao = daoSession.getSignalDao();
        signalDao.insertInTx(signals);
    }
}

