package com.twotr.twotr.tutorfiles;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.twotr.twotr.R;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        BottomBar bottomBar =  findViewById(R.id.bottomBar);
        bottomBar.setDefaultTab(R.id.tab_dashboard);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                android.support.v4.app.Fragment selectedFragment = null;
                if (tabId == R.id.tab_schedules) {
                   // selectedFragment = NewJobs.newInstance();
                    Toast.makeText(HomePage.this, "hello", Toast.LENGTH_SHORT).show();
                }
                else if (tabId == R.id.tab_dashboard) {
                   // selectedFragment = OnGoingPartJobs.newInstance();
                    Toast.makeText(HomePage.this, "hello", Toast.LENGTH_SHORT).show();

                }
                else if (tabId == R.id.tab_create) {
                    //selectedFragment = FinishedPartJobs.newInstance();
                    Toast.makeText(HomePage.this, "hello", Toast.LENGTH_SHORT).show();

                }

                else if (tabId == R.id.tab_settings) {
                   // selectedFragment = OnGoing.newInstance();
                    Toast.makeText(HomePage.this, "hello", Toast.LENGTH_SHORT).show();

                }
// else if (tabId == R.id.tab_recharge) {
//                    selectedFragment = OnGoing.newInstance();
//                }

//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.contentContainer, selectedFragment);
//                transaction.commit();
            }
        });
    }

}
