package mx.develop.orp.sampleapp.presentation.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mx.develop.orp.sampleapp.R;
import mx.develop.orp.sampleapp.data.rest.model.InfiniteFeedInfo;
import mx.develop.orp.sampleapp.presentation.adapter.MainAdapter;
import mx.develop.orp.sampleapp.presentation.presenter.MainPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainFragmentView, MainAdapter.AdapterCallBack {

    private View view;
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private List<InfiniteFeedInfo> list;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);
        initCards();
        getList();
        return view;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onResponse(InfiniteFeedInfo response) {
        list.add(response);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(InfiniteFeedInfo feedInfo) {
        MainDetailFragment mainDetailFragment = (MainDetailFragment) getFragmentManager()
                .findFragmentByTag("MainFragmentDetail");
        if (mainDetailFragment == null) {
            mainDetailFragment = new MainDetailFragment();
            getFragmentManager()
                    .beginTransaction()
                    .hide(this)
                    .add(R.id.container_main_fragment, mainDetailFragment, "MainFragmentDetail")
                    .commit();
        } else {
            getFragmentManager()
                    .beginTransaction()
                    .hide(this)
                    .show(mainDetailFragment)
                    .commit();
        }
    }

    private void initCards() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        list = new ArrayList<>();
        //mList = Utils.loadInfiniteFeeds(getActivity());
        adapter = new MainAdapter(getActivity(), this, list);
        recyclerView.setAdapter(adapter);
    }

    private void getList() {
        new MainPresenter(this).getMainStuff("123");
    }
}
