package com.twotr.twotr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignupActivity extends AppCompatActivity {
ImageButton IBsignup_back;
EditText ETusername,ETemail,ETpassword,ETconfirm_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

IBsignup_back=findViewById(R.id.signup_back);
ETusername=findViewById(R.id.username_signup);
ETemail=findViewById(R.id.email_signup);
ETpassword=findViewById(R.id.pass_signup);
ETconfirm_pass=findViewById(R.id.confpass_signup);


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
        ETemail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ETemail.setBackgroundResource( R.drawable.edittext_selected);
                }
                else
                {
                    ETemail.setBackgroundResource( R.drawable.edittext_unselected);

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
        ETconfirm_pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    ETconfirm_pass.setBackgroundResource( R.drawable.edittext_selected);
                }
                else
                {
                    ETconfirm_pass.setBackgroundResource( R.drawable.edittext_unselected);

                }
            }
        });


IBsignup_back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
 onBackPressed();

    }
});


    }

}
