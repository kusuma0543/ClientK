package com.twotr.twotr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fujiyuu75.sequent.Direction;
import com.fujiyuu75.sequent.Sequent;

public class MainActivity extends AppCompatActivity {
RelativeLayout layout;
TextView signupbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout =  findViewById(R.id.rel_layout);
       Sequent.origin(layout).anim(getApplicationContext(), com.fujiyuu75.sequent.Animation.FADE_IN_UP).start();
        signupbut=findViewById(R.id.sign_up);
        signupbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
            }
        });

    }

}
