package com.example.y_practice2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.y_practice2.retrofit.movie_interface;
import com.example.y_practice2.vo.Movie;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import me.relex.circleindicator.CircleIndicator3;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Categorie_detail extends AppCompatActivity {

    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 4;
    private CircleIndicator3 mIndicator;

    private TextView title,location,current_list;
    private Button map,sns,homepage;

    Gson gson = new GsonBuilder().setLenient().create();


    Main_Fragment main_fragment;
    Mypage_Fragment mypage_fragment;
    Map_Fragment map_fragment;

    JsonArray jsonArray;
    Gson gson2 = new Gson();
    TypeToken<List<Movie>> movieToken = new TypeToken<List<Movie>>() {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorie_detail);

        title = findViewById(R.id.tv_detail_title); // 글 제목
        location = findViewById(R.id.tv_detail_location); // 영화관, 극장, 버스킹의 상세한 위치
        current_list = findViewById(R.id.tv_current_list); // 해당 영화관이나 극장의 현재 상영중인 작품 리스트, 버스킹의 경우 해당 무대에서 보여줄 곡 리스트 간략히

        map = findViewById(R.id.btn_map); // 지도로 보냄
        sns = findViewById(R.id.btn_sns); // sns link로 보냄
        homepage = findViewById(R.id.btn_homepage); // homp 링크로 보냄

        BottomNavigationView menu = findViewById(R.id.bottomNavigationView);//하단 바

        int id = getIntent().getIntExtra("movieid",0); // 각각 id값 초기화
        String place = getIntent().getStringExtra("place");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://caramels.kro.kr:9632/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        if (place == "영화관") {
            movie_interface service;
            service = retrofit.create(movie_interface.class);
            Call<JsonArray> call = service.getMovieDetail(id + 1);
            call.enqueue(new Callback<JsonArray>() {
                @Override
                public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                    String[] movie_name_kr;

                    jsonArray = response.body();
                    movie_name_kr = new String[jsonArray.size()];
                    List<Movie> movieList = gson2.fromJson(jsonArray, movieToken.getType());
                    movie_name_kr[0] = movieList.get(0).getMovie_name_kr();
                    Log.i("Test1", String.valueOf(movie_name_kr[0]));

                    title.setText(movie_name_kr[0]);

                }

                @Override
                public void onFailure(Call<JsonArray> call, Throwable t) {
                    Log.d("오류출력", t.getMessage());
                }
            });
        } else if (place == "연극장") {

        } else if (place == "공연장") {

        }

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.person:
//                        Intent mypage = new Intent(getApplicationContext(),)
                        return true;
                    case R.id.search:
                        Intent search = new Intent(getApplicationContext(),Map_UserInterface.class);
                        startActivity(search);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                    case R.id.home:
                        Intent homepage = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(homepage);
                        overridePendingTransition(0, 0); //애니메이션 없애기
                }
                return false;
            }
        });

        /**
         * 가로 슬라이드 뷰 Fragment
         */

        //ViewPager2
        mPager = findViewById(R.id.viewpager);
        //Adapter
        pagerAdapter = new Categorie_Image_Adapter(this, num_page);
        mPager.setAdapter(pagerAdapter);

        //ViewPager Setting
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        /**
         * 이 부분 조정하여 처음 시작하는 이미지 설정.
         * 2000장 생성하였으니 현재위치 1002로 설정하여
         * 좌 우로 슬라이딩 할 수 있게 함. 거의 무한대로
         */
        //Indicator
        mIndicator = findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.createIndicators(num_page,0);

        mPager.setCurrentItem(1000); //시작 지점
        mPager.setOffscreenPageLimit(4); //최대 이미지 수

        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator.animatePageSelected(position%num_page);
            }
        });



    }
}
