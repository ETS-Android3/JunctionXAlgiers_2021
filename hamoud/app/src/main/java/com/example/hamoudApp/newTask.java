package com.example.hamoudApp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hamoudApp.Config.Config;
import com.example.hamoudApp.Config.HttpService;
import com.example.hamoudApp.Config.RetrofitBuilder;
import com.example.hamoudApp.adapters.checkWorkerListener;
import com.example.hamoudApp.adapters.wCheckersAdapter;
import com.example.hamoudApp.models.FileModel;
import com.example.hamoudApp.models.secondFileModel;
import com.example.hamoudApp.models.workersChecker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import es.dmoral.toasty.Toasty;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class newTask extends AppCompatActivity implements checkWorkerListener {
    private ArrayList<workersChecker> myLists;
    private wCheckersAdapter adapter;
    TextView next_Text ;
    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private String AudioSavaPath = null;
    EditText edtTitle , edtMessage ;
    RecyclerView recyclerView;
    ScrollView partOne ;
    CoordinatorLayout partTwo ,partThree;
    ProgressBar pgsBar;

    public String globalIdTask = "";


    public ArrayList<String> arraydeep = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        next_Text = (TextView) findViewById(R.id.next);
        edtTitle = (EditText) findViewById(R.id.edttitle);
        edtMessage = (EditText) findViewById(R.id.edtmessage);

        partOne = (ScrollView) findViewById(R.id.partone);
        partTwo = (CoordinatorLayout) findViewById(R.id.parttwo);
        partThree = (CoordinatorLayout) findViewById(R.id.partthree);
        recyclerView=(RecyclerView)findViewById(R.id.rec);
        pgsBar = (ProgressBar)findViewById(R.id.pBar);

        setRecyclerView();
        tasksBuilder();
        //getdo();


    }
    private void getdo() {

        myLists.add(new workersChecker("Anis","0674291619"));
        myLists.add(new workersChecker("bradroite","0674291619"));
        myLists.add(new workersChecker("bragauche","0674291619"));
        myLists.add(new workersChecker("Ouss","0674291619"));
        myLists.add(new workersChecker("larbi","0674291619"));
        myLists.add(new workersChecker("chelfaoui","0674291619"));
        myLists.add(new workersChecker("elkemali","0674291619"));
        myLists.add(new workersChecker("said","0674291619"));
        adapter=new wCheckersAdapter(myLists,this,this);
        recyclerView.setAdapter(adapter);
    }
    private void setRecyclerView(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myLists=new ArrayList<>();
    }

    private void tasksBuilder() {

        String url = Config.WORKERS_LIST_URL;//today.trim();



        StringRequest stringRequest = new StringRequest(url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(newTask.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response) {

        //ArrayList<String> titlesTest = new ArrayList<String>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String id_worker  = jo.getString(Config.KEY_ID_WORKER);
                String username = jo.getString(Config.KEY_WORKER_NAME);
                String phone = jo.getString(Config.KEY_PHONE);

                //titlesTest.add(title);
                myLists.add(new workersChecker(username,phone));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (myLists.isEmpty()){
            Toasty.warning(getApplicationContext(), "No Workers here", Toast.LENGTH_SHORT, true).show();
        }else {
            adapter=new wCheckersAdapter(myLists,this,this);
            recyclerView.setAdapter(adapter);
        }



    }


    public void btnRecordPress(View v){
        if (checkPermissions() == true) {

            AudioSavaPath = Environment.getExternalStorageDirectory().getAbsolutePath()
                    +"/"+"recordingAudio.mp3";

            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            mediaRecorder.setOutputFile(AudioSavaPath);

            try {
                mediaRecorder.prepare();
                mediaRecorder.start();
                Toast.makeText(newTask.this, "Recording started"+AudioSavaPath, Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }else {

            ActivityCompat.requestPermissions(newTask.this,new String[]{
                    Manifest.permission.RECORD_AUDIO,Manifest.permission.WRITE_EXTERNAL_STORAGE
            },1);
        }
    }
    public void btnPausePress(View v){
        mediaRecorder.stop();
        mediaRecorder.release();
        Toast.makeText(newTask.this, "Recording stopped", Toast.LENGTH_SHORT).show();
    }
    public void btnPlayPress(View v){
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(AudioSavaPath);
            mediaPlayer.prepare();
            mediaPlayer.start();
            Toast.makeText(newTask.this, "Start playing", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void btnStopPress(View v){
        if (mediaPlayer != null) {

            mediaPlayer.stop();
            mediaPlayer.release();
            Toast.makeText(newTask.this, "Stopped playing", Toast.LENGTH_SHORT).show();
        }
    }
    public void btnNextPress(View v){
        partOne.setVisibility(View.GONE);
        partTwo.setVisibility(View.VISIBLE);

    }
    private boolean isMicPresent(){
        if (this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)){
            return true ;
        }else {
            return false ;
        }
    }
    private boolean checkPermissions() {
        int first = ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.RECORD_AUDIO);
        int second = ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        return first == PackageManager.PERMISSION_GRANTED &&
                second == PackageManager.PERMISSION_GRANTED;
    }
    public void addOneDetailTask(String workerName , String git){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create()).baseUrl(Config.Base_URL)
                .build();
        HttpService servicetwo = retrofit.create(HttpService.class);

        Call<secondFileModel> calltwo = servicetwo.loadDetail(git, workerName);
        calltwo.enqueue(new Callback<secondFileModel>() {
            @Override
            public void onResponse(Call<secondFileModel> call, Response<secondFileModel> response) {
                secondFileModel sfm = response.body();
                //Toast.makeText(newTask.this, sfm.getRepo()+"-----", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<secondFileModel> call, Throwable t) {
                Toast.makeText(newTask.this, "We have an Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void uploadFileToServer(){

        File file = new File(AudioSavaPath);

        RequestBody messagePart = RequestBody.create(MultipartBody.FORM ,edtMessage.getText().toString());
        RequestBody titlePart = RequestBody.create(MultipartBody.FORM ,edtTitle.getText().toString());

        //today code
        Date dateandtime = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String today = dateFormat.format(dateandtime);

        RequestBody datePart = RequestBody.create(MultipartBody.FORM ,today);

        //time code
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentTime = sdf.format(new Date());


        RequestBody timePart = RequestBody.create(MultipartBody.FORM ,currentTime);

        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("sendaudio",file.getName(),requestBody);

        HttpService service = RetrofitBuilder.getClient().create(HttpService.class);

        Call<FileModel> call = service.callUploadApi(titlePart,datePart,timePart,messagePart,filePart);
        call.enqueue(new Callback<FileModel>() {
            @Override
            public void onResponse(Call<FileModel> call, Response<FileModel> response) {
                FileModel fileModel = response.body();
                globalIdTask = fileModel.getMessage();
                //Toast.makeText(newTask.this, globalIdTask, Toast.LENGTH_SHORT).show();
                if (globalIdTask != null && globalIdTask.length()>0 && arraydeep != null && arraydeep.size()>0){
                    for (int i = 0 ; i < arraydeep.size() ; i++){

                        addOneDetailTask(arraydeep.get(i).toString()+"",globalIdTask+"");
                        //addOneDetailTask(globalIdTask,arraydeep.get(i));
                        //Toast.makeText(newTask.this, globalIdTask + " - " + arraydeep.get(0) + " - "+ arraydeep.get(1)+" - "+ arraydeep.get(2), Toast.LENGTH_SHORT).show();

                    }
                    //partThree.setVisibility(View.GONE);
                    Toasty.success(getApplicationContext(),"Tasks Sent Successfully",Toast.LENGTH_SHORT).show();
                    /*Intent intent = new Intent(newTask.this, dashboard.class);
                    startActivity(intent);*/


                }


            }

            @Override
            public void onFailure(Call<FileModel> call, Throwable t) {
                Toasty.warning(getApplicationContext(), "the data not Sending , Server Error", Toast.LENGTH_SHORT, true).show();

            }
        });


    }

    @Override
    public void onnbrChange(ArrayList<String> arrayList) {
        //Toast
        //Toast.makeText(newTask.this,arrayList.toString(),Toast.LENGTH_SHORT).show();
        arraydeep = arrayList ;
    }

    public void btnSendPress(View view) {

        if (arraydeep != null && arraydeep.size()>0){

            //partTwo.setVisibility(View.GONE);
            //partThree.setVisibility(View.VISIBLE);
            //pgsBar.setVisibility(View.VISIBLE);
            uploadFileToServer();
            //Toast.makeText(newTask.this,globalIdTask+"",Toast.LENGTH_SHORT).show();
            //addOneDetailTask("john",globalIdTask+"");
            //addOneDetailTask("Anis",globalIdTask+"");
            //Toast.makeText(newTask.this,arraydeep.toString(),Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(newTask.this,"null to show",Toast.LENGTH_SHORT).show();
        }
    }
}
