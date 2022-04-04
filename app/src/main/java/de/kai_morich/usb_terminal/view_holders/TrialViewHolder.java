package de.kai_morich.usb_terminal.view_holders;

import android.view.View;
import android.widget.TextView;

import de.kai_morich.usb_terminal.R;
import de.kai_morich.usb_terminal.entities.Trial;

public class TrialViewHolder extends BaseViewHolder {

    private final TextView trialNumber;
    private final TextView dateStarted;
    private final TextView dateLastAction;

    public TrialViewHolder(View itemView) {
        super(itemView);

        trialNumber = itemView.findViewById(R.id.number);
        dateStarted = itemView.findViewById(R.id.date_started);
        dateLastAction = itemView.findViewById(R.id.date_last_action);
    }

    public void bind(Trial trial) {
        trialNumber.setText(String.valueOf(trial.getTrialNumber()));
        dateStarted.setText(trial.getStartDate());
        dateLastAction.setText(trial.getLastActionDate());
    }
}
