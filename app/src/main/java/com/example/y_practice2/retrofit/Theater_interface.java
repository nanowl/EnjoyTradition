package com.example.y_practice2.retrofit;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Theater_interface {
    @GET("theaters")
    Call<JsonArray> getTheater();

    @GET("theaters/{theater_id}")
    Call<JsonArray> getTheaterDetail(@Path("theater_id") int theater_id);
}
