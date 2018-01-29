package com.twotr.twotr.tutorfiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.twotr.twotr.R;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class ScheduleStart extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

ListView LVtimeslot;
    HorizontalCalendar horizontalCalendar;
    TextView TVstart_time,TVendtime,TVsub_name;
    private TimePickerDialog tpd;
    String Svalidatetime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_start);

/** end after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
//LVtimeslot=findViewById(R.id.time_slot);
/** start before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DATE, 0);
TVstart_time=findViewById(R.id.start_time_slot);
TVendtime=findViewById(R.id.end_time_slot);
TVsub_name=findViewById(R.id.subject_name);

        Intent intent = getIntent();
        Bundle Bintent = intent.getExtras();
        if(Bintent != null)
        {
            String subname = (String) Bintent.get("sub_name");
            TVsub_name.setText(subname);

        }

        Calendar now = Calendar.getInstance();

        tpd = TimePickerDialog.newInstance(
                ScheduleStart.this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                true

        );
TVstart_time.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Svalidatetime="starttime";
    tpd.show(getFragmentManager(),"starttime");
        tpd.setTitle("Start Time");

    }
});
TVendtime.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Svalidatetime="endtime";

        tpd.show(getFragmentManager(),"End Time");
        tpd.setTitle("End Time");
    }
});
         horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(6)
                .build();
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                //do something
            }
        });
//        // Initializing a new String Array
//        String[] fruits = new String[] {
//                "Cape Gooseberry",
//                "Capuli cherry"
//        };
//
//        // Create a List from String Array elements
//        final List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits));
//
//        // Create an ArrayAdapter from List
//        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
//                (this, android.R.layout.simple_list_item_1, fruits_list);
//
//        // DataBind ListView with items from ArrayAdapter
//        LVtimeslot.setAdapter(arrayAdapter);



    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String time = hourOfDay+":"+minute;
        if (Svalidatetime.equals("starttime"))
        TVstart_time.setText(time);
        else
        {
            TVendtime.setText(time);

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
