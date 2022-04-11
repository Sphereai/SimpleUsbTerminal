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

import de.kai_morich.usb_terminal.adapters.TrialAdapter;
import de.kai_morich.usb_terminal.entities.Trial;
import de.kai_morich.usb_terminal.entities.TrialDao;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class TrialFragment extends Fragment {

    private int currentPage = 0;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private TrialAdapter mTrialAdapter;

    private TrialDao mTrialDao;

    private RecyclerView mRecyclerView;

    public TrialFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mTrialDao = ((App)getActivity().getApplication()).getDaoSession().getTrialDao();

        View view = inflater.inflate(R.layout.fragment_trial, container, false);
        mRecyclerView = view.findViewById(R.id.trial_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mTrialAdapter = new TrialAdapter(new ArrayList<>());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mTrialAdapter);

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
        List<Trial> trials = getTrials();
        int totalPages = getTotalPageCount();
        mTrialAdapter.addAllTrials(trials);

        if (currentPage < totalPages) {
            mTrialAdapter.addLoading();
        } else {
            isLastPage = true;
        }
    }

    private void loadNextPage() {
        mTrialAdapter.removeLoading();
        isLoading = false;

        List<Trial> trials = getTrials();
        int totalPages = getTotalPageCount();
        mTrialAdapter.addAllTrials(trials);

        if (currentPage != totalPages) {
            mTrialAdapter.addLoading();
        } else {
            isLastPage = true;
        }
    }

    private List<Trial> getTrials() {
        QueryBuilder<Trial> queryBuilder = mTrialDao.queryBuilder();
        queryBuilder.limit(Constants.PAGE_SIZE);
        queryBuilder.offset(currentPage * Constants.PAGE_SIZE);
        return queryBuilder.list();
    }

    private int getTotalPageCount() {
        QueryBuilder<Trial> queryBuilder = mTrialDao.queryBuilder();
        long count = queryBuilder.count();
        return (int) Math.ceil(count/Constants.PAGE_SIZE);
    }
}