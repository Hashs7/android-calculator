package com.gmail.pro.glagouy.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> planetes = new ArrayList<>();
        planetes.add("MERCURE");
        planetes.add("VENUS");
        planetes.add("TERRE");
        planetes.add("MARS");
        planetes.add("JUPITER");
        planetes.add("SATURNE");
        planetes.add("URANUS");
        planetes.add("NEPTUNE");

        Spinner sp = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, planetes);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);

    }
}
