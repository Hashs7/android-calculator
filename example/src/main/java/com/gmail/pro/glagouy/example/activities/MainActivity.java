package com.gmail.pro.glagouy.example.activities;


import android.os.Bundle;


import com.gmail.pro.glagouy.example.R;
import com.gmail.pro.glagouy.example.adapters.MyAdapter;
import com.gmail.pro.glagouy.example.adapters.PlanetAdapter;
import com.gmail.pro.glagouy.example.modeles.Planet;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);

        ArrayList<Planet> planets = new ArrayList<>();
        planets.add(new Planet("Planet 1", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 2", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 3", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 4", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 5", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 6", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 7", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 8", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));

        RecyclerView recyclerView = findViewById(R.id.list_planet);

        PlanetAdapter adapter = new PlanetAdapter(planets);

        GridLayoutManager manager = new GridLayoutManager(this, 1);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        /*Spinner sp = (Spinner) findViewById(R.id.spinner1);
        String[] planetes = getResources().getStringArray(R.array.planetesArray);

        ArrayAdapter<String> dataAdapter = new MyAdapter(this, planetes);
        dataAdapter.setDropDownViewResource(R.layout.line_item);
        sp.setAdapter(new MyAdapter(this, planetes));*/

    }


}
