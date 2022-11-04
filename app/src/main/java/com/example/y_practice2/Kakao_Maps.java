package com.example.y_practice2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.y_practice2.databinding.MapInterfaceFrameBinding;
import com.example.y_practice2.retrofit.kakao_api;
import com.example.y_practice2.vo.ResultSearchKeyword;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Kakao_Maps extends AppCompatActivity {
    private static MapInterfaceFrameBinding binding;

    public static final String BASE_URL = "https://dapi.kakao.com/";
    public static final String API_KEY = "KakaoAK 15db3357b405f38877e1011a929d2ca9";  // REST API 키


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MapInterfaceFrameBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Retrofit retrofit = new Retrofit.Builder() // Retrofit 구성
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        kakao_api api = retrofit.create(kakao_api.class);

        searchKeyword("은행", api);
    }


    // 키워드 검색 함수
    public void searchKeyword(String keyword, kakao_api api) {

        Call<ResultSearchKeyword> call = api.getSearchKeyword(API_KEY, keyword);


        // API 서버에 요청
        call.enqueue(new Callback<ResultSearchKeyword>() {
            @Override
            public void onResponse(Call<ResultSearchKeyword> call, Response<ResultSearchKeyword> response) {
                // 통신 성공 (검색 결과는 response.body()에 담겨있음)
                Log.d("Test", "Raw: ${response.raw()}");
                Log.d("Test", "Body: ${response.body()}");
            }

            @Override
            public void onFailure(Call<ResultSearchKeyword> call, Throwable t) {
                Log.w("MainActivity", "통신 실패: ${t.message}");
            }
        });

    }

}