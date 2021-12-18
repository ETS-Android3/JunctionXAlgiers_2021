package com.example.hamoudApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hamoudApp.Config.Config;
import com.example.hamoudApp.adapters.WorkerAdapter;
import com.example.hamoudApp.models.myWorkersList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class TaskDetails extends AppCompatActivity {

    private List<myWorkersList> myLists;
    private WorkerAdapter adapter;
    RecyclerView recyclerView;
    String[] array_inf = new String[6];
    TextView title_txt , message_txt , date_txt , time_txt ;
    ImageButton audio_img ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        title_txt = (TextView) findViewById(R.id.titleee);
        message_txt = (TextView)findViewById(R.id.messageee);
        date_txt = (TextView) findViewById(R.id.dateee);
        time_txt = (TextView) findViewById(R.id.timeee);
        audio_img = (ImageButton) findViewById(R.id.audiooo);
        array_inf[0] = getIntent().getStringExtra("id_inf");
        array_inf[1] = getIntent().getStringExtra("title_inf");
        array_inf[2] = getIntent().getStringExtra("date_inf");
        array_inf[3] = getIntent().getStringExtra("time_inf");
        array_inf[4] = getIntent().getStringExtra("msg_inf");
        array_inf[5] = getIntent().getStringExtra("vocal_path_inf");

        if (array_inf[5].endsWith(".mp3")){
            audio_img.setImageResource(R.drawable.audioicon2);

        }else {

            audio_img.setImageResource(R.drawable.noaudio);
        }
        title_txt.setText(array_inf[1]);
        message_txt.setText(array_inf[4]);
        date_txt.setText(array_inf[2]);
        time_txt.setText(array_inf[3]);

        //setting the audio
        audio_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (array_inf[5].endsWith(".mp3")){
                    MediaPlayer mediaPlayer = new MediaPlayer();

                    try {
                        mediaPlayer.setDataSource(Config.Base_URL + array_inf[5]);
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                mp.start();
                            }
                        });

                        mediaPlayer.prepareAsync();


                    }catch (IOException e){
                        e.printStackTrace();
                    }



                    /*final MediaPlayer mediaPlayer = MediaPlayer.create(TaskDetails.this,R.raw.click_sound);
                    mediaPlayer.start();*/

                }else {
                    Toasty.warning(getApplicationContext(), " No audio to show ", Toast.LENGTH_SHORT, true).show();
                }

            }
        });

        recyclerView=(RecyclerView)findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myLists=new ArrayList<>();

        //getdata();
        workersSide();

    }

    private void workersSide() {
        String url = Config.WORKERS_ONETASK_URL + array_inf[0];
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TaskDetails.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void showJSON(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String worker_name  = jo.getString(Config.KEY_WORKER_NAME);
                String worker_state = jo.getString(Config.KEY_STATE);

                myLists.add(new myWorkersList(worker_name , worker_state));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (myLists.isEmpty()){
            Toasty.warning(getApplicationContext(), "No Workers for this specific Task", Toast.LENGTH_SHORT, true).show();
        }else {
            adapter=new WorkerAdapter(myLists,getApplicationContext());
            recyclerView.setAdapter(adapter);
        }
    }

    private void getdata() {

        myLists.add(new myWorkersList("Moussa","done"));
        myLists.add(new myWorkersList("Abdillahe","wait"));
        myLists.add(new myWorkersList("Kaghim","done"));
        myLists.add(new myWorkersList("Ghim","done"));
        adapter=new WorkerAdapter(myLists,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}