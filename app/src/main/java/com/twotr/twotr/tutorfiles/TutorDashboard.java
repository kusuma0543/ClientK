package com.twotr.twotr.tutorfiles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twotr.twotr.R;

import pl.pawelkleczkowski.customgauge.CustomGauge;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorDashboard extends Fragment {

    private CustomGauge CGgauge;
    public static TutorDashboard newInstance() {
        TutorDashboard fragment= new TutorDashboard();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tutor_dashboard, container, false);

   CGgauge=view.findViewById(R.id.gauge2);

   CGgauge.setValue(60);

           return view;
    }

}
