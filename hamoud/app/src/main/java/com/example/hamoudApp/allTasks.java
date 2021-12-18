package com.example.hamoudApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hamoudApp.Config.Config;
import com.example.hamoudApp.adapters.TaskAdapter;
import com.example.hamoudApp.models.myTaskModelList;
import com.example.hamoudApp.models.oneTask;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

public class allTasks extends AppCompatActivity implements TaskAdapter.OnTaskListener{
    private List<myTaskModelList> myLists;
    private List<oneTask> tasksWithInfo ;
    private TaskAdapter adapter;
    RecyclerView recyclerView;
    HashMap<String, String> profileInfo = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);

        recyclerView=(RecyclerView)findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myLists=new ArrayList<>();
        //getdo();
        tasksBuilder();
    }
    private void getdo() {

        myLists.add(new myTaskModelList(R.drawable.profile,"arwa7 lel bureau","2021-09.09","10:00"));
        myLists.add(new myTaskModelList(R.drawable.profile,"come to the office","2021-09.09","10:00"));
        myLists.add(new myTaskModelList(R.drawable.profile,"kharedj l'imprimante","2021-09.09","10:00"));
        myLists.add(new myTaskModelList(R.drawable.profile,"jibe lewra9e","2021-09.09","10:00"));
        myLists.add(new myTaskModelList(R.drawable.profile,"recuperer swared","2021-09.09","10:00"));
        myLists.add(new myTaskModelList(R.drawable.profile,"weshiwa lyoume","2021-09.09","10:00"));
        myLists.add(new myTaskModelList(R.drawable.profile,"khedmet sba7e","2021-09.09","10:00"));
        myLists.add(new myTaskModelList(R.drawable.profile,"khedmet sba7e","2021-09.09","10:00"));
        myLists.add(new myTaskModelList(R.drawable.profile,"khedmet sba7e","2021-09.09","10:00"));
        myLists.add(new myTaskModelList(R.drawable.profile,"khedmet sba7e","2021-09.09","10:00"));
        adapter=new TaskAdapter(myLists,this,  this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onTaskClick(int position) {
        //Toasty.warning(getApplicationContext(), position+"", Toast.LENGTH_SHORT, true).show();
        if (!tasksWithInfo.isEmpty()){
            Intent intent = new Intent(allTasks.this, TaskDetails.class);
            intent.putExtra("id_inf",tasksWithInfo.get(position).getIdTask());
            intent.putExtra("title_inf",tasksWithInfo.get(position).getTitle());
            intent.putExtra("date_inf",tasksWithInfo.get(position).getDate());
            intent.putExtra("time_inf",tasksWithInfo.get(position).getTime());
            intent.putExtra("msg_inf",tasksWithInfo.get(position).getMessage());
            intent.putExtra("vocal_path_inf",tasksWithInfo.get(position).getVocal_path());
            startActivity(intent);
        }else {
            Toasty.warning(getApplicationContext(), position+" No data to show ", Toast.LENGTH_SHORT, true).show();
        }


    }
    private void tasksBuilder() {
        Date dateandtime = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String today = dateFormat.format(dateandtime);
        String value = today;

        if (value.equals("")) {
            Toast.makeText(this, "Please Enter Data Value", Toast.LENGTH_LONG).show();
            return;
        }

        String url = Config.TASKS_DATA_URL + "2021-09-13";//today.trim();
        String dateend = "2021-09-17";
        url = url + "&dateend=" + dateend ;


        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(allTasks.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response) {
        tasksWithInfo=new ArrayList<>();
        //ArrayList<String> titlesTest = new ArrayList<String>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String id_task  = jo.getString(Config.KEY_IDTASK);
                String title = jo.getString(Config.KEY_TITLE);
                String date = jo.getString(Config.KEY_DATE);
                String time = jo.getString(Config.KEY_TIME);
                String msg = jo.getString(Config.KEY_MSG);
                String vocal_path = jo.getString(Config.KEY_VOCAL);
                //titlesTest.add(title);
                tasksWithInfo.add(new oneTask(id_task , title , date , time , msg , vocal_path));
                myLists.add(new myTaskModelList(R.drawable.profile,title,date,time));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        String testFunction = getSpecificPreviousDateFromToday(10);
        Toast.makeText(this, testFunction, Toast.LENGTH_SHORT).show();
        if (myLists.isEmpty()){
            Toasty.warning(getApplicationContext(), "No task for this specific date", Toast.LENGTH_SHORT, true).show();
        }else {
            adapter=new TaskAdapter(myLists,this,  this);
            recyclerView.setAdapter(adapter);
        }



    }
    //this function get us the previous n day
    private String getSpecificPreviousDateFromToday(int i){
        DateTime lastDay = new DateTime().minusDays(i);
        String k = lastDay.toString("yyyy-MM-dd");
        return k ;
    }
}