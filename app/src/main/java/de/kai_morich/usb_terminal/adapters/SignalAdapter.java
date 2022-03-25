package de.kai_morich.usb_terminal.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.kai_morich.usb_terminal.R;
import de.kai_morich.usb_terminal.entities.Signal;
import de.kai_morich.usb_terminal.view_holders.BaseViewHolder;
import de.kai_morich.usb_terminal.view_holders.ProgressViewHolder;
import de.kai_morich.usb_terminal.view_holders.SignalViewHolder;

public class SignalAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Signal> mSignals;
    private boolean isLoaderVisible = false;

    private static final int VIEW_TYPE_LOADING = 0;
    private static final int VIEW_TYPE_NORMAL = 1;

    public SignalAdapter(List<Signal> signals) {
        mSignals = signals;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new SignalViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_signal, parent, false));
            case VIEW_TYPE_LOADING:
                return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        Signal signal = mSignals.get(position);
        if (getItemViewType(position) == VIEW_TYPE_NORMAL) {
            SignalViewHolder signalViewHolder = (SignalViewHolder) holder;
            signalViewHolder.bind(signal);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isLoaderVisible) {
            return position == mSignals.size() - 1 ? VIEW_TYPE_LOADING : VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_NORMAL;
        }
    }

    public void addSignal(Signal signal) {
        mSignals.add(signal);
        notifyItemInserted(mSignals.size() - 1);
    }

    public void addAllSignals(List<Signal> signals) {
        for (Signal signal: signals) {
            addSignal(signal);
        }
    }

    public void addLoading() {
        isLoaderVisible = true;
        mSignals.add(new Signal());
        notifyItemInserted(mSignals.size() - 1);
    }

    public void removeLoading() {
        isLoaderVisible = false;
        int position = mSignals.size() - 1;
        Signal signal = getItem(position);
        if (signal != null) {
            mSignals.remove(position);
            notifyItemRemoved(position);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clear() {
        mSignals.clear();
        notifyDataSetChanged();
    }

    public Signal getItem(int position) {
        return mSignals.get(position);
    }

    @Override
    public int getItemCount() {
        return mSignals == null ? 0 : mSignals.size();
    }
}
