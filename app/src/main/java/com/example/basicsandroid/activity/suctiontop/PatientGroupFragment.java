package com.example.basicsandroid.activity.suctiontop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basicsandroid.R;

public class PatientGroupFragment extends Fragment {



    public PatientGroupFragment() {
        // Required empty public constructor
    }


    public static PatientGroupFragment newInstance(String param1, String param2) {
        PatientGroupFragment fragment = new PatientGroupFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patient_group, container, false);
    }

}
