package com.twotr.twotr.globalpackfiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.twotr.twotr.R;
import com.twotr.twotr.tutorfiles.HomePage;

public class SigninActivity extends AppCompatActivity {
    ImageButton IBsignin_back;
    Button Bsignin;
EditText ETusername,ETpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

Bsignin=findViewById(R.id.signin_button);
        IBsignin_back=findViewById(R.id.signin_back);
        ETusername=findViewById(R.id.username_signin);
        ETpassword=findViewById(R.id.password_signin);

        ETusername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ETusername.setBackgroundResource( R.drawable.edittext_selected);
                }
                else
                {
                    ETusername.setBackgroundResource( R.drawable.edittext_unselected);

                }
            }
        });
        ETpassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ETpassword.setBackgroundResource( R.drawable.edittext_selected);
                }
                else
                {
                    ETpassword.setBackgroundResource( R.drawable.edittext_unselected);

                }
            }
        });

        IBsignin_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
Bsignin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(SigninActivity.this, HomePage.class));

    }
});
    }

}
