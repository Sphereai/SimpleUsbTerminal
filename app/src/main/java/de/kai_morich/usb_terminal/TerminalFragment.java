package de.kai_morich.usb_terminal;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.protobuf.InvalidProtocolBufferException;
import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import com.hoho.android.usbserial.driver.UsbSerialProber;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
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
import de.kai_morich.usb_terminal.utils.TextUtil;

public class TerminalFragment extends Fragment implements ServiceConnection, SerialListener {

    private Handler mReceiveSignalHandler;
    private HandlerThread mReceiveSignalHandlerThread;

    private ScheduledThreadPoolExecutor threadPoolExecutor;

    private boolean trialDialogShown = false;
    private EditText startDate, lastActionDate;

    private enum Connected {False, Pending, True}

    private final BroadcastReceiver broadcastReceiver;
    private int deviceId, portNum, baudRate;
    private UsbSerialPort usbSerialPort;
    private SerialService service;

    private TextView receiveText;
    private TextView sendText;
    private ControlLines controlLines;
    private TextUtil.HexWatcher hexWatcher;

    private Connected connected = Connected.False;
    private boolean startSendingGetSignals = false;
    private boolean initialStart = true;
    private boolean hexEnabled = false;
    private boolean controlLinesEnabled = false;
    private boolean pendingNewline = false;
    private String newline = TextUtil.newline_crlf;

    private static final String RECEIVE_SIGNAL_HANDLER_THREAD_NAME = "RECEIVE_SIGNAL_THREAD";

    private int EXTERNAL_STORAGE_PERMISSION_CODE = 23;

    private static final String START_DATE_TAG = "start_date";
    private static final String LAST_ACTION_DATE_TAG = "last_action_date";

    private String strTrialNumber, strStartDate, strLastActionDate;
    private long lastTrialInsertedId = -1;
    private int counter = 1;
    private boolean isExceptionOccured = false;

