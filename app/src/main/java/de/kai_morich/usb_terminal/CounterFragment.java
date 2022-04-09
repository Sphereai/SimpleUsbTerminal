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
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import de.kai_morich.usb_terminal.entities.DaoSession;
import de.kai_morich.usb_terminal.entities.Signal;
import de.kai_morich.usb_terminal.entities.SignalDao;
import de.kai_morich.usb_terminal.entities.TrialData;
import de.kai_morich.usb_terminal.entities.TrialDataDao;

public class CounterFragment extends Fragment {

    private boolean started = false;
    private int counter = 0;

    private Handler mHandler;
    private Runnable mRunnable;
    private HandlerThread mHandlerThread;

    private ScheduledThreadPoolExecutor poolExecutor;

    private static final long DELAY_MILLIS = 200;
    private static final String HANDLER_THREAD_NAME = "HandlerThread";

    private TextView textView;
    private TrivelProtocol.Reply reply;

    public CounterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.seedReply();
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
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void initHandler() {
        this.counter = 0;

        stopHandler();

        poolExecutor = new ScheduledThreadPoolExecutor(2);
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

            TrialData trialData = new TrialData();
            trialData.setTrialId(1);
            trialData.setDeviceId(1212);
            trialData.setCadence(reply.getCadence());
            trialData.setPosition(reply.getPosition());
            trialData.setTorque(reply.getTorque());
            trialData.setPower(reply.getPower());
            trialData.setDate(new Date());
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

        } catch (Exception e) {
            statusOnUiThread("IO_EXCEPTION: " + e.getMessage());
        }
    }

    private void statusOnUiThread(String msg) {
        getActivity().runOnUiThread(() -> {
            SpannableStringBuilder spn = new SpannableStringBuilder(msg + '\n');
            spn.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorStatusText)), 0, spn.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView.append(spn);
        });
    }

    private void status() {
        getActivity().runOnUiThread(() -> {
            SpannableStringBuilder spn = new SpannableStringBuilder(String.format(Locale.getDefault(), "Showing %d value after 200 milliseconds", ++counter) + '\n');
            spn.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorStatusText)), 0, spn.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView.append(spn);
        });
    }
}