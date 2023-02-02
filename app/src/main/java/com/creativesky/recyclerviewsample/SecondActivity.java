package com.creativesky.recyclerviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView imageView2;
    TextView titleTv2, descTv2;

    int imageId;
    String title, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();
        getDataFromIntent();
        setDataToWidgets();

    }

    private void init(){

        imageView2 = findViewById(R.id.imageView2);
        titleTv2 = findViewById(R.id.titleTv2);
        descTv2 = findViewById(R.id.descTv2);
    }

    private void getDataFromIntent(){

        Intent intent = getIntent();

        if(intent.hasExtra("image") && intent.hasExtra("title") && intent.hasExtra("desc")){

            imageId = intent.getIntExtra("image", 0);
            title = intent.getStringExtra("title");
            desc = intent.getStringExtra("desc");

        }else{
            Toast.makeText(this, "There is no data transferred", Toast.LENGTH_SHORT).show();
        }
    }

    private void setDataToWidgets(){

        imageView2.setImageResource(imageId);
        titleTv2.setText(title);
        descTv2.setText(desc);

    }
}