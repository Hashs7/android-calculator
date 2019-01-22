package com.gmail.pro.glagouy.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.pro.glagouy.example.R;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class PlanetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("desc");
        String img = intent.getStringExtra("img");

        TextView textViewTitle = findViewById(R.id.tv_item_planetTitle);
        TextView textViewDesc = findViewById(R.id.tv_item_planetDesc);
        ImageView imageView = findViewById(R.id.iv_item_planetImg);

        textViewTitle.setText(title);
        textViewDesc.setText(desc);
        Picasso.get().load(img).into(imageView);
    }
}
