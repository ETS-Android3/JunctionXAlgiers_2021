package com.example.hamoudApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hamoudApp.Config.Config;
import com.example.hamoudApp.utils.CustomVolleyRequestQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class profilePage extends AppCompatActivity {

    HashMap<String, String> profileInfo = new HashMap<String, String>();
    TextView tvname , tvemail , tvmobile , tvtel , tvaddress , tvzip ;
    NetworkImageView profileImg ;
    ImageLoader mImageLoader ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        tvname = (TextView) findViewById(R.id.textView);
        tvemail = (TextView) findViewById(R.id.textView2);
        tvmobile = (TextView) findViewById(R.id.tvmobile);
        tvtel = (TextView) findViewById(R.id.tvtel);
        tvaddress = (TextView) findViewById(R.id.tvadr);
        tvzip = (TextView) findViewById(R.id.tvzip);
        profileImg = (NetworkImageView) findViewById(R.id.imageView2);
        //getting my data
        getProfileData();



    }
    private void getProfileData() {
        String passedinfo = getIntent().getStringExtra("id");
        String value = passedinfo;

        if (value.equals("")) {
            Toast.makeText(this, "Please Enter Data Value", Toast.LENGTH_LONG).show();
            return;
        }

        String url = Config.PROFILE_DATA_URL + passedinfo.trim();


        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(profilePage.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            //length = result.length();

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String name  = jo.getString(Config.KEY_NAME);
                String email = jo.getString(Config.KEY_EMAIL);
                String mobile = jo.getString(Config.KEY_MOBILE);
                String tel = jo.getString(Config.KEY_TEL);
                String address = jo.getString(Config.KEY_ADDRESS);
                String zip = jo.getString(Config.KEY_ZIP);
                String path = jo.getString(Config.IMAGE_PATH);
                profileInfo.put(Config.KEY_NAME , name);
                profileInfo.put(Config.KEY_EMAIL, email);
                profileInfo.put(Config.KEY_MOBILE, mobile);
                profileInfo.put(Config.KEY_TEL, tel);
                profileInfo.put(Config.KEY_ADDRESS, address);
                profileInfo.put(Config.KEY_ZIP, zip);
                profileInfo.put(Config.IMAGE_PATH,path);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //lets place it
        tvname.setText(profileInfo.get(Config.KEY_NAME));
        tvemail.setText(profileInfo.get(Config.KEY_EMAIL));
        tvmobile.setText(profileInfo.get(Config.KEY_MOBILE));
        tvtel.setText(profileInfo.get(Config.KEY_TEL));
        tvaddress.setText(profileInfo.get(Config.KEY_ADDRESS));
        tvzip.setText(profileInfo.get(Config.KEY_ZIP));
        // Instantiate the RequestQueue.
        mImageLoader = CustomVolleyRequestQueue.getInstance(this.getApplicationContext())
                .getImageLoader();
        //Image URL - This can point to any image file supported by Android
        final String url = Config.Base_URL + profileInfo.get(Config.IMAGE_PATH);
        mImageLoader.get(url, ImageLoader.getImageListener(profileImg,
                R.drawable.person, android.R.drawable
                        .ic_dialog_alert));
        profileImg.setImageUrl(url, mImageLoader);

    }
    @Override
    protected void onStart() {
        super.onStart();

    }
}