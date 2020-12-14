package com.example.yunusemre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

public class Urdu_Title_Turkish_Language extends AppCompatActivity {

    ImageView img,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu__title__turkish__language);

        img = findViewById(R.id.imageViewUrduTitle);
        img2 = findViewById(R.id.imageViewUrduTitle2);

        Toast.makeText(this, "سیزن منتخب کریں", Toast.LENGTH_SHORT).show();

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Urdu_Title_Turkish_Language.this,Original_Turkish.class);
                intent.putExtra("selectedSeason","https://www.youtube.com/watch?v=_FhnVNj9vcU&list=PLUvKEFcd8Uh4EJRLY8fzLu4I-09_ly1Df");
                startActivity(intent);
            }
        });


        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Urdu_Title_Turkish_Language.this,Original_Turkish.class);
                intent.putExtra("selectedSeason","https://www.youtube.com/watch?v=A_33nOW1kWQ&list=PLzyarefV_4dN9OzK92H9SuS9I1Qd73Rl-");
                startActivity(intent);
            }
        });


    }


}