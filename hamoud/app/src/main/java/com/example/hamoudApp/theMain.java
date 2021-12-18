package com.example.hamoudApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class theMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_main);
        ImageSlider imageSlider= (ImageSlider) findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://cdn.discordapp.com/attachments/921453609483403297/921567352041119804/ad_4.webp"));
        slideModels.add(new SlideModel("https://lh3.googleusercontent.com/proxy/PlCsXY7HRQym9_rjL0HvBgTuVJhAQb_CuDRrHajJr5Ch7X-CMLopEeAGMMbD4EivrOPXJpOw-4KoXHn8Q8SQhxAqrbb3xDIBM7RIgniiFleQbbbDamgzc-YysSprBWo2VqZplxeJQjR9LpVuCeg"));
        slideModels.add(new SlideModel("https://cdn.discordapp.com/attachments/921453609483403297/921565871015624785/ad_3.jpg"));

        imageSlider.setImageList(slideModels,true);
    }

    public void btnPublicPress(View view) {
        Intent intent = new Intent(theMain.this , publicDashboard.class);
        startActivity(intent);
        finish();
    }
    public void btnShopPress(View view) {
        Intent intent = new Intent(theMain.this , loginOne.class);
        startActivity(intent);
        finish();

    }
    public void btnDistPress(View view) {
        Intent intent = new Intent(theMain.this , loginTwo.class);
        startActivity(intent);
        finish();
    }
}