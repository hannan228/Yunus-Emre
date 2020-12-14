package com.example.yunusemre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

public class Urdu_Dubbing extends AppCompatActivity {

    ImageView imageView,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu__dubbing);

        imageView = findViewById(R.id.imageViewUrdu);
        imageView2 = findViewById(R.id.imageViewUrdu2);

        Toast.makeText(this, "سیزن منتخب کریں", Toast.LENGTH_SHORT).show();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(Urdu_Dubbing.this,Original_Turkish.class);
                    intent.putExtra("selectedSeason","https://www.youtube.com/watch?v=6ufrJgsIS70&list=PL5RIBq4IKO4UUTstS05O5LN5PrEPAhzsO");
                    startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Urdu_Dubbing.this,Original_Turkish.class);
                intent.putExtra("selectedSeason","https://www.youtube.com/watch?v=A_33nOW1kWQ&list=PL5RIBq4IKO4X8HzsY5sfag7VG0Y_oFtvv");
                startActivity(intent);
            }
        });

    }

}