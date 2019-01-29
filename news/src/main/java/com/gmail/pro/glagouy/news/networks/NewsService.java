package com.gmail.pro.glagouy.news.networks;

import com.gmail.pro.glagouy.news.models.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {
    @GET("everything")
    Call<NewsList> listNews(
            @Query("q") String query,
            @Query("apikey") String apiKey
    );
}
