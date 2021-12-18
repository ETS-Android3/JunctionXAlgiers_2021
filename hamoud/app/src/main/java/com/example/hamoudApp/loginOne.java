package com.example.hamoudApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hamoudApp.Config.Config;
import com.example.hamoudApp.utils.CheckNetwork;
import com.example.hamoudApp.utils.theSSLerror;

import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class loginOne extends AppCompatActivity {
    EditText Eemail, Epassword;
    String email, password;
    TextView login;
    String URL = "https://hamoudserver.000webhostapp.com/API/loginshopkeepers.php";//LOGIN_URL;


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login_one);
            Eemail = (EditText) findViewById(R.id.email);
            Epassword = (EditText) findViewById(R.id.password);
            login = (TextView) findViewById(R.id.login);
            email = password = "";
            theSSLerror.handleSSLHandshake();

        }

        public void login (View view){
            if (CheckNetwork.getConnectionType(getApplicationContext()) != 0) {
            /*Intent intent = new Intent(this, bourse1.class);
            startActivity(intent);*/

                email = Eemail.getText().toString().trim();
                password = Epassword.getText().toString().trim();
                if (!email.equals("") && !password.equals("")) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("res", response);
                            if (response.equals("success")) {
                                Toasty.success(getApplicationContext(), "Success!", Toast.LENGTH_SHORT, true).show();
                                Intent intent = new Intent(loginOne.this, dashboard.class);
                                intent.putExtra("id", email);
                                startActivity(intent);
                                finish();
                            } else if (response.equals("failure")) {
                                Toast.makeText(loginOne.this, "Invalid Login Id/Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(loginOne.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("email", email);
                            data.put("password", password);
                            return data;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                } else {
                    Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toasty.warning(getApplicationContext(), "يرجى الاتصال بالانترنت اولا", Toast.LENGTH_SHORT, true).show();

            }
        }
    }
