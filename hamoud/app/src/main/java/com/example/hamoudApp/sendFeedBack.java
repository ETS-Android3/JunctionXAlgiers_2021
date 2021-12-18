package com.example.hamoudApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
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

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hamoudApp.Config.Config;
import com.example.hamoudApp.Config.HttpService;
import com.example.hamoudApp.Config.RetrofitBuilder;
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

public class sendFeedBack extends AppCompatActivity {

    TextView next_Text ;
    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private String AudioSavaPath = null;
    EditText edtTitle , edtMessage ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_feed_back);
        next_Text = (TextView) findViewById(R.id.next);
        edtTitle = (EditText) findViewById(R.id.edttitle);
        edtMessage = (EditText) findViewById(R.id.edtmessage);



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
                Toast.makeText(sendFeedBack.this, "Recording started"+AudioSavaPath, Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }else {

            ActivityCompat.requestPermissions(sendFeedBack.this,new String[]{
                    Manifest.permission.RECORD_AUDIO,Manifest.permission.WRITE_EXTERNAL_STORAGE
            },1);
        }
    }
    public void btnPausePress(View v){
        mediaRecorder.stop();
        mediaRecorder.release();
        Toast.makeText(sendFeedBack.this, "Recording stopped", Toast.LENGTH_SHORT).show();
    }
    public void btnPlayPress(View v){
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(AudioSavaPath);
            mediaPlayer.prepare();
            mediaPlayer.start();
            Toast.makeText(sendFeedBack.this, "Start playing", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void btnStopPress(View v){
        if (mediaPlayer != null) {

            mediaPlayer.stop();
            mediaPlayer.release();
            Toast.makeText(sendFeedBack.this, "Stopped playing", Toast.LENGTH_SHORT).show();
        }
    }
    public void btnNextPress(View v){
        Intent intent = new Intent(sendFeedBack.this , publicDashboard.class);
        startActivity(intent);
        finish();

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

}