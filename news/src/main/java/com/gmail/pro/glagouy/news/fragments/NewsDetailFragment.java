package com.gmail.pro.glagouy.news.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.pro.glagouy.news.R;
import com.gmail.pro.glagouy.news.models.News;
import com.gmail.pro.glagouy.news.viewmodels.NewsViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * Affichage de la vue complète de la news
 * Apparait au touch de la news
 */
public class NewsDetailFragment extends Fragment {
    private View rootView;
    private NewsViewModel model;
    private ImageView imageView;
    private TextView textViewTitle;
    private TextView textViewAuthor;
    private TextView textViewPublished;
    private TextView textViewDescription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(NewsViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.news_detail, container, false);

        imageView = rootView.findViewById(R.id.iv_detail_image);
        textViewTitle = rootView.findViewById(R.id.tv_detail_title);
        textViewAuthor = rootView.findViewById(R.id.tv_detail_author);
        textViewPublished = rootView.findViewById(R.id.tv_detail_published);
        textViewDescription = rootView.findViewById(R.id.tv_detail_description);

        return rootView;
    }

    /** TODO
     * @eamosse - voir mon commentaire sur les observers
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model.getSelected().observe(this, new Observer<News>() {
            @Override
            public void onChanged(News news) {
                Picasso.get().load(news.getUrlToImage()).into(imageView);
                textViewTitle.setText(news.getTitle());
                textViewAuthor.setText(news.getAuthor());
                textViewPublished.setText(news.getPublishedAt());
                textViewDescription.setText(news.getDescription());
            }
        });
    }
}
