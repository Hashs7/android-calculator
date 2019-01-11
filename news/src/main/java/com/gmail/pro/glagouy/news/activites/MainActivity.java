package com.gmail.pro.glagouy.news.activites;

import android.os.Bundle;

import com.gmail.pro.glagouy.news.R;
import com.gmail.pro.glagouy.news.databases.NewsDatabase;
import com.gmail.pro.glagouy.news.fragments.NewsFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewsFragment fragment = new NewsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);

        transaction.commit();


    }
}
