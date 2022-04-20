package de.kai_morich.usb_terminal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
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
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import de.kai_morich.usb_terminal.entities.DaoSession;
import de.kai_morich.usb_terminal.entities.Signal;
import de.kai_morich.usb_terminal.entities.SignalDao;
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

    public CounterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.seedReply();

//        this.seedMultipleReplies();
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
        stopHandler();

        poolExecutor = new ScheduledThreadPoolExecutor(1);
        poolExecutor.scheduleAtFixedRate(() -> {
            status();
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

    private void status() {
        if (counter == 20) {
            getActivity().runOnUiThread(() -> {
                SpannableStringBuilder spn = new SpannableStringBuilder(String.format(Locale.getDefault(), "Showing %dth value after 200 milliseconds", counter) + '\n');
                spn.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorStatusText)), 0, spn.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.append(spn);
            });
        }
    }

    private void seedMultipleReplies() {

        initializeMultipleReplies();

        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
        TrialDataDao trialDataDao = daoSession.getTrialDataDao();
        SignalDao signalDao = daoSession.getSignalDao();

        List<Double> trialDataRecords = new ArrayList<>();
        trialDataRecords.add(76.58);
        trialDataRecords.add(76.40);
        trialDataRecords.add(76.22);

        for (int i = 1; i <= 3; i++) {

            Double cadence = trialDataRecords.get(i-1);

            String date = DateTimeUtil.toLocalDateTime(new Date());
            TrialData trialData = new TrialData();
            trialData.setTrialId(i);
            trialData.setDeviceId(1212);
            trialData.setCadence(cadence);
            trialData.setPosition(0d);
            trialData.setTorque(0d);
            trialData.setPower(0d);
            trialData.setDate(date);
            long lastInsertedTrialDataId = trialDataDao.insert(trialData);

            List<TrivelProtocol.Reply> replies = signals.get(String.valueOf(i));

            for (TrivelProtocol.Reply r : replies) {

                List<Signal> allSignals = new ArrayList<>();

                statusOnUiThread("******* UnsignedInt Signals *******");
                for (int j = 0; j < r.getUnsignedIntSignalsCount(); j++) {
                    TrivelProtocol.UnsignedIntSignal uIntSignals = r.getUnsignedIntSignals(j);
                    statusOnUiThread(uIntSignals.getKey() + " = " + uIntSignals.getValue() + " " + uIntSignals.getUnits());

                    Signal uIntSignal = new Signal();
                    uIntSignal.setTrialDataId(lastInsertedTrialDataId);
                    uIntSignal.setType(Constants.SignalType.UINT);
                    uIntSignal.setKey(uIntSignals.getKey());
                    uIntSignal.setValue(String.valueOf(uIntSignals.getValue()));
                    uIntSignal.setUnits(uIntSignals.getUnits());

                    allSignals.add(uIntSignal);
                }

                statusOnUiThread("******* Int Signals *******");
                for (int j = 0; j < r.getIntSignalsCount(); j++) {
                    TrivelProtocol.IntSignal intSignals = r.getIntSignals(j);
                    statusOnUiThread(intSignals.getKey() + " = " + intSignals.getValue() + " " + intSignals.getUnits());

                    Signal intSignal = new Signal();
                    intSignal.setTrialDataId(lastInsertedTrialDataId);
                    intSignal.setType(Constants.SignalType.INT);
                    intSignal.setKey(intSignals.getKey());
                    intSignal.setValue(String.valueOf(intSignals.getValue()));
                    intSignal.setUnits(intSignals.getUnits());
                    allSignals.add(intSignal);
                }

                statusOnUiThread("******* Double Signals *******");
                for (int j = 0; j < r.getDoubleSignalsCount(); j++) {
                    TrivelProtocol.DoubleSignal doubleSignals = r.getDoubleSignals(j);
                    statusOnUiThread(doubleSignals.getKey() + " = " + doubleSignals.getValue() + " " + doubleSignals.getUnits());

                    Signal doubleSignal = new Signal();
                    doubleSignal.setType(Constants.SignalType.DOUBLE);
                    doubleSignal.setTrialDataId(lastInsertedTrialDataId);
                    doubleSignal.setKey(doubleSignals.getKey());
                    doubleSignal.setValue(String.valueOf(doubleSignals.getValue()));
                    doubleSignal.setUnits(doubleSignals.getUnits());
                    allSignals.add(doubleSignal);
                }

                signalDao.insertInTx(allSignals);
            }
        }
    }

    private void initializeMultipleReplies() {

        List<TrivelProtocol.Reply> replies1 = new ArrayList<>();
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("error").setValue(0).build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("motor_error").setValue(0).build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("encoder_error").setValue(0).build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("axis_state").setValue(0).build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("app_is_running").setValue(1).build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("heartbeat_host").setValue(0).build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addIntSignals(TrivelProtocol.IntSignal.newBuilder().setKey("loop_time").setValue(27).setUnits("us").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("vbus").setValue(0).setUnits("V").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("iq_setpoint").setValue(0).setUnits("A").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("iq_measured").setValue(0).setUnits("A").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("iq_filt").setValue(0).setUnits("A").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("pedal_torque").setValue(0).setUnits("N.m").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("pedal_vel").setValue(0).setUnits("rpm").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("pedal_pos").setValue(56).setUnits("deg").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("pedal_power").setValue(0).setUnits("W").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("encoder_pos").setValue(0).setUnits("turns").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("encoder_vel").setValue(0).setUnits("deg/s").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("vel_cmd").setValue(-10.212).setUnits("deg/s").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("acc_cmd").setValue(0).setUnits("deg/s/s").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("roadfeel").setValue(0).build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("damping").setValue(12).setUnits("%").build())
                .build());
        replies1.add(TrivelProtocol.Reply.newBuilder().setCadence(76.59).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("inertia").setValue(0).setUnits("%").build())
                .build());


        List<TrivelProtocol.Reply> replies2 = new ArrayList<>();
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("error").setValue(0).build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("motor_error").setValue(0).build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("encoder_error").setValue(0).build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("axis_state").setValue(0).build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("app_is_running").setValue(1).build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("heartbeat_host").setValue(0).build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addIntSignals(TrivelProtocol.IntSignal.newBuilder().setKey("loop_time").setValue(27).setUnits("us").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("vbus").setValue(0).setUnits("V").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("iq_setpoint").setValue(0).setUnits("A").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("iq_measured").setValue(0).setUnits("A").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("iq_filt").setValue(0).setUnits("A").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("pedal_torque").setValue(0).setUnits("N.m").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("pedal_vel").setValue(0).setUnits("rpm").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("pedal_pos").setValue(56).setUnits("deg").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("pedal_power").setValue(0).setUnits("W").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("encoder_pos").setValue(0).setUnits("turns").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("encoder_vel").setValue(0).setUnits("deg/s").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("vel_cmd").setValue(-10.184).setUnits("deg/s").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("acc_cmd").setValue(0).setUnits("deg/s/s").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("roadfeel").setValue(0).build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("damping").setValue(12).setUnits("%").build())
                .build());
        replies2.add(TrivelProtocol.Reply.newBuilder().setCadence(76.38).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("inertia").setValue(0).setUnits("%").build())
                .build());

        List<TrivelProtocol.Reply> replies3 = new ArrayList<>();
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("error").setValue(0).build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("motor_error").setValue(0).build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("encoder_error").setValue(0).build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("axis_state").setValue(0).build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("app_is_running").setValue(1).build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addUnsignedIntSignals(TrivelProtocol.UnsignedIntSignal.newBuilder().setKey("heartbeat_host").setValue(0).build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addIntSignals(TrivelProtocol.IntSignal.newBuilder().setKey("loop_time").setValue(28).setUnits("us").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("vbus").setValue(0).setUnits("V").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("iq_setpoint").setValue(0).setUnits("A").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("iq_measured").setValue(0).setUnits("A").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("iq_filt").setValue(0).setUnits("A").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("pedal_torque").setValue(0).setUnits("N.m").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("pedal_vel").setValue(0).setUnits("rpm").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("pedal_pos").setValue(56).setUnits("deg").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("pedal_power").setValue(0).setUnits("W").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("encoder_pos").setValue(0).setUnits("turns").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("encoder_vel").setValue(0).setUnits("deg/s").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("vel_cmd").setValue(-10.164).setUnits("deg/s").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("acc_cmd").setValue(0).setUnits("deg/s/s").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("roadfeel").setValue(0).build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("damping").setValue(12).setUnits("%").build())
                .build());
        replies3.add(TrivelProtocol.Reply.newBuilder().setCadence(76.23).setPosition(0).setTorque(0).setPower(0)
                .addDoubleSignals(TrivelProtocol.DoubleSignal.newBuilder().setKey("inertia").setValue(0).setUnits("%").build())
                .build());

        signals.put("1", replies1);
        signals.put("2", replies2);
        signals.put("3", replies3);
    }
}