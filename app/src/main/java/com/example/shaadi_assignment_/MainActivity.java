package com.example.shaadi_assignment_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.shaadi_assignment_.model.Movie;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<JsonArray> movieList;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    JsonObject movies;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        
        recyclerView.setLayoutManager(layoutManager);

        recyclerAdapter = new RecyclerAdapter(getApplicationContext(), movieList);
        recyclerView.setAdapter(recyclerAdapter);
    
       /* ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonObject> call = apiService.getMovies("10");
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                List<Movie> movies = response.body();
//                recyclerAdapter.setMovieList(movieList);
            }
            
            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
    
            }
        });
    }*/
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonObject> call = apiService.getMovies("10");
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                movies = response.body();
               movieList = Arrays.asList(response.body().getAsJsonArray("results"));
//                recyclerAdapter.setMovieList(movieList);
            }
    
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
        
            }
        });
    }
}