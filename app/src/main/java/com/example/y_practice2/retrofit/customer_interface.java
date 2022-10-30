package com.example.y_practice2.retrofit;

import com.example.y_practice2.vo.Customer;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface customer_interface {

    @GET("members")
    Call<JsonArray> customerget();

    @POST("members")
    Call<String> customerRegister(@Body Customer customer);
}
