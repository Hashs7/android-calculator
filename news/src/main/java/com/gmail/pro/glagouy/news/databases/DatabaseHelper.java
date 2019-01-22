package com.gmail.pro.glagouy.news.databases;

import android.content.Context;

import java.util.concurrent.Callable;

import androidx.room.Room;
import bolts.Continuation;
import bolts.Task;

public class DatabaseHelper {
    private static NewsDatabase database;

    public static void init(final Context context){
        Task.callInBackground(new Callable<Void>() {
            @Override
            public Void call() {
                database = Room.databaseBuilder(context,
                        NewsDatabase.class, "news-db").build();
                return null;
            }
        }).continueWith(new Continuation<Void, Void>() {
            @Override
            public Void then(Task<Void> task) {
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    public static NewsDatabase getDatabase(){
        return database;
    }
}
