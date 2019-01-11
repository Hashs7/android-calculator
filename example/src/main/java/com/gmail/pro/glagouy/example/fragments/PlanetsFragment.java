package com.gmail.pro.glagouy.example.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gmail.pro.glagouy.example.R;
import com.gmail.pro.glagouy.example.activities.PlanetActivity;
import com.gmail.pro.glagouy.example.adapters.PlanetAdapter;
import com.gmail.pro.glagouy.example.listeners.PlanetListener;
import com.gmail.pro.glagouy.example.modeles.Planet;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PlanetsFragment extends Fragment  implements PlanetListener {
    private ArrayList<Planet> planets;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPlanets();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container,false);
        setItems(view);
        return view;

    }

    private void addPlanets(){
        this.planets = new ArrayList<>();
        planets.add(new Planet("Planet 1", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 2", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 3", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 4", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 5", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 6", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 7", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
        planets.add(new Planet("Planet 8", "Blanditiis voluptates veniam iusto qui sapiente ipsam fuga eum. Eos quos sit et alias autem qui maxime. Distinctio saepe quae esse sit hic. Voluptatibus soluta ut modi est tempora enim.", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1652&q=80"));
    }

    void setItems(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.list_planet);

        PlanetAdapter adapter = new PlanetAdapter(planets, this);

        GridLayoutManager manager = new GridLayoutManager(getContext(), 1);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSelect(Planet planet) {
        Intent intent = new Intent(getContext(), PlanetActivity.class);
        intent.putExtra("title", planet.getName());
        intent.putExtra("desc", planet.getDescription());
        intent.putExtra("img", planet.getImage());
        startActivity(intent);
    }

    @Override
    public void onShare(Planet planet) {
        Toast.makeText(getContext(), "Toast", Toast.LENGTH_SHORT).show();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, planet.getImage());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
