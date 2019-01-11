package com.gmail.pro.glagouy.news.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.pro.glagouy.news.R;
import com.gmail.pro.glagouy.news.models.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder>{
    private List<News> news;

    public void setNews(List<News> news) {
        this.news = news;
    }

    public NewsAdapter(List<News> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.line_item_news, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindItem(news.get(position));
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle;
        TextView mAuthor;
        TextView mPublished;
        ImageView mImage;
        TextView mDesc;
        View v;

        public MyViewHolder(@NonNull View v) {
            super(v);
            this.v = v;
            mTitle = v.findViewById(R.id.tv_title);
            mAuthor = v.findViewById(R.id.tv_author);
            mPublished = v.findViewById(R.id.tv_publish);
            mImage = v.findViewById(R.id.iv_image);
            mDesc = v.findViewById(R.id.tv_desc);
        }

        void bindItem(final News news){
            mTitle.setText(news.getTitle());
            mAuthor.setText(news.getAuthor());
            mPublished.setText(news.getPublishedAt());
            Picasso.get().load(news.getUrlToImage()).into(mImage);
            mDesc.setText(news.getDescription());
        }
    }
}

