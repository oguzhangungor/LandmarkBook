package com.ogungor.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView landmarkText;
    TextView countryText;
    String landmarkName;
    String countryName;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        landmarkText=findViewById(R.id.landmarkText);
        countryText=findViewById(R.id.countryText);
        imageView=findViewById(R.id.imageView);




        Intent intent= getIntent();
        landmarkName=getIntent().getStringExtra("name");
        countryName=getIntent().getStringExtra("country");
        landmarkText.setText(landmarkName);
        countryText.setText(countryName);
        Singleton singleton=Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());


    }
}