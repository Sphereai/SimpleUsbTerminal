package de.kai_morich.usb_terminal.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.kai_morich.usb_terminal.R;
import de.kai_morich.usb_terminal.entities.Trial;
import de.kai_morich.usb_terminal.view_holders.BaseViewHolder;
import de.kai_morich.usb_terminal.view_holders.ProgressViewHolder;
import de.kai_morich.usb_terminal.view_holders.TrialViewHolder;

public class TrialAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Trial> mTrials;
    private boolean isLoaderVisible = false;

    private static final int VIEW_TYPE_LOADING = 0;
    private static final int VIEW_TYPE_NORMAL = 1;

    public TrialAdapter(List<Trial> trials) {
        mTrials = trials;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new TrialViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trial, parent, false));
            case VIEW_TYPE_LOADING:
                return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        Trial trial = mTrials.get(position);
        if (getItemViewType(position) == VIEW_TYPE_NORMAL) {
            TrialViewHolder trialViewHolder = (TrialViewHolder) holder;
            trialViewHolder.bind(trial);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isLoaderVisible) {
            return position == mTrials.size() - 1 ? VIEW_TYPE_LOADING : VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_NORMAL;
        }
    }

    @Override
    public int getItemCount() {
        return mTrials == null ? 0 : mTrials.size();
    }

    public void addTrial(Trial trial) {
        mTrials.add(trial);
        notifyItemInserted(mTrials.size() - 1);
    }

    public void addAllTrials(List<Trial> trials) {
        for (Trial trial : trials) {
            addTrial(trial);
        }
    }

    public void addLoading() {
        isLoaderVisible = true;
        mTrials.add(new Trial());
        notifyItemInserted(mTrials.size() - 1);
    }

    public void removeLoading() {
        isLoaderVisible = false;
        int position = mTrials.size() - 1;
        Trial trial = getItem(position);
        if (trial != null) {
            mTrials.remove(position);
            notifyItemRemoved(position);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clear() {
        mTrials.clear();
        notifyDataSetChanged();
    }

    public Trial getItem(int position) {
        return mTrials.get(position);
    }
}
