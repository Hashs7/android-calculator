package com.gmail.pro.glagouy.news.activites;

import android.os.Bundle;

import com.gmail.pro.glagouy.news.R;
import com.gmail.pro.glagouy.news.databases.DatabaseHelper;
import com.gmail.pro.glagouy.news.networks.NetworkHelper;
import com.gmail.pro.glagouy.news.fragments.NewsFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

/**
 * Activité principale de la vue
 * Lors de la création -> Initialise les données
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHelper.init(this);
        NetworkHelper.init(this);

        setContentView(R.layout.activity_main);

        NewsFragment fragment = new NewsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
