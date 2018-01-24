package com.twotr.twotr.tutorfiles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twotr.twotr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorSettings extends Fragment {


    public static TutorSettings newInstance() {
        TutorSettings fragment= new TutorSettings();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutor_settings, container, false);
    }

}
