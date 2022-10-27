package com.example.y_practice2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_main extends AppCompatActivity {

    customer_interface service;
    Gson gson = new GsonBuilder().setLenient().create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);


//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("baseURL")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//
//        service = retrofit.create(customer_interface.class);
    }
}
