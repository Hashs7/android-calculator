package com.gmail.pro.glagouy.news.databases.daos;

import com.gmail.pro.glagouy.news.models.News;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM news")
    List<News> getAll();

    @Query("SELECT * FROM news WHERE id = :id")
    News findOne(int id);

    @Query("SELECT * FROM news WHERE id IN (:ids)")
    News findByIds(int[] ids);

    @Query("SELECT * FROM news WHERE news_title LIKE :title")
    News findByTitle(String title);

    @Insert
    void insertAll(List<News> news);

    @Delete
    void delete(News news);

    @Update
    void update(News news);

}
