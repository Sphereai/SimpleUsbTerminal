package de.kai_morich.usb_terminal.view_holders;

import android.view.View;
import android.widget.ProgressBar;

import de.kai_morich.usb_terminal.R;

public class ProgressViewHolder extends BaseViewHolder {

    public ProgressViewHolder(View itemView) {
        super(itemView);
        ProgressBar progressBar = itemView.findViewById(R.id.progress_bar);
    }
}
