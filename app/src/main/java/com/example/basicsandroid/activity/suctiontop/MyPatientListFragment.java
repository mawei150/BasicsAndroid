package com.example.basicsandroid.activity.suctiontop;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basicsandroid.R;


public class MyPatientListFragment extends Fragment {



    public MyPatientListFragment() {
        // Required empty public constructor
    }

    public static MyPatientListFragment newInstance(String param1, String param2) {
        MyPatientListFragment fragment = new MyPatientListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_patient_list, container, false);
    }


}
