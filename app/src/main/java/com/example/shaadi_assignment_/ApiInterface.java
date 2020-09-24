package com.example.shaadi_assignment_;

import com.example.shaadi_assignment_.model.Movie;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
//        @GET("/api")
//        Call<List<Movie>> getMovies(@Query("results") String limit);
        @GET("/api")
        Call<JsonObject> getMovies(@Query("results") String limit);
}