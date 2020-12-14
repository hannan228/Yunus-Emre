package com.example.yunusemre;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.Locale;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private static final String TAG = "DashBoardLayout";
    private String[] data;
    private String[] icons;
    Context context;
    //private AdapterView.OnItemClickListener mListener;
    private OnItemClickListener onItemClickListener1;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener1 =  listener;
    }

    public CategoryAdapter(Context context ,String[] catogoryTitle){
        this.data = catogoryTitle;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout,parent,false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view,onItemClickListener1);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

//        String img = icons[position];
//        holder.imageIcon.setImageResource(Integer.parseInt(img));

        String title = data[position];
        holder.categoriTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        ImageView imageIcon;
        TextView categoriTitle;
        public CategoryViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            imageIcon = itemView.findViewById(R.id.categoryImg);
            categoriTitle = itemView.findViewById(R.id.categoryTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: ");

                    String title = data[getAdapterPosition()];

                    switch (title) {
                        case "Watch in Urdu Language":
                            context.startActivity(new Intent(context,Urdu_Dubbing.class));
                            break;

                        case "Watch with Urdu Subtitles":
                            context.startActivity(new Intent(context,Urdu_Title_Turkish_Language.class));
                            break;

                        case "Watch with English Subtitles":
                            context.startActivity(new Intent(context,English_Title.class));
                            break;

                        case "Watch in Arabic Language":
                            context.startActivity(new Intent(context,Arabic.class));
                            break;


                    }

                }
            });

        }
    }
}
