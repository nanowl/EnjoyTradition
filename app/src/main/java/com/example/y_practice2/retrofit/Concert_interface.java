package com.example.y_practice2.retrofit;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Concert_interface {
    @GET("concerts")
    Call<JsonArray> getconcert();
}
