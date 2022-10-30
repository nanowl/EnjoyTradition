package com.example.y_practice2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.y_practice2.retrofit.customer_interface;
import com.example.y_practice2.vo.Customer;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_main extends AppCompatActivity {

    JsonArray jsonArray;
    customer_interface service;
    Button btn_login;
    TextView tv_res;
    Intent intent;

    TypeToken<List<Customer>> typeToken =
            new TypeToken<List<Customer>>() {
            };
    Gson gson2 = new Gson();
    String[] customerlist;
    Gson gson = new GsonBuilder().setLenient().create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(btn_login_click);
        tv_res = findViewById(R.id.tv_res);
        tv_res.setOnClickListener(tv_click);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://caramels.kro.kr:9632/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(customer_interface.class);


    }

    View.OnClickListener btn_login_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            Call<JsonArray> call = service.customerget();
//            call.enqueue(new Callback<JsonArray>() {
//                @Override
//                public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
//                    Log.d("성공",response.code()+"");
//                    if (response.isSuccessful()){
//
//                        jsonArray = response.body();
//                        customerlist = new String[jsonArray.size()];
//                        List<Customer> list =
//                                gson2.fromJson(jsonArray, typeToken.getType());
//                        for (int i = 0; i < jsonArray.size(); i++){
//                            final int index = i;
//                            customerlist[index] = list.get(index).getMember_id();
//                        }
//                        Log.d("결과값",customerlist[0]);
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<JsonArray> call, Throwable t) {
//                    Log.d("결과값",t.getMessage());
//                }
//            });
        }
    };
    View.OnClickListener tv_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            intent = new Intent(getApplicationContext(),Sign_up.class);
            startActivity(intent);
        }
    };

}
