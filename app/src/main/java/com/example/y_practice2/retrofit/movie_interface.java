package com.example.y_practice2.retrofit;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface movie_interface {

    @GET("movies")
    Call<JsonArray> getMovie();

    @GET("members-login")
    Call<String> customerLogin(@Query("member_id") String member_id,@Query("member_pw") String member_pw);

    @GET("movies/{movie_id}")
    Call<JsonArray> getMovieDetail(@Path("movie_id") int movie_id);
}
