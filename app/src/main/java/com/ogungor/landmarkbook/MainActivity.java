package com.ogungor.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> landmarkName = new ArrayList<>();
    ArrayList<String> countryName = new ArrayList<>();
    ArrayList<Bitmap> landmarkImage = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.landmarkList);

        landmarkName.add("Pisa");
        landmarkName.add("Eifell");
        landmarkName.add("Colossoe");
        landmarkName.add("London Bridge");

        countryName.add("Italy");
        countryName.add("France");
        countryName.add("Italy");
        countryName.add("United K.");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.pisa);
        Bitmap eifell = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.eifel);
        Bitmap colossoe = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.colossoe);
        Bitmap london = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.london);

        landmarkImage.add(pisa);
        landmarkImage.add(eifell);
        landmarkImage.add(colossoe);
        landmarkImage.add(london);


        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, landmarkName);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("name", landmarkName.get(i));
                intent.putExtra("country", countryName.get(i));
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImage.get(i));
                startActivity(intent);

            }
        });
        {

        }
        ;


    }
}