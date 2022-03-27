package de.kai_morich.usb_terminal.view_holders;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import de.kai_morich.usb_terminal.R;
import de.kai_morich.usb_terminal.entities.Signal;

public class SignalViewHolder extends BaseViewHolder {

    private final TextView signalType;
    private final TextView signalDate;
    private final TextView signalKey;
    private final TextView signalValue;
    private final TextView signalUnit;

    public SignalViewHolder(View itemView) {
        super(itemView);

        signalType = itemView.findViewById(R.id.type);
        signalDate = itemView.findViewById(R.id.date);
        signalKey = itemView.findViewById(R.id.key);
        signalValue = itemView.findViewById(R.id.value);
        signalUnit = itemView.findViewById(R.id.unit);
    }

    @SuppressLint("SimpleDateFormat")
    public void bind(Signal signal) {
        String date = "";
        if (signal.getDate() != null) {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(signal.getDate());
        }

        signalType.setText(String.format("Signal Type: %s", signal.getType()));
        signalDate.setText(date);
        signalKey.setText(String.format("Signal Key: %s", signal.getKey()));
        signalValue.setText(String.format("Signal Value: %s", signal.getValue()));
        signalUnit.setText(String.format("Signal Unit: %s", signal.getUnits()));
    }
}
