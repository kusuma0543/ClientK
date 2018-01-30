package com.twotr.twotr.tutorfiles;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.twotr.twotr.R;
import com.twotr.twotr.globalpackfiles.SigninActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorSettings extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    public static TutorSettings newInstance() {
        TutorSettings fragment= new TutorSettings();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
View view= inflater.inflate(R.layout.fragment_tutor_settings, container, false);
        drawer =view.findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            drawer.openDrawer(GravityCompat.END);
        }
//display(view);
return view;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            startActivity(new Intent(getActivity(), Profile_Page.class));

        }
        else if (id == R.id.nav_subscribe) {

        }
        else if (id == R.id.nav_ac_details) {

        }
        else if (id == R.id.nav_reminder) {

        }
        else if (id == R.id.nav_notifications) {

        }
        else if (id == R.id.nav_language) {

        }
        else if (id == R.id.nav_sign_out) {

        }
        else if (id == R.id.nav_about_us) {

        }
        else if (id == R.id.nav_terms_conditions) {

        }
        return true;
    }




}
