package com.twotr.twotr.tutorfiles;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.twotr.twotr.R;

public class Profile_Page extends AppCompatActivity {
    Button but_personal,but_educational,but_professional,but_profile_edit;
    ScrollView scrollview_personal,scrollView_educational,scrollview_professional;
    String s_profile;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        but_personal=findViewById(R.id.prof_but_personal);
        but_educational=findViewById(R.id.prof_nut_educational);
        but_professional=findViewById(R.id.prof_but_professional);
        scrollview_personal=findViewById(R.id.srcollview_personal);
        but_profile_edit=findViewById(R.id.profile_edit);
        scrollView_educational=findViewById(R.id.srcollview_educational);
        scrollview_professional=findViewById(R.id.srcollview_professional);
        s_profile="personal";
        but_personal.setTextColor(getColor(R.color.buttonColorPrimary));
        but_personal.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                s_profile="personal";
                but_personal.setTextColor(getColor(R.color.buttonColorPrimary));
                but_educational.setTextColor(getColor(R.color.colorwhite));
                but_professional.setTextColor(getColor(R.color.colorwhite));
                scrollview_personal.setVisibility(View.VISIBLE);
                scrollView_educational.setVisibility(View.GONE);
                scrollview_professional.setVisibility(View.GONE);

            }
        });
        but_educational.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                s_profile="educational";
                but_educational.setTextColor(getColor(R.color.buttonColorPrimary));
                but_personal.setTextColor(getColor(R.color.colorwhite));
                but_professional.setTextColor(getColor(R.color.colorwhite));
                scrollView_educational.setVisibility(View.VISIBLE);
                scrollview_personal.setVisibility(View.GONE);
                scrollview_professional.setVisibility(View.GONE);
            }
        });
        but_professional.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                s_profile="professional";
                but_professional.setTextColor(getColor(R.color.buttonColorPrimary));
                but_personal.setTextColor(getColor(R.color.colorwhite));
                but_educational.setTextColor(getColor(R.color.colorwhite));
                scrollview_professional.setVisibility(View.VISIBLE);
                scrollview_personal.setVisibility(View.GONE);
                scrollView_educational.setVisibility(View.GONE);
            }
        });
        but_profile_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s_profile.matches("personal")||s_profile.equals("personal"))
                {
                    startActivity(new Intent(Profile_Page.this,Profile_Edit_Personal.class));
                }
                 else if(s_profile.matches("educational")||s_profile.equals("educational"))
                {
                    startActivity(new Intent(Profile_Page.this,Profile_Edit_Educational.class));
                }
                else if(s_profile.matches("professional")||s_profile.equals("professional"))
                {
                    startActivity(new Intent(Profile_Page.this,Profile_Edit_Professional.class));
                }
            }
        });


    }

}
