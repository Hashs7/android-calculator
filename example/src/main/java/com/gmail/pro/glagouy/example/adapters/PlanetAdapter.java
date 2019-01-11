package com.gmail.pro.glagouy.example.adapters;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.pro.glagouy.example.R;
import com.gmail.pro.glagouy.example.activities.PlanetActivity;
import com.gmail.pro.glagouy.example.listeners.PlanetListener;
import com.gmail.pro.glagouy.example.modeles.Planet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.MyViewHolder>  {
    private ArrayList<Planet> planetes;
    PlanetListener listener;

    public PlanetAdapter(ArrayList<Planet> planetes, PlanetListener listener){
        this.planetes = planetes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlanetAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.line_item_planet, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        holder.bindItem(planetes.get(position));
    }

    @Override
    public int getItemCount(){
        return planetes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle;
        TextView mDescription;
        ImageView mImage;
        ImageView mShare;
        View v;

        MyViewHolder(View v) {
            super(v);
            this.v = v;
            mTitle = v.findViewById(R.id.tv_planetTitle);
            mDescription = v.findViewById(R.id.tv_planetDesc);
            mImage = v.findViewById(R.id.iv_planetImg);
            mShare = v.findViewById(R.id.share);
        }

        void bindItem(final Planet planet){
            mTitle.setText(planet.getName());
            mDescription.setText(planet.getDescription());
            Picasso.get().load(planet.getImage()).into(mImage);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onSelect(planet);
                }
            });

            mShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onShare(planet);
                }
            });
        }
    }
}
