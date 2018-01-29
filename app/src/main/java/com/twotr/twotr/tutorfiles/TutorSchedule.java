package com.twotr.twotr.tutorfiles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.twotr.twotr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorSchedule extends Fragment {

private Button Bhistory,Bupcoming;
    public static TutorSchedule newInstance() {
        TutorSchedule fragment= new TutorSchedule();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view= inflater.inflate(R.layout.fragment_tutor_schedule, container, false);

     Bhistory=view.findViewById(R.id.history_button);
     Bupcoming=view.findViewById(R.id.upcoming_button);


     Bhistory.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Bhistory.setTextColor(getResources().getColor(R.color.colorAccent));
             Bupcoming.setTextColor(getResources().getColor(R.color.colorPrimary));


         }
     });
     Bupcoming.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Bupcoming.setTextColor(getResources().getColor(R.color.colorAccent));
             Bhistory.setTextColor(getResources().getColor(R.color.colorPrimary));


         }
     });

     return view;
    }

}
