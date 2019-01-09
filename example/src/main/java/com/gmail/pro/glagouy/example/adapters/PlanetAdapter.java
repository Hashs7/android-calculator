package com.gmail.pro.glagouy.example.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.pro.glagouy.example.R;
import com.gmail.pro.glagouy.example.modeles.Planet;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.MyViewHolder>  {
    private ArrayList<Planet> planetes;

    public PlanetAdapter(ArrayList<Planet> planetes){
        this.planetes = planetes;
    }

    @NonNull
    @Override
    public PlanetAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.line_item_planet, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.bindItem(planetes.get(position));
    }

    @Override
    public int getItemCount(){
        return planetes.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle;
        TextView mDescription;

        MyViewHolder(View v) {
            super(v);
            mTitle = v.findViewById(R.id.tv_planetTitle);
            mDescription = v.findViewById(R.id.tv_planetDesc);
        }

        void bindItem(Planet planet){
            mTitle.setText(planet.getName());
            mDescription.setText(planet.getDescription());
        }
    }
}