    public TerminalFragment() {
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (Constants.INTENT_ACTION_GRANT_USB.equals(intent.getAction())) {
                    Boolean granted = intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false);
                    connect(granted);
                }
            }
        };
    }

    /*
     * Lifecycle
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        deviceId = getArguments().getInt("device");
        portNum = getArguments().getInt("port");
        baudRate = getArguments().getInt("baud");
    }

    @Override
    public void onDestroy() {
        if (connected != Connected.False)
            disconnect();
        getActivity().stopService(new Intent(getActivity(), SerialService.class));
        super.onDestroy();

        trialDialogShown = false;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (service != null)
            service.attach(this);
        else
            getActivity().startService(new Intent(getActivity(), SerialService.class)); // prevents service destroy on unbind from recreated activity caused by orientation change
    }

    @Override
    public void onStop() {
        if (service != null && !getActivity().isChangingConfigurations())
            service.detach();
        super.onStop();
    }

    @SuppressWarnings("deprecation")
    // onAttach(context) was added with API 23. onAttach(activity) works for all API versions
    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        getActivity().bindService(new Intent(getActivity(), SerialService.class), this, Context.BIND_AUTO_CREATE);


    }

    @Override
    public void onDetach() {
        try {
            getActivity().unbindService(this);
        } catch (Exception ignored) {
        }
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(broadcastReceiver, new IntentFilter(Constants.INTENT_ACTION_GRANT_USB));
        if (initialStart && service != null) {
            initialStart = false;
            getActivity().runOnUiThread(this::connect);
        }
        if (controlLinesEnabled && controlLines != null && connected == Connected.True)
            controlLines.start();
    }

    @Override
    public void onPause() {
        getActivity().unregisterReceiver(broadcastReceiver);
        if (controlLines != null)
            controlLines.stop();
        super.onPause();
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        service = ((SerialService.SerialBinder) binder).getService();
        service.attach(this);
        if (initialStart && isResumed()) {
            initialStart = false;
            getActivity().runOnUiThread(this::connect);
        }

        initHandlerForReceivingSignals();

        if (!trialDialogShown) {
            showDialogForTrialInput();
            trialDialogShown = true;
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        service = null;
        stopHandlerForReceivingSignals();
    }

    /*
     * UI
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terminal, container, false);
        receiveText = view.findViewById(R.id.receive_text);                          // TextView performance decreases with number of spans
        receiveText.setTextColor(getResources().getColor(R.color.colorRecieveText)); // set as default color to reduce number of spans
        receiveText.setMovementMethod(ScrollingMovementMethod.getInstance());

        sendText = view.findViewById(R.id.send_text);
        hexWatcher = new TextUtil.HexWatcher(sendText);
        hexWatcher.enable(hexEnabled);
        sendText.addTextChangedListener(hexWatcher);
        sendText.setHint(hexEnabled ? "HEX mode" : "");

        View sendBtn = view.findViewById(R.id.send_btn);
        sendBtn.setOnClickListener(v -> send(sendText.getText().toString()));
        controlLines = new ControlLines(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Terminal");
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_terminal, menu);
        menu.findItem(R.id.hex).setChecked(hexEnabled);
        menu.findItem(R.id.controlLines).setChecked(controlLinesEnabled);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.start_stop) {
            if (startSendingGetSignals) {
                item.setIcon(R.drawable.ic_play_white_24dp);
                stopHandler();
            } else {
                item.setIcon(R.drawable.ic_stop_white_24dp);
                initHandler();
            }
            startSendingGetSignals = !startSendingGetSignals;
            return true;
        } else if (id == R.id.clear) {
            receiveText.setText("");
            return true;
        } else if (id == R.id.newline) {
            String[] newlineNames = getResources().getStringArray(R.array.newline_names);
            String[] newlineValues = getResources().getStringArray(R.array.newline_values);
            int pos = java.util.Arrays.asList(newlineValues).indexOf(newline);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Newline");
            builder.setSingleChoiceItems(newlineNames, pos, (dialog, item1) -> {
                newline = newlineValues[item1];
                dialog.dismiss();
            });
            builder.create().show();
            return true;
        } else if (id == R.id.hex) {
            hexEnabled = !hexEnabled;
            sendText.setText("");
            hexWatcher.enable(hexEnabled);
            sendText.setHint(hexEnabled ? "HEX mode" : "");
            item.setChecked(hexEnabled);
            return true;
        } else if (id == R.id.controlLines) {
            controlLinesEnabled = !controlLinesEnabled;
            item.setChecked(controlLinesEnabled);
            if (controlLinesEnabled) {
                controlLines.start();
            } else {
                controlLines.stop();
            }
            return true;
        } else if (id == R.id.sendBreak) {
            try {
                usbSerialPort.setBreak(true);
                Thread.sleep(100);
                status("send BREAK");
                usbSerialPort.setBreak(false);
            } catch (Exception e) {
                status("send BREAK failed: " + e.getMessage());
            }
            return true;
        } else if (id == R.id.trials) {
            Fragment fragment = new TrialFragment();
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, fragment, "trials")
                    .addToBackStack(null)
                    .commit();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void showDialogForTrialInput() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());

        final View trialView = inflater.inflate(R.layout.view_trial, null);
        final EditText trialNumber = trialView.findViewById(R.id.trial_number);
        startDate = trialView.findViewById(R.id.start_date);
        lastActionDate = trialView.findViewById(R.id.last_action_date);
        Button continueButton = trialView.findViewById(R.id.btn_continue);

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.ic_notification)
                .setTitle("Trial Data")
                .setView(trialView)
                .setCancelable(false);

        AlertDialog dialog = builder.create();

        continueButton.setOnClickListener(view -> {
            strTrialNumber = trialNumber.getText().toString();
            strStartDate = startDate.getText().toString();
            strLastActionDate = lastActionDate.getText().toString();

            if (strTrialNumber.isEmpty()) {
                Toast.makeText(getActivity(), "Please enter trial number to continue.", Toast.LENGTH_SHORT).show();
            } else if (strStartDate.isEmpty()) {
                Toast.makeText(getActivity(), "Please select start date to continue", Toast.LENGTH_SHORT).show();
            } else {
                dialog.dismiss();
                saveTrialData();
            }
        });

        dialog.show();

        hideKeyboard(startDate);
        hideKeyboard(lastActionDate);

        DatePickerDialog.OnDateSetListener listener = (datePicker, year, month, day) -> {
            String date = String.format("%d/%d/%d", day, month + 1, year);
            if (datePicker.getTag().equals(START_DATE_TAG)) {
                startDate.setText(date);
            }

            if (datePicker.getTag().equals(LAST_ACTION_DATE_TAG)) {
                lastActionDate.setText(date);
            }
        };

        startDate.setOnClickListener(view -> {
            startDate.clearFocus();
            ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(startDate.getWindowToken(), 0);

            showDatePickerDialog(START_DATE_TAG, listener);
        });

        lastActionDate.setOnClickListener(view -> {
            lastActionDate.clearFocus();
            ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(lastActionDate.getWindowToken(), 0);

            showDatePickerDialog(LAST_ACTION_DATE_TAG, listener);
        });
    }

    private void hideKeyboard(EditText editText) {
        editText.setCursorVisible(false);
        editText.setFocusableInTouchMode(false);
        editText.setFocusable(false);
    }

    private void showDatePickerDialog(String tag, DatePickerDialog.OnDateSetListener listener) {

        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog picker = new DatePickerDialog(getActivity(), listener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        picker.getDatePicker().setTag(tag);
        picker.show();
    }

    private void saveTrialData() {
        Trial trial = new Trial();
        trial.setUserId(1);
        trial.setTrialNumber(Integer.parseInt(strTrialNumber));
        trial.setStartDate(strStartDate);
        trial.setLastActionDate(strLastActionDate);

        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
        TrialDao trialDao = daoSession.getTrialDao();
        lastTrialInsertedId = trialDao.insert(trial);
    }

    private boolean checkPermissionForWriteExternalStorage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int result = getActivity().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            return result == PackageManager.PERMISSION_GRANTED;
        }
        return false;
    }

    private void exportSignalsToCSV() {

        if (!checkPermissionForWriteExternalStorage()) {
            ActivityCompat.requestPermissions(
                    getActivity(),
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    EXTERNAL_STORAGE_PERMISSION_CODE
            );
        }

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
                    CSVUtil.exportSignalsToCSV(getActivity());
                } catch (Exception e) {
                    statusOnUiThread(e.getMessage());
                } finally {
                    getActivity().runOnUiThread(() -> {
                        progressDialog.dismiss();
                    });
                }
            }
        };

        thread.start();
    }

    /*
     * Handler to send command after x milliseconds
     */
    private void initHandler() {
        if (service == null) {
            Toast.makeText(getActivity(), "Serial service is not connected yet. Please try later.", Toast.LENGTH_LONG).show();
            return;
        }

        stopHandler();

        threadPoolExecutor = new ScheduledThreadPoolExecutor(2);
        threadPoolExecutor.scheduleAtFixedRate(() -> {
            showCounterOnScreen();
            sendGetSignalsCommand();
        }, 0L, 20L, TimeUnit.MILLISECONDS);
    }

    private void stopHandler() {
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
            threadPoolExecutor = null;
        }
    }

    private void initHandlerForReceivingSignals() {
        mReceiveSignalHandlerThread = new HandlerThread(RECEIVE_SIGNAL_HANDLER_THREAD_NAME);
        mReceiveSignalHandlerThread.start();
        mReceiveSignalHandler = new Handler(mReceiveSignalHandlerThread.getLooper());
    }

    private void stopHandlerForReceivingSignals() {
        if (mReceiveSignalHandler != null) {
            mReceiveSignalHandler.removeCallbacksAndMessages(null);
            mReceiveSignalHandlerThread.quitSafely();
        }
    }

    private void sendGetSignalsCommand() {
        if (service != null) {
            TrivelProtocol.Command command = TrivelProtocol.Command.newBuilder().setAction(TrivelProtocol.Command.Action.GetSignals).build();

            sendCommandToSerialPort(command);
        }
    }

    /*
     * Serial + UI
     */
    private void connect() {
        connect(null);
    }

    private void connect(Boolean permissionGranted) {
        UsbDevice device = null;
        UsbManager usbManager = (UsbManager) getActivity().getSystemService(Context.USB_SERVICE);
        for (UsbDevice v : usbManager.getDeviceList().values())
            if (v.getDeviceId() == deviceId)
                device = v;
        if (device == null) {
            status("connection failed: device not found");
            return;
        }
        UsbSerialDriver driver = UsbSerialProber.getDefaultProber().probeDevice(device);
        if (driver == null) {
            driver = CustomProber.getCustomProber().probeDevice(device);
        }
        if (driver == null) {
            status("connection failed: no driver for device");
            return;
        }
        if (driver.getPorts().size() < portNum) {
            status("connection failed: not enough ports at device");
            return;
        }
        usbSerialPort = driver.getPorts().get(portNum);
        UsbDeviceConnection usbConnection = usbManager.openDevice(driver.getDevice());
        if (usbConnection == null && permissionGranted == null && !usbManager.hasPermission(driver.getDevice())) {
            PendingIntent usbPermissionIntent = PendingIntent.getBroadcast(getActivity(), 0, new Intent(Constants.INTENT_ACTION_GRANT_USB), 0);
            usbManager.requestPermission(driver.getDevice(), usbPermissionIntent);
            return;
        }
        if (usbConnection == null) {
            if (!usbManager.hasPermission(driver.getDevice()))
                status("connection failed: permission denied");
            else
                status("connection failed: open failed");
            return;
        }

        connected = Connected.Pending;
        try {
            usbSerialPort.open(usbConnection);
            usbSerialPort.setParameters(baudRate, UsbSerialPort.DATABITS_8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE);
            SerialSocket socket = new SerialSocket(getActivity().getApplicationContext(), usbConnection, usbSerialPort);
            service.connect(socket);
            // usb connect is not asynchronous. connect-success and connect-error are returned immediately from socket.connect
            // for consistency to bluetooth/bluetooth-LE app use same SerialListener and SerialService classes
            onSerialConnect();
        } catch (Exception e) {
            onSerialConnectError(e);
        }
    }

    private void disconnect() {
        connected = Connected.False;
        controlLines.stop();
        service.disconnect();
        usbSerialPort = null;
    }

    private void send(String str) {
        try {
            if (connected != Connected.True) {
                Toast.makeText(getActivity(), "not connected", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtil.isEmpty(str)) {
                Toast.makeText(getActivity(), "Please enter command to continue", Toast.LENGTH_LONG).show();
                return;
            }

            TrivelProtocol.Command command = createCommand(str);

            if (command == null) return;

            appendTextToScreen(str);
            sendCommandToSerialPort(command);
        } catch (Exception e) {
            status(e.getMessage());
        }
    }

    private void sendCommandToSerialPort(TrivelProtocol.Command command) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            command.writeDelimitedTo(outputStream);
            service.write(outputStream.toByteArray());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            getActivity().runOnUiThread(() -> onSerialIoError(e));
        }
    }

    @Nullable
    private TrivelProtocol.Command createCommand(String str) {
        String[] tokens = str.split(" ");
        String firstCommand = tokens[0];
        TrivelProtocol.Command command = null;

        switch (firstCommand.toLowerCase()) {
            case "g":
                command = TrivelProtocol.Command.newBuilder().setAction(TrivelProtocol.Command.Action.GetSignals).build();
                break;

            case "i":
                command = TrivelProtocol.Command.newBuilder().setAction(TrivelProtocol.Command.Action.Idle).build();
                break;

            case "c":
                command = TrivelProtocol.Command.newBuilder().setAction(TrivelProtocol.Command.Action.StartCalibration).build();
                break;

            case "road":
                double gain = tokens.length == 2 ? Double.parseDouble(tokens[1]) : 1;
                command = TrivelProtocol.Command.newBuilder()
                        .setAction(TrivelProtocol.Command.Action.SetRoadfeel)
                        .setRoadfeelSettings(
                                TrivelProtocol.RoadfeelSettings.newBuilder().setGain(gain))
                        .build();
                break;

            // "cycling [torque] [gain] [phase]"
            case "cycling":
                if (tokens.length != 4) {
                    throw new IllegalArgumentException("Cycling command expects 4 parameters. Command format should be 'cycling [torque] [gain] [phase]'");
                }

                TrivelProtocol.Command.Builder cycling_builder = TrivelProtocol.Command.newBuilder()
                        .setAction(TrivelProtocol.Command.Action.SetResistanceMode)
                        .setResistanceSettings(TrivelProtocol.ResistanceSettings.newBuilder()
                                .setDamping(Constants.Resistance.DAMPING)
                                .setInertia(Double.parseDouble(tokens[1]))
                                .setPostionSettingsEnable(true))
                        .setTimeOscillatorSettings(TrivelProtocol.OscillatorSettings.newBuilder()
                                .setGain(Double.parseDouble(tokens[2])))
                        .setTimeOscillatorSettings(TrivelProtocol.OscillatorSettings.newBuilder()
                                .setPhase(Double.parseDouble(tokens[3])));

                command = cycling_builder.build();
                break;

            // "a"
            // "a [cadence]"
            // "a [cadence] [ratio period]"
            case "a":
                TrivelProtocol.Command.Builder builder = TrivelProtocol.Command.newBuilder()
                        .setAction(TrivelProtocol.Command.Action.SetAssistedMode)
                        .setResistanceSettings(
                                TrivelProtocol.ResistanceSettings.newBuilder().setPostionSettingsEnable(false).build()
                        )
                        .setAssistanceSettings(
                                TrivelProtocol.AssistanceSettings.newBuilder().setCadence(0))
                        .setTimeOscillatorSettings(
                                TrivelProtocol.OscillatorSettings.newBuilder().setGain(1).setPeriod(1));

                if (tokens.length == 2 || tokens.length == 4) {
                    builder.clearAssistanceSettings()
                            .setAssistanceSettings(
                                    TrivelProtocol.AssistanceSettings.newBuilder().setCadence(Double.parseDouble(tokens[1])));
                }
                if (tokens.length == 4) {
                    builder.clearTimeOscillatorSettings()
                            .setTimeOscillatorSettings(
                                    TrivelProtocol.OscillatorSettings.newBuilder()
                                            .setGain(Double.parseDouble(tokens[2]))
                                            .setPeriod(Double.parseDouble(tokens[3])));
                }
                command = builder.build();
                break;

            // "r"
            // "r [damping inertia]"
            // "r [damping inertia] t [ratio period]"
            // "r [damping inertia] p [ratio bias]"
            case "r":
                TrivelProtocol.Command.Builder rBuilder = TrivelProtocol.Command.newBuilder()
                        .setAction(TrivelProtocol.Command.Action.SetResistanceMode)
                        .setResistanceSettings(
                                TrivelProtocol.ResistanceSettings.newBuilder()
                                        .setDamping(Constants.Resistance.DAMPING)
                                        .setInertia(Constants.Resistance.INERTIA)
                                        .setTorque(Constants.Resistance.TORQUE)
                                        .setPostionSettingsEnable(false)
                                        .setPositionOscillatorSettings(
                                                TrivelProtocol.OscillatorSettings.newBuilder()
                                                        .setGain(1)
                                                        .setPhase(0)));

                if (tokens.length == 2) {
                    rBuilder.getResistanceSettingsBuilder()
                            .setTorque(Double.parseDouble(tokens[1]));
                }

                if (tokens.length == 5) {
                    rBuilder.getResistanceSettingsBuilder()
                            .setTorque(Double.parseDouble(tokens[1]));

                    if (tokens[2].equalsIgnoreCase("p")) {
                        rBuilder.getResistanceSettingsBuilder()
                                .getPositionOscillatorSettingsBuilder()
                                .setGain(Double.parseDouble(tokens[3]))
                                .setPhase(Double.parseDouble(tokens[4]));

                    }
                }

                if (tokens.length == 3 || tokens.length == 6) {
                    rBuilder.getResistanceSettingsBuilder()
                            .setDamping(Double.parseDouble(tokens[1]))
                            .setInertia(Double.parseDouble(tokens[2]));
                }

                if (tokens.length == 6) {
                    if (tokens[3].equalsIgnoreCase("t")) {
                        rBuilder.setTimeOscillatorSettings(
                                TrivelProtocol.OscillatorSettings.newBuilder()
                                        .setGain(Double.parseDouble(tokens[4]))
                                        .setPeriod(Double.parseDouble(tokens[5])));
                    }
                    if (tokens[3].equalsIgnoreCase("p")) {
                        rBuilder.getResistanceSettingsBuilder()
                                .getPositionOscillatorSettingsBuilder()
                                .setGain(Double.parseDouble(tokens[4]))
                                .setPhase(Double.parseDouble(tokens[5]));
                    }
                }
                command = rBuilder.build();
                break;

            default:
                break;
        }
        return command;
    }

    private void appendTextToScreen(String str) {
        String msg;
        if (hexEnabled) {
            StringBuilder sb = new StringBuilder();
            TextUtil.toHexString(sb, TextUtil.fromHexString(str));
            TextUtil.toHexString(sb, newline.getBytes());
            msg = sb.toString();
        } else {
            msg = str;
        }
        SpannableStringBuilder spn = new SpannableStringBuilder(msg + '\n');
        spn.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorSendText)), 0, spn.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        receiveText.append(spn);
    }

    private void receive(byte[] data) {

        mReceiveSignalHandler.post(() -> {
            try {
                List<Signal> signals = new ArrayList<>();

                InputStream inputStream = new ByteArrayInputStream(data);
                TrivelProtocol.Reply reply = TrivelProtocol.Reply.parseDelimitedFrom(inputStream);

                DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
                TrialDataDao trialDataDao = daoSession.getTrialDataDao();
                SignalDao signalDao = daoSession.getSignalDao();

                String date = DateTimeUtil.toLocalDateTime(new Date());

                TrialData trialData = new TrialData();
                trialData.setTrialId(lastTrialInsertedId);
                trialData.setDeviceId(deviceId);
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

                if (counter >= 100) {
                    counter = 1;
                } else {
                    counter += 1;
                }

            } catch (InvalidProtocolBufferException e) {
                onExceptionOccurred("INVALID_PROTOCOL_BUFFER_EXCEPTION: " + e.getMessage());
            } catch (IOException e) {
                onExceptionOccurred("IO_EXCEPTION: " + e.getMessage());
            }
        });
    }

    void onExceptionOccurred(String msg) {
        isExceptionOccured = true;
        statusOnUiThread(msg);
        isExceptionOccured = false;
    }

    void statusOnUiThread(String str) {
        if (counter == 100 || isExceptionOccured) {
            getActivity().runOnUiThread(() -> {
                SpannableStringBuilder spn = new SpannableStringBuilder(str + '\n');
                spn.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorStatusText)), 0, spn.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                receiveText.append(spn);
            });
        }
    }

    void showCounterOnScreen() {
        if (counter == 100) {
            getActivity().runOnUiThread(() -> {
                SpannableStringBuilder spn = new SpannableStringBuilder(String.format(Locale.getDefault(), "Showing %dth value after 200 milliseconds", counter) + '\n');
                spn.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorStatusText)), 0, spn.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                receiveText.append(spn);
            });
        }
    }

    void status(String str) {
        SpannableStringBuilder spn = new SpannableStringBuilder(str + '\n');
        spn.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorStatusText)), 0, spn.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        receiveText.append(spn);
    }

    /*
     * SerialListener
     */
    @Override
    public void onSerialConnect() {
        status("connected");
        connected = Connected.True;
        if (controlLinesEnabled)
            controlLines.start();
    }

    @Override
    public void onSerialConnectError(Exception e) {
        status("connection failed: " + e.getMessage());
        disconnect();
    }

    @Override
    public void onSerialRead(byte[] data) {
        receive(data);
    }

    @Override
    public void onSerialIoError(Exception e) {
        status("connection lost: " + e.getMessage());
        disconnect();
    }

    class ControlLines {
        private static final int refreshInterval = 200; // msec

        private final Handler mainLooper;
        private final Runnable runnable;
        private final LinearLayout frame;
        private final ToggleButton rtsBtn, ctsBtn, dtrBtn, dsrBtn, cdBtn, riBtn;

        ControlLines(View view) {
            mainLooper = new Handler(Looper.getMainLooper());
            runnable = this::run; // w/o explicit Runnable, a new lambda would be created on each postDelayed, which would not be found again by removeCallbacks

            frame = view.findViewById(R.id.controlLines);
            rtsBtn = view.findViewById(R.id.controlLineRts);
            ctsBtn = view.findViewById(R.id.controlLineCts);
            dtrBtn = view.findViewById(R.id.controlLineDtr);
            dsrBtn = view.findViewById(R.id.controlLineDsr);
            cdBtn = view.findViewById(R.id.controlLineCd);
            riBtn = view.findViewById(R.id.controlLineRi);
            rtsBtn.setOnClickListener(this::toggle);
            dtrBtn.setOnClickListener(this::toggle);
        }

        private void toggle(View v) {
            ToggleButton btn = (ToggleButton) v;
            if (connected != Connected.True) {
                btn.setChecked(!btn.isChecked());
                Toast.makeText(getActivity(), "not connected", Toast.LENGTH_SHORT).show();
                return;
            }
            String ctrl = "";
            try {
                if (btn.equals(rtsBtn)) {
                    ctrl = "RTS";
                    usbSerialPort.setRTS(btn.isChecked());
                }
                if (btn.equals(dtrBtn)) {
                    ctrl = "DTR";
                    usbSerialPort.setDTR(btn.isChecked());
                }
            } catch (IOException e) {
                status("set" + ctrl + " failed: " + e.getMessage());
            }
        }

        private void run() {
            if (connected != Connected.True)
                return;
            try {
                EnumSet<UsbSerialPort.ControlLine> controlLines = usbSerialPort.getControlLines();
                rtsBtn.setChecked(controlLines.contains(UsbSerialPort.ControlLine.RTS));
                ctsBtn.setChecked(controlLines.contains(UsbSerialPort.ControlLine.CTS));
                dtrBtn.setChecked(controlLines.contains(UsbSerialPort.ControlLine.DTR));
                dsrBtn.setChecked(controlLines.contains(UsbSerialPort.ControlLine.DSR));
                cdBtn.setChecked(controlLines.contains(UsbSerialPort.ControlLine.CD));
                riBtn.setChecked(controlLines.contains(UsbSerialPort.ControlLine.RI));
                mainLooper.postDelayed(runnable, refreshInterval);
            } catch (IOException e) {
                status("getControlLines() failed: " + e.getMessage() + " -> stopped control line refresh");
            }
        }

        void start() {
            frame.setVisibility(View.VISIBLE);
            if (connected != Connected.True)
                return;
            try {
                EnumSet<UsbSerialPort.ControlLine> controlLines = usbSerialPort.getSupportedControlLines();
                if (!controlLines.contains(UsbSerialPort.ControlLine.RTS))
                    rtsBtn.setVisibility(View.INVISIBLE);
                if (!controlLines.contains(UsbSerialPort.ControlLine.CTS))
                    ctsBtn.setVisibility(View.INVISIBLE);
                if (!controlLines.contains(UsbSerialPort.ControlLine.DTR))
                    dtrBtn.setVisibility(View.INVISIBLE);
                if (!controlLines.contains(UsbSerialPort.ControlLine.DSR))
                    dsrBtn.setVisibility(View.INVISIBLE);
                if (!controlLines.contains(UsbSerialPort.ControlLine.CD))
                    cdBtn.setVisibility(View.INVISIBLE);
                if (!controlLines.contains(UsbSerialPort.ControlLine.RI))
                    riBtn.setVisibility(View.INVISIBLE);
                run();
            } catch (IOException e) {
                Toast.makeText(getActivity(), "getSupportedControlLines() failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        void stop() {
            frame.setVisibility(View.GONE);
            mainLooper.removeCallbacks(runnable);
            rtsBtn.setChecked(false);
            ctsBtn.setChecked(false);
            dtrBtn.setChecked(false);
            dsrBtn.setChecked(false);
            cdBtn.setChecked(false);
            riBtn.setChecked(false);
        }
    }
}
