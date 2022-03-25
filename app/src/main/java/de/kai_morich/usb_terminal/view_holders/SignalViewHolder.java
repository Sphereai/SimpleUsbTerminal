package de.kai_morich.usb_terminal.view_holders;

import android.view.View;
import android.widget.TextView;

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

    public void bind(Signal signal) {
        signalType.setText(signal.getType());
        signalDate.setText(signal.getDate().toString());
        signalKey.setText(signal.getKey());
        signalValue.setText(signal.getValue());
        signalUnit.setText(signal.getUnits());
    }
}
