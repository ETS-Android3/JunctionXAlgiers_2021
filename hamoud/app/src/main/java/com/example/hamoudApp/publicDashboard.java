package com.example.hamoudApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class publicDashboard extends AppCompatActivity implements OnMapReadyCallback {

    ImageButton ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12,ib13,ib14,ib15,ib16 ;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16 ;
    ImageButton ib111,ib22,ib33,ib44,ib55,ib66,ib77,ib88,ib99,ib1010,ib1111,ib1212,ib1313,ib1414,ib1515,ib1616 ;
    TextView tv111,tv22,tv33,tv44,tv55,tv66,tv77,tv88,tv99,tv1010,tv1111,tv1212,tv1313,tv1414,tv1515,tv1616;

    ImageButton fb1,fb2,fb3,fb4,fb5,fb6,fb7,fb8,fb9,fb10,fb11,fb12,fb13,fb14,fb15,fb16 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_public);
        SupportMapFragment mapFragment =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

        ib1 = findViewById(R.id.bup1);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv1.getText());
                temp ++ ;
                tv1.setText(""+temp);
            }
        });
        ib2 = findViewById(R.id.bup2);
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv2.getText());
                temp ++ ;
                tv2.setText(""+temp);
            }
        });
        ib3 = findViewById(R.id.bup3);
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv3.getText());
                temp ++ ;
                tv3.setText(""+temp);
            }
        });
        ib4 = findViewById(R.id.bup4);
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv4.getText());
                temp ++ ;
                tv4.setText(""+temp);
            }
        });
        ib5 = findViewById(R.id.bup5);
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv5.getText());
                temp ++ ;
                tv5.setText(""+temp);
            }
        });
        ib6 = findViewById(R.id.bup6);
        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv6.getText());
                temp ++ ;
                tv6.setText(""+temp);
            }
        });
        ib7 = findViewById(R.id.bup7);
        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv7.getText());
                temp ++ ;
                tv7.setText(""+temp);
            }
        });
        ib8 = findViewById(R.id.bup8);
        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv8.getText());
                temp ++ ;
                tv8.setText(""+temp);
            }
        });
        ib9 = findViewById(R.id.bup9);
        ib9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv9.getText());
                temp ++ ;
                tv9.setText(""+temp);
            }
        });
        ib10 = findViewById(R.id.bup10);
        ib10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv10.getText());
                temp ++ ;
                tv10.setText(""+temp);
            }
        });
        ib11 = findViewById(R.id.bup11);
        ib12 = findViewById(R.id.bup12);
        ib13 = findViewById(R.id.bup13);
        ib14 = findViewById(R.id.bup14);
        ib15 = findViewById(R.id.bup15);
        ib16 = findViewById(R.id.bup16);

        tv1 = findViewById(R.id.up1);
        tv2 = findViewById(R.id.up2);
        tv3 = findViewById(R.id.up3);
        tv4 = findViewById(R.id.up4);
        tv5 = findViewById(R.id.up5);
        tv6 = findViewById(R.id.up6);
        tv7 = findViewById(R.id.up7);
        tv8 = findViewById(R.id.up8);
        tv9 = findViewById(R.id.up9);
        tv10 = findViewById(R.id.up10);
        tv11 = findViewById(R.id.up11);
        tv12 = findViewById(R.id.up12);
        tv13 = findViewById(R.id.up13);
        tv14 = findViewById(R.id.up14);
        tv15 = findViewById(R.id.up15);
        tv16 = findViewById(R.id.up16);

        ib111 = findViewById(R.id.bdw1);
        ib111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv111.getText());
                temp -- ;
                tv111.setText(""+temp);
            }
        });
        ib22 = findViewById(R.id.bdw2);
        ib22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv22.getText());
                temp -- ;
                tv22.setText(""+temp);
            }
        });
        ib33 = findViewById(R.id.bdw3);
        ib33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv33.getText());
                temp -- ;
                tv33.setText(""+temp);
            }
        });
        ib44 = findViewById(R.id.bdw4);
        ib44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv44.getText());
                temp -- ;
                tv44.setText(""+temp);
            }
        });
        ib55 = findViewById(R.id.bdw5);
        ib55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv55.getText());
                temp -- ;
                tv55.setText(""+temp);
            }
        });

        ib66 = findViewById(R.id.bdw6);
        ib66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv66.getText());
                temp -- ;
                tv66.setText(""+temp);
            }
        });
        ib77 = findViewById(R.id.bdw7);
        ib77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(""+tv77.getText());
                temp -- ;
                tv77.setText(""+temp);
            }
        });
        ib88 = findViewById(R.id.bdw8);
        ib99 = findViewById(R.id.bdw9);
        ib1010 = findViewById(R.id.bdw10);
        ib1111 = findViewById(R.id.bdw11);
        ib1212 = findViewById(R.id.bdw12);
        ib1313 = findViewById(R.id.bdw13);
        ib1414 = findViewById(R.id.bdw14);
        ib1515 = findViewById(R.id.bdw15);
        ib1616 = findViewById(R.id.bdw16);

        tv111 = findViewById(R.id.down1);
        tv22 = findViewById(R.id.down2);
        tv33 = findViewById(R.id.down3);
        tv44 = findViewById(R.id.down4);
        tv55 = findViewById(R.id.down5);
        tv66 = findViewById(R.id.down6);
        tv77 = findViewById(R.id.down7);
        tv88 = findViewById(R.id.down8);
        tv99 = findViewById(R.id.down9);
        tv1010 = findViewById(R.id.down10);
        tv1111 = findViewById(R.id.down11);
        tv1212 = findViewById(R.id.down12);
        tv1313 = findViewById(R.id.down13);
        tv1414 = findViewById(R.id.down14);
        tv1515 = findViewById(R.id.down15);
        tv1616 = findViewById(R.id.down16);

        fb1 = findViewById(R.id.fb1);
        fb2 = findViewById(R.id.fb2);
        fb3 = findViewById(R.id.fb3);
        fb4 = findViewById(R.id.fb4);
        fb5 = findViewById(R.id.fb5);
        fb6 = findViewById(R.id.fb6);
        fb7 = findViewById(R.id.fb7);
        fb8 = findViewById(R.id.fb8);
        fb9 = findViewById(R.id.fb9);
        fb10 = findViewById(R.id.fb10);
        fb11 = findViewById(R.id.fb11);
        fb12 = findViewById(R.id.fb12);
        fb13 = findViewById(R.id.fb13);
        fb14 = findViewById(R.id.fb14);
        fb15 = findViewById(R.id.fb15);
        fb16 = findViewById(R.id.fb16);

        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });
        fb16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(publicDashboard.this, sendFeedBack.class);
                startActivity(intent);
                finish();
            }
        });


        getUpdData();







    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }

    private void getUpdData() {


        String url = Config.UPD_URL;


        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(publicDashboard.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
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
                String ups  = jo.getString(Config.KEY_UP);
                String dws = jo.getString(Config.KEY_DW);

                switch (i) {
                    case 1:
                        tv1.setText(ups);
                        tv111.setText(dws);
                    case 2:
                        tv2.setText(ups);
                        tv22.setText(dws);
                    case 3:
                        tv3.setText(ups);
                        tv33.setText(dws);
                    case 4:
                        tv4.setText(ups);
                        tv44.setText(dws);
                    case 5:
                        tv5.setText(ups);
                        tv55.setText(dws);
                    case 6:
                        tv6.setText(ups);
                        tv66.setText(dws);
                    case 7:
                        tv7.setText(ups);
                        tv77.setText(dws);
                    case 8:
                        tv8.setText(ups);
                        tv88.setText(dws);
                    case 9:
                        tv9.setText(ups);
                        tv99.setText(dws);
                    case 10:
                        tv10.setText(ups);
                        tv1010.setText(dws);
                    case 11:
                        tv11.setText(ups);
                        tv1111.setText(dws);
                    case 12:
                        tv12.setText(ups);
                        tv1212.setText(dws);
                    case 13:
                        tv13.setText(ups);
                        tv1313.setText(dws);
                    case 14:
                        tv14.setText(ups);
                        tv1414.setText(dws);
                    case 15:
                        tv15.setText(ups);
                        tv1515.setText(dws);
                    case 16:
                        tv16.setText(ups);
                        tv1616.setText(dws);

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

}