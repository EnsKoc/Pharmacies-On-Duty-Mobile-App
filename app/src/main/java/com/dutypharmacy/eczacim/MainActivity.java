package com.dutypharmacy.eczacim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnListele;

    Typeface tf1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListele = (Button) findViewById(R.id.btnListele);


        tf1= Typeface.createFromAsset(getAssets(),"font/caviarDreamsBold.ttf");
        btnListele.setTypeface(tf1);

        btnListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this, PharmacyActivity.class);
            startActivity(intent);
            }
        });
    }
}