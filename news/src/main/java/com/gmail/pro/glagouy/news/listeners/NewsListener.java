package com.gmail.pro.glagouy.news.listeners;

import com.gmail.pro.glagouy.news.models.News;

public interface NewsListener {
    void onSelect(News news);
    void onLike(News news);
}
