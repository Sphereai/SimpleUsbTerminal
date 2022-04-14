package de.kai_morich.usb_terminal.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.kai_morich.usb_terminal.R;
import de.kai_morich.usb_terminal.entities.TrialData;
import de.kai_morich.usb_terminal.view_holders.BaseViewHolder;
import de.kai_morich.usb_terminal.view_holders.ProgressViewHolder;
import de.kai_morich.usb_terminal.view_holders.TrialDataViewHolder;

public class TrialDataAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<TrialData> mTrialData;
    private boolean isLoaderVisible = false;

    private static final int VIEW_TYPE_LOADING = 0;
    private static final int VIEW_TYPE_NORMAL = 1;

    public TrialDataAdapter(List<TrialData> trialData) {
        mTrialData = trialData;
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new TrialDataViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trial_data, parent, false));
            case VIEW_TYPE_LOADING:
                return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        TrialData trialData = mTrialData.get(position);
        if (getItemViewType(position) == VIEW_TYPE_NORMAL) {
            TrialDataViewHolder viewHolder = (TrialDataViewHolder) holder;
            viewHolder.bind(trialData);
        }
    }

    @Override
    public int getItemCount() {
        return mTrialData == null ? 0 : mTrialData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isLoaderVisible) {
            return position == mTrialData.size() - 1 ? VIEW_TYPE_LOADING : VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_NORMAL;
        }
    }

    public void addTrialData(TrialData data) {
        mTrialData.add(data);
        notifyItemInserted(mTrialData.size() - 1);
    }

    public void addAllTrialData(List<TrialData> data) {
        for (TrialData d : data) {
            addTrialData(d);
        }
    }

    public void addLoading() {
        isLoaderVisible = true;
        mTrialData.add(new TrialData());
        notifyItemInserted(mTrialData.size() - 1);
    }

    public void removeLoading() {
        isLoaderVisible = false;
        int position = mTrialData.size() - 1;
        TrialData data = getItem(position);
        if (data != null) {
            mTrialData.remove(position);
            notifyItemRemoved(position);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clear() {
        mTrialData.clear();
        notifyDataSetChanged();
    }

    public TrialData getItem(int position) {
        return mTrialData.get(position);
    }
}
