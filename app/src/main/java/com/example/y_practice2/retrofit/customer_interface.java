package com.example.y_practice2.retrofit;

import com.example.y_practice2.vo.Customer;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface customer_interface {

    @GET("members")
    Call<JsonArray> customerget();

    @GET("members-login")
    Call<String> customerLogin(@Query("member_id") String member_id,@Query("member_pw") String member_pw);

    @POST("members")
    Call<String> customerRegister(@Body Customer customer);
}
