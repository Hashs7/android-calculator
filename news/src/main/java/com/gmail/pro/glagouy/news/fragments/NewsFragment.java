package com.gmail.pro.glagouy.news.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.pro.glagouy.news.R;
import com.gmail.pro.glagouy.news.adapters.NewsAdapter;
import com.gmail.pro.glagouy.news.databases.NewsDatabase;
import com.gmail.pro.glagouy.news.listeners.NewsListener;
import com.gmail.pro.glagouy.news.models.News;
import com.gmail.pro.glagouy.news.viewmodels.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsFragment extends Fragment implements NewsListener {
    private List<News> newsList;
    View rootView;
    RecyclerView recyclerView;
    NewsAdapter adapter;
    private NewsViewModel model;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(NewsViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.recycler, container, false);
        setNews(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model.getNews().observe(this, new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> news) {
                adapter.setNews(news);
                adapter.notifyDataSetChanged();
            }
        });
    }

    void setNews(View view){
        recyclerView = view.findViewById(R.id.list_news);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(llm);
        adapter = new NewsAdapter(new ArrayList<News>(), this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSelect(News news) {
        NewsDetailFragment detailFragment = new NewsDetailFragment();
        FragmentTransaction detailTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        detailTransaction.replace(R.id.fragment_container, detailFragment);
        detailTransaction.addToBackStack(null);
        detailTransaction.commit();

        model.setSelected(news);
    }

    @Override
    public void onLike(News news) {
        this.model.updateOneNews(news);
    }

    @Override
    public void onShare(News news) {

    }
}
