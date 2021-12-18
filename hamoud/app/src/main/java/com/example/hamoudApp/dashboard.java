package com.example.hamoudApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hamoudApp.Config.Config;
import com.example.hamoudApp.adapters.MyAdapter;
import com.example.hamoudApp.models.MyList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class dashboard extends AppCompatActivity implements MyAdapter.OnBoxListener {
    List<MyList> myLists;
    RecyclerView rv;
    MyAdapter adapter;
    TextView tvname;
    FloatingActionButton bottomAppBar ;
    HashMap<String, String> profileInfo = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        String passedInfo = getIntent().getStringExtra("id");
        tvname = (TextView) findViewById(R.id.name);
        rv=(RecyclerView)findViewById(R.id.rec);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(this,2));
        bottomAppBar = (FloatingActionButton) findViewById(R.id.newicon) ;
        myLists=new ArrayList<>();
        bottomAppBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(dashboard.this, newTask.class);
                startActivity(intent7);
            }
        });




        getboxes();
    }

    private void getboxes() {


        myLists.add(new MyList(R.drawable.pic1));
        myLists.add(new MyList(R.drawable.pic2));
        myLists.add(new MyList(R.drawable.pic3));
        myLists.add(new MyList(R.drawable.pic4));
        myLists.add(new MyList(R.drawable.pic5));


        adapter=new MyAdapter(myLists,this,this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onBoxClick(int position) {
        //Toasty.warning(getApplicationContext(), position+"", Toast.LENGTH_SHORT, true).show();
        switch (position) {
            case 0:
                Intent intent1 = new Intent(dashboard.this, PlacingOrder.class);
                startActivity(intent1);
                finish();
                break;

        }
    }


}
