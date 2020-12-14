package com.example.yunusemre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class English_Title extends AppCompatActivity {

    ImageView title1,title2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english__title);

        title1 = findViewById(R.id.imageViewEnglishTitle);
        title2 = findViewById(R.id.imageViewEnglishTitle2);

        Toast.makeText(this, "Select season to watch", Toast.LENGTH_SHORT).show();

        title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(English_Title.this,Original_Turkish.class);
                intent.putExtra("selectedSeason","https://www.youtube.com/watch?v=ifirKjdhEYw&list=PLFCxIHnP1BCXx-0XWjt8wbkksuPBoi9pL");
                startActivity(intent);
            }
        });

        title2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(English_Title.this,Original_Turkish.class);
                intent.putExtra("selectedSeason","https://www.youtube.com/watch?v=xtol5XKz8U8&list=PLFCxIHnP1BCXlN9ebS0ehHEBJsOCLCsVM");
                startActivity(intent);
            }
        });

    }
}