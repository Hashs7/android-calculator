package com.gmail.pro.glagouy.example.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.gmail.pro.glagouy.example.R;
import com.gmail.pro.glagouy.example.fragments.PlanetsFragment;
import com.gmail.pro.glagouy.example.modeles.Repo;
import com.gmail.pro.glagouy.example.networks.ArticleService;

import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        PlanetsFragment fragment = new PlanetsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);

        transaction.commit();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArticleService service = retrofit.create(ArticleService.class);

        Call<List<Repo>> repos = service.listRepos("GuillaumeLagouy");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }

    public void showAlert(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bonjour ?")
                .setPositiveButton("Ooké", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.setTitle("Question");
        AlertDialog alert = builder.create();
        alert.show();
    }
}
