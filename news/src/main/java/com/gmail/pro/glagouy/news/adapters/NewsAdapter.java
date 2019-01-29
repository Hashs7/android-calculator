package com.gmail.pro.glagouy.news.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.pro.glagouy.news.R;
import com.gmail.pro.glagouy.news.listeners.NewsListener;
import com.gmail.pro.glagouy.news.models.News;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * L'adapteur récupère les données
 * et les formattent pour l'adapter à la vue
 *
 * TODO Attention aux warnings
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder>{
    private List<News> news;
    private NewsListener listener;

    public void setNews(List<News> news) {
        this.news = news;
    }

    public NewsAdapter(List<News> news, NewsListener listener) {
        this.news = news;
        this.listener = listener;
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
        private TextView mTitle;
        private TextView mAuthor;
        private TextView mPublished;
        private ImageView mImage;
        private TextView mDesc;
        private ImageView mLike;
        private View v;

        public MyViewHolder(@NonNull View v) {
            super(v);
            this.v = v;
            mTitle = v.findViewById(R.id.tv_title);
            mAuthor = v.findViewById(R.id.tv_author);
            mPublished = v.findViewById(R.id.tv_publish);
            mImage = v.findViewById(R.id.iv_image);
            mDesc = v.findViewById(R.id.tv_desc);
            mLike = v.findViewById(R.id.like);
        }

        void bindItem(final News news){
            mTitle.setText(news.getTitle());
            mAuthor.setText(news.getAuthor());
            mPublished.setText(news.getPublishedAt());
            Picasso.get().load(news.getUrlToImage()).into(mImage);
            mDesc.setText(news.getDescription());

            if(news.getLike()){
                mLike.setBackgroundResource(R.drawable.ic_thumb_up_blue_24dp);
            } else {
                mLike.setBackgroundResource(R.drawable.ic_thumb_up_grey_24dp);
            }

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onSelect(news);
                }
            });

            mLike.setOnClickListener(new View.OnClickListener() {

                /** TODO
                 * @eamosse tu devrais fexecuter cette opération dans le listener
                 * et notifier l'adapter pour changer l'apparence du bouton
                 */
                @Override
                public void onClick(View v) {
                    news.setLike(true);
                    listener.onLike(news);
                }
            });
        }
    }
}

