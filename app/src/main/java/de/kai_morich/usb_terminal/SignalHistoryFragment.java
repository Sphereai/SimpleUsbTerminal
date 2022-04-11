package de.kai_morich.usb_terminal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import de.kai_morich.usb_terminal.adapters.SignalAdapter;
import de.kai_morich.usb_terminal.entities.Signal;
import de.kai_morich.usb_terminal.entities.SignalDao;


public class SignalHistoryFragment extends Fragment {

    private int mDeviceId;
    private int currentPage = 0;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private SignalAdapter mSignalAdapter;

    private SignalDao mSignalDao;

    private RecyclerView mRecyclerView;

    public SignalHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDeviceId = getArguments().getInt("device");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mSignalDao = ((App)getActivity().getApplication()).getDaoSession().getSignalDao();

        View view = inflater.inflate(R.layout.fragment_signal_history, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mSignalAdapter = new SignalAdapter(new ArrayList<>());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mSignalAdapter);

        mRecyclerView.addOnScrollListener(new PaginationScrollListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;
                loadNextPage();
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        loadFirstPage();
    }

    private void loadFirstPage() {
        List<Signal> signals = getSignals();
        int totalPages = getTotalPageCount();
        mSignalAdapter.addAllSignals(signals);

        if (currentPage < totalPages) {
            mSignalAdapter.addLoading();
        } else {
            isLastPage = true;
        }

    }

    private void loadNextPage() {
        mSignalAdapter.removeLoading();
        isLoading = false;

        List<Signal> signals = getSignals();
        int totalPages = getTotalPageCount();
        mSignalAdapter.addAllSignals(signals);

        if (currentPage != totalPages) {
            mSignalAdapter.addLoading();
        } else {
            isLastPage = true;
        }
    }

    private List<Signal> getSignals() {
        QueryBuilder<Signal> queryBuilder = mSignalDao.queryBuilder();
        queryBuilder.limit(Constants.PAGE_SIZE);
        queryBuilder.offset(currentPage * Constants.PAGE_SIZE);
        return queryBuilder.list();
    }

    private int getTotalPageCount() {
        QueryBuilder<Signal> queryBuilder = mSignalDao.queryBuilder();
        long count = queryBuilder.count();
        return (int) Math.ceil(count/Constants.PAGE_SIZE);
    }
}