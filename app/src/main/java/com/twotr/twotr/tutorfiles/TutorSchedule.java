package com.twotr.twotr.tutorfiles;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.twotr.twotr.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorSchedule extends Fragment {

private Button Bhistory,Bupcoming;
ListView LVschedule;
private  String schedule_list_url;
    public static TutorSchedule newInstance() {
        TutorSchedule fragment= new TutorSchedule();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view= inflater.inflate(R.layout.fragment_tutor_schedule, container, false);

     Bhistory=view.findViewById(R.id.history_button);
     Bupcoming=view.findViewById(R.id.upcoming_button);
LVschedule=view.findViewById(R.id.schedule_list);

         schedule_list_url = "http://twotr.com:4040/api/class/upcoming?page=1&size=10" ;
        new ScheduleAsyncList().execute(schedule_list_url);
     Bhistory.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             Bhistory.setBackgroundColor(getResources().getColor(R.color.colorAccent));
             Bupcoming.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
              schedule_list_url = " http://twotr.com:4040/api/class/history?page=1&size=10" ;
             new ScheduleAsyncList().execute(schedule_list_url);

         }
     });
     Bupcoming.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Bupcoming.setBackgroundColor(getResources().getColor(R.color.colorAccent));
             Bhistory.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//upcominglist(upcoming_url);

              schedule_list_url = "http://twotr.com:4040/api/class/upcoming?page=1&size=10" ;
             new ScheduleAsyncList().execute(schedule_list_url);

         }
     });

     return view;
    }


//    public void upcominglist(String upcoming_url)
//    {
//        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
//
//        StringRequest postRequest = new StringRequest(Request.Method.GET, upcoming_url,
//                new Response.Listener<String>()
//                {
//                    @Override
//                    public void onResponse(String response) {
//                        // response
//                        Log.d("Response", response);
//                    }
//                },
//                new Response.ErrorListener()
//                {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // TODO Auto-generated method stub
//                        Log.d("ERROR","error => "+error.toString());
//                    }
//                }
//        ) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String>  params = new HashMap<String, String>();
//                params.put("content-type", "application/json");
//                params.put("x-tutor-app-id", "tutor-app-ios");
//                params.put("authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVhM2MxZDY0MTE5OTBkMmMyNDRiNDI4OCIsInJvbGVzIjpbInR1dG9yIl0sImlhdCI6MTUxNzE1MTI4OCwiZXhwIjoxNTE4NDQ3Mjg4LCJqdGkiOiIxIn0.efviEAlmLRkBev5Ib4N35XaCZyzXinc1KJYgv9KM_Yo");
//
//                return params;
//            }
//        };
//        queue.add(postRequest);
  //  }`
public class Schedule_class extends ArrayAdapter {
    private List<Schedule_upcoming_list> ScheduleModeList;
    private int resource;
    Context context;
    private LayoutInflater inflater;

    Schedule_class(Context context, int resource, List<Schedule_upcoming_list> objects) {
        super(context, resource, objects);
        ScheduleModeList = objects;
        this.context = context;
        this.resource = resource;
        inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView,  ViewGroup parent) {
        final Schedule_class.ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(resource, null);
            holder = new Schedule_class.ViewHolder();

            holder.TVsubjectname = convertView.findViewById(R.id.sub_name_sched);
            holder.TVtypemenbers = convertView.findViewById(R.id.group_one_title);
       //     holder.TVstart_time = convertView.findViewById(R.id.hours_sched);

            convertView.setTag(holder);
        }//ino
        else {
            holder = (Schedule_class.ViewHolder) convertView.getTag();
        }
        Schedule_upcoming_list supl = ScheduleModeList.get(position);
        holder.TVsubjectname.setText(supl.getSubject());
        holder.TVtypemenbers.setText("("+supl.getType()+")");
       // holder.TVstart_time.setText(supl.getStart());


//        String strThatDay = holder.text_getingdate.getText().toString();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date d = null;
//        try {
//            d = formatter.parse(strThatDay);//catch exception
//        } catch (ParseException e) {
//
//            e.printStackTrace();
//        }
//        Calendar thatDay = Calendar.getInstance();
//        thatDay.setTime(d);
//        Calendar c = Calendar.getInstance();
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        String formattedDate = df.format(c.getTime());
//        long diff = c.getTimeInMillis() - thatDay.getTimeInMillis(); //result in millis
//        days = diff / (24 * 60 );
//        holder.text_dispdate.setText("accepted before "+days+" days");


        return convertView;
    }

    class ViewHolder {
        private TextView TVsubjectname;
        private TextView TVtypemenbers;
      //  private TextView TVstart_time;


    }
}


    public class ScheduleAsyncList extends AsyncTask<String, String, List<Schedule_upcoming_list>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //dialog.show();
        }

        @Override
        protected List<Schedule_upcoming_list> doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();

                connection.setRequestProperty("content-type","application/json");
                connection.setRequestProperty("x-tutor-app-id","tutor-app-ios");
                connection.setRequestProperty("authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVhM2MxZDY0MTE5OTBkMmMyNDRiNDI4OCIsInJvbGVzIjpbInR1dG9yIl0sImlhdCI6MTUxNzE1MTI4OCwiZXhwIjoxNTE4NDQ3Mjg4LCJqdGkiOiIxIn0.efviEAlmLRkBev5Ib4N35XaCZyzXinc1KJYgv9KM_Yo");
                connection.setRequestMethod("GET");
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder buffer = new StringBuilder();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String finalJson = buffer.toString();
                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("classes");

                List<Schedule_upcoming_list> milokilo = new ArrayList<>();
                Gson gson = new Gson();
                for (int i = 0; i < parentArray.length(); i++) {

                    JSONObject finalObject = parentArray.getJSONObject(i);
                    Schedule_upcoming_list catego = gson.fromJson(finalObject.toString(), Schedule_upcoming_list.class);
                    milokilo.add(catego);
                }
                return milokilo;
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(final List<Schedule_upcoming_list> ScheduleMode) {
            super.onPostExecute(ScheduleMode);
            
            if (ScheduleMode!= null)
            {
                Schedule_class adapter = new Schedule_class(getActivity(), R.layout.schedule_list, ScheduleMode);
                LVschedule.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }


            }
        }
    

}
