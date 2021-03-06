package com.twotr.twotr.tutorfiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twotr.twotr.R;

public class ScheduleDetailPage extends AppCompatActivity {
TextView TVsubject_name,TVtypesubject,TVprice_amount;
EditText ETsched_desc;
ImageButton IBedit_sched,IBpre_post;
LinearLayout linear_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_detail_page);
 IBedit_sched=findViewById(R.id.edit_desc_sched);
        TVsubject_name=findViewById(R.id.subject_name);
        TVtypesubject=findViewById(R.id.type_detail_subject);
        ETsched_desc=findViewById(R.id.schedule_description);
        TVprice_amount=findViewById(R.id.price_amount);
        IBpre_post=findViewById(R.id.add_pre_post);
        linear_layout=findViewById(R.id.post_pre_linear);

        ETsched_desc.setEnabled(false);
        Intent intent = getIntent();
        Bundle Bintent = intent.getExtras();
        if(Bintent != null)
        {
            String subname = (String) Bintent.get("subject_name");
            String type_subject = (String) Bintent.get("type_subject");
            String sched_descr = (String) Bintent.get("schedule_description");
            String sched_price = (String) Bintent.get("schedule_price");
TVprice_amount.setText(sched_price);
            TVtypesubject.setText(type_subject);
            TVsubject_name.setText(subname);
            ETsched_desc.setText(sched_descr);
        }
        IBedit_sched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ETsched_desc.setEnabled(true);
            }
        });
        IBpre_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
linear_layout.setVisibility(View.VISIBLE);
            }
        });
    }

}
