package com.example.yunusemre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class Categories extends AppCompatActivity {

//    CategoryAdapter.CategoryViewHolder mAdapter;
    CategoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        RecyclerView categoryList = findViewById(R.id.recyclerView);
        categoryList.setLayoutManager(new LinearLayoutManager(this));
        String[] catogoryTitle = {"Watch in Urdu Language", "Watch with Urdu Subtitles",
                "Watch with English Subtitles","Watch in Arabic Language"};
        categoryList.setAdapter(new CategoryAdapter(Categories.this,catogoryTitle));

       // mAdapter = new CategoryAdapter(Categories.this,catogoryTitle);

//        mAdapter.setOnItemClickListener(new CategoryAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                Toast.makeText(Categories.this, "position"+position, Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}