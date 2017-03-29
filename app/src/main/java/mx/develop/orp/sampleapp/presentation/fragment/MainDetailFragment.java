package mx.develop.orp.sampleapp.presentation.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.develop.orp.sampleapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainDetailFragment extends Fragment {


    public MainDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_detail, container, false);
    }

}
