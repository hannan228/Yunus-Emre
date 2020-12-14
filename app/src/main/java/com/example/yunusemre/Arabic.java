package com.example.yunusemre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Arabic extends AppCompatActivity {

    ImageView arabicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic);


        arabicView  = findViewById(R.id.arabic);
        arabicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Arabic.this,Original_Turkish.class);
                intent.putExtra("selectedSeason","https://www.youtube.com/watch?v=HOdC76YSrok&list=PL8w8VBRA743MfgWzC6HEEOXyqe_N2uhpN");
                startActivity(intent);
            }
        });


    }
}