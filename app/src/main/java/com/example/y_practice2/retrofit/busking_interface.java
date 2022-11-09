package com.example.y_practice2.retrofit;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface busking_interface {
    @GET("busking-list")
    Call<JsonArray> getbusking();

    @GET("busking/{busking_id}")
    Call<JsonArray> getbuskingDetail(@Path("busking_id") int busking_id );
}
