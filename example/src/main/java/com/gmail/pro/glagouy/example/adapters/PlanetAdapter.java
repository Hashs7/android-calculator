package com.gmail.pro.glagouy.example.adapters;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.pro.glagouy.example.R;
import com.gmail.pro.glagouy.example.activities.PlanetActivity;
import com.gmail.pro.glagouy.example.modeles.Planet;
import com.squareup.picasso.Picasso;

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
        ImageView mImage;
        View v;

        MyViewHolder(View v) {
            super(v);
            this.v = v;
            mTitle = v.findViewById(R.id.tv_planetTitle);
            mDescription = v.findViewById(R.id.tv_planetDesc);
            mImage = v.findViewById(R.id.iv_planetImg);
        }

        void bindItem(final Planet planet){
            mTitle.setText(planet.getName());
            mDescription.setText(planet.getDescription());
            Picasso.get().load(planet.getImage()).into(mImage);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PlanetActivity.class);
                    intent.putExtra("title", planet.getName());
                    intent.putExtra("desc", planet.getDescription());
                    intent.putExtra("img", planet.getImage());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
