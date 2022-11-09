package com.example.y_practice2.retrofit;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Concert_interface {
    @GET("concerts")
    Call<JsonArray> getconcert();

    @GET("concerts/{concert_hall_id}")
    Call<JsonArray> getConcertHallDetail(@Path("concert_hall_id") int concert_hall_id);

    @GET("concerts-concert/{concert_hall_id}")
    Call<JsonArray> getConcertList(@Path("concert_hall_id") int concert_hall_id);
}
