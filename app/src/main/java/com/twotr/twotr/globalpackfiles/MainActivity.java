package com.twotr.twotr.globalpackfiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fujiyuu75.sequent.Sequent;
import com.twotr.twotr.R;

public class MainActivity extends AppCompatActivity {
RelativeLayout layout;
TextView signupbut;
Button Bsignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout =  findViewById(R.id.rel_layout);
       Sequent.origin(layout).anim(getApplicationContext(), com.fujiyuu75.sequent.Animation.FADE_IN_UP).start();
        signupbut=findViewById(R.id.sign_up);
        Bsignin=findViewById(R.id.main_signin);
        Bsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SigninActivity.class));

            }
        });
        signupbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
            }
        });
//hello
    }

}
