package com.twotr.twotr.tutorfiles;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.twotr.twotr.R;

import com.wooplr.spotlight.SpotlightView;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorCreate extends Fragment {

private Button Boneonone,Bgroup,Baddsubject;
private EditText ETnofstu,ETtotalamount,ETminamount,ETshortins,ETgrade;
private TextView TVaddsched,TVaddmap;
private ImageView IVaddsch,IVaddmap;
private EditText ETtypesearch;
    public static TutorCreate newInstance() {
        TutorCreate fragment= new TutorCreate();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_tutor_create, container, false);

       Boneonone=view.findViewById(R.id.one_to_one);
       Bgroup=view.findViewById(R.id.group_button);
ETnofstu=view.findViewById(R.id.amount_create);
ETtotalamount=view.findViewById(R.id.total_amount_group);
ETminamount=view.findViewById(R.id.min_amount_group);
TVaddsched=view.findViewById(R.id.add_schedule_create);
TVaddmap=view.findViewById(R.id.add_map_create);
ETshortins=view.findViewById(R.id.shrot_des_create);
ETgrade=view.findViewById(R.id.grade_create);
IVaddsch=view.findViewById(R.id.hint_sched);
IVaddmap=view.findViewById(R.id.hint_map);
Baddsubject=view.findViewById(R.id.add_subject_create);
ETtypesearch=view.findViewById(R.id.type_search);


Boneonone.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Boneonone.setBackgroundResource(R.drawable.tab_button_selected);
        Bgroup.setBackgroundResource(R.drawable.tab_button_unselected);
        Boneonone.setTextColor(getResources().getColor(R.color.colorwhite));
        Bgroup.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        ETnofstu.setHint("No of Students");
        ETnofstu.setVisibility(View.VISIBLE);
        ETtotalamount.setVisibility(View.VISIBLE);
        ETminamount.setVisibility(View.VISIBLE);
        TVaddsched.setVisibility(View.VISIBLE);
        TVaddmap.setVisibility(View.VISIBLE);
        ETshortins.setVisibility(View.VISIBLE);
        ETgrade.setVisibility(View.VISIBLE);


    }
});

Bgroup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Bgroup.setBackgroundResource(R.drawable.tab_button_selected);
        Boneonone.setBackgroundResource(R.drawable.tab_button_unselected);
Bgroup.setTextColor(getResources().getColor(R.color.colorwhite));
        Boneonone.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        ETnofstu.setHint("Total Amount");
        ETnofstu.setVisibility(View.VISIBLE);
        ETtotalamount.setVisibility(View.GONE);
        ETminamount.setVisibility(View.GONE);
        TVaddsched.setVisibility(View.VISIBLE);
        TVaddmap.setVisibility(View.VISIBLE);
        ETshortins.setVisibility(View.VISIBLE);
        ETgrade.setVisibility(View.VISIBLE);

    }
});
        IVaddsch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String genrateach= UUID.randomUUID().toString();
                new SpotlightView.Builder(getActivity())
                        .introAnimationDuration(300)
                        //.enableRevealAnimation(isRevealEnabled)
                        .performClick(true)
                        .fadeinTextDuration(300)
                        .headingTvColor(Color.parseColor("#eb273f"))
                        .headingTvSize(32)
                        .headingTvText("Add Schedule")
                        .subHeadingTvColor(Color.parseColor("#ffffff"))
                        .subHeadingTvSize(16)
                        .subHeadingTvText("Add your Available Schedule time\nthis Will been shown to Users.")
                        .maskColor(Color.parseColor("#dc000000"))
                        .target(TVaddsched)
                        .lineAnimDuration(300)
                        .lineAndArcColor(Color.parseColor("#eb273f"))
                        .dismissOnTouch(true)
                        .dismissOnBackPress(true)
                        .enableDismissAfterShown(true)
.usageId(genrateach)
                        .show();

            }
        });

IVaddmap.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String genrate= UUID.randomUUID().toString();
        new SpotlightView.Builder(getActivity())
                .introAnimationDuration(300)
                //.enableRevealAnimation(isRevealEnabled)
                .performClick(true)
                .fadeinTextDuration(300)
                .headingTvColor(Color.parseColor("#eb273f"))
                .headingTvSize(32)
                .headingTvText("Add Map")
                .subHeadingTvColor(Color.parseColor("#ffffff"))
                .subHeadingTvSize(16)
                .subHeadingTvText("To add location of your\n class going to add.")
                .maskColor(Color.parseColor("#dc000000"))
                .target(TVaddmap)
                .lineAnimDuration(300)
                .lineAndArcColor(Color.parseColor("#eb273f"))
                .dismissOnTouch(true)
                .dismissOnBackPress(true)
                .enableDismissAfterShown(true)
.usageId(genrate)
                .show();
    }
});
TVaddmap.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Addmaptutor.class);
        startActivity(intent);
    }
});

TVaddsched.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String Ssubject_name=ETtypesearch.getText().toString();

        if (Ssubject_name.isEmpty())
        {
            Toast.makeText(getActivity(), "Type Subject Name", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(getActivity(), ScheduleStart.class);
            intent.putExtra("sub_name",Ssubject_name);
            startActivity(intent);
        }

    }
});
        return  view;
    }

}
