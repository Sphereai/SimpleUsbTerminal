package de.kai_morich.usb_terminal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private View progressView;
    private ProgressBar progressBar;
    private TextView progressTextView;
    private TextView maxTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        progressView = findViewById(R.id.progress_layout);
        progressBar = findViewById(R.id.progress_bar);
        progressTextView = findViewById(R.id.txt_progress);
        maxTextView = findViewById(R.id.txt_max);

        setSupportActionBar(toolbar);
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().add(R.id.fragment, new DevicesFragment(), "devices").commit();

            /*
            Bundle args = new Bundle();
            args.putInt("device", 1218);
            args.putInt("port", 80);
            args.putInt("baud", 100);
            TerminalFragment terminalFragment = new TerminalFragment();
            terminalFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment, terminalFragment, "terminal").commit();
            */
            getSupportFragmentManager().beginTransaction().add(R.id.fragment, new CounterFragment(), "counter").commit();
        } else {
            onBackStackChanged();
        }
    }

    @Override
    public void onBackStackChanged() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(getSupportFragmentManager().getBackStackEntryCount()>0);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(intent.getAction())) {
            TerminalFragment terminal = (TerminalFragment)getSupportFragmentManager().findFragmentByTag("terminal");
            if (terminal != null)
                terminal.status("USB device detected");
        }
        super.onNewIntent(intent);
    }

    public void showProgressBar(boolean visible) {
        progressView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setMaxValue(int max) {
        progressBar.setMax(max);
        maxTextView.setText(String.valueOf(max));
    }

    public void setProgressValue(int progress) {
        progressBar.setProgress(progress, true);
        progressTextView.setText(String.valueOf(progress));
    }
}
