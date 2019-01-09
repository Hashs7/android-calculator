package com.gmail.pro.glagouy.example.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.gmail.pro.glagouy.example.R;
import com.gmail.pro.glagouy.example.adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner sp = (Spinner) findViewById(R.id.spinner1);
        String[] planetes = getResources().getStringArray(R.array.planetesArray);

        ArrayAdapter<String> dataAdapter = new MyAdapter(this, planetes);
        dataAdapter.setDropDownViewResource(R.layout.line_item);
        sp.setAdapter(new MyAdapter(this, planetes));

    }
}
