package com.gmail.pro.glagouy.news.viewmodels;

import com.gmail.pro.glagouy.news.models.News;
import com.gmail.pro.glagouy.news.models.NewsList;
import com.gmail.pro.glagouy.news.networks.NewsService;
import com.gmail.pro.glagouy.news.utils.Constants;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {
    private MutableLiveData<List<News>> newsLiveData;
    public LiveData<List<News>> getNews(){
        if(newsLiveData == null) {
            newsLiveData = new MutableLiveData<>();
            loadNews();
        }
        return newsLiveData;
    }

    private void loadNews(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsService service = retrofit.create(NewsService.class);

        final Call<NewsList> news = service.listNews("is", Constants.getApiKey());
        news.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(@NonNull Call<NewsList> call, @NonNull Response<NewsList> response) {
                NewsList responseBody = response.body();
                if(responseBody != null){
                    List<News> newsList = responseBody.getArticles();
                    newsLiveData.setValue(newsList);
                }
            }

            @Override
            public void onFailure(@NonNull Call<NewsList> call, @NonNull Throwable t) {
                System.out.println("Fail");
            }
        });
    }
}
