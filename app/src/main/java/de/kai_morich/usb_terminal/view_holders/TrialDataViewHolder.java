package de.kai_morich.usb_terminal.view_holders;

import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

import de.kai_morich.usb_terminal.R;
import de.kai_morich.usb_terminal.entities.TrialData;

public class TrialDataViewHolder extends BaseViewHolder {


    private final TextView cadenceTV;
    private final TextView positionTV;
    private final TextView torqueTV;
    private final TextView powerTV;
    private final TextView dateTV;

    public TrialDataViewHolder(View itemView) {
        super(itemView);

        cadenceTV = itemView.findViewById(R.id.cadence);
        positionTV = itemView.findViewById(R.id.position);
        torqueTV = itemView.findViewById(R.id.torque);
        powerTV = itemView.findViewById(R.id.power);
        dateTV = itemView.findViewById(R.id.date);
    }

    public void bind(TrialData data) {

        String date = "";
        if (data.getDate() != null) {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(data.getDate());
        }

        cadenceTV.setText(String.format(Locale.getDefault(), "Cadence: %1$,.2f", data.getCadence()));
        positionTV.setText(String.format(Locale.getDefault(),"Position: %1$,.2f", data.getPosition()));
        torqueTV.setText(String.format(Locale.getDefault(),"Torque: %1$,.2f", data.getTorque()));
        powerTV.setText(String.format(Locale.getDefault(),"Power: %1$,.2f", data.getPower()));
        dateTV.setText(String.format("Date: %s", date));
    }
}
