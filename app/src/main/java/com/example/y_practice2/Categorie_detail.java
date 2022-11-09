package com.example.y_practice2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.y_practice2.retrofit.Concert_interface;
import com.example.y_practice2.retrofit.Theater_interface;
import com.example.y_practice2.retrofit.busking_interface;
import com.example.y_practice2.vo.Busking;
import com.example.y_practice2.vo.Concert_list;
import com.example.y_practice2.vo.Theater_vo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.util.Date;
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
    private Button map,sns,homepage,reserve;

    Gson gson = new GsonBuilder().setLenient().create();


    Main_Fragment main_fragment;
    Mypage_Fragment mypage_fragment;
    Map_Fragment map_fragment;

    JsonArray jsonArray;
    Gson gson2 = new Gson();


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
        reserve = findViewById(R.id.btn_reservation);

        BottomNavigationView menu = findViewById(R.id.bottomNavigationView);//하단 바

        int id = getIntent().getIntExtra("movieid",0); // 각각 id값 초기화
        String place = getIntent().getStringExtra("place");
        Log.i("place", place);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://caramels.kro.kr:9632/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        if (place.equals("영화관")) {
            Theater_interface service;
            TypeToken<List<Theater_vo>> movieToken = new TypeToken<List<Theater_vo>>() {};
            service = retrofit.create(Theater_interface.class);
            Call<JsonArray> call = service.getTheaterDetail(id + 1);
            call.enqueue(new Callback<JsonArray>() {
                @Override
                public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                    String[] theater_name;
                    String[] theater_address;

                    jsonArray = response.body();
                    theater_name = new String[jsonArray.size()];
                    theater_address = new String[jsonArray.size()];

                    List<Theater_vo> theaterList = gson2.fromJson(jsonArray, movieToken.getType());

                    theater_name[0] = theaterList.get(0).getTheater_name();
                    theater_address[0] = theaterList.get(0).getTheater_road_address();

                    Log.i("Test1", String.valueOf(id));

                    title.setText(theater_name[0]);
                    location.setText("주소 : \n" + theater_address[0]);

                }

                @Override
                public void onFailure(Call<JsonArray> call, Throwable t) {
                    Log.d("오류출력", t.getMessage());
                }
            });
        } else if (place.equals("연극장") ) {
            Concert_interface service2;
            TypeToken<List<Concert_list>> token = new TypeToken<List<Concert_list>>() {};
            service2 = retrofit.create(Concert_interface.class);
            Call<JsonArray> call = service2.getConcertList(id + 1);
            call.enqueue(new Callback<JsonArray>() {
                @Override
                public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                    String[] theater_play_name;
                    String[] concert_hall_name;
                    String[] concert_hall_address;

                    jsonArray = response.body();
                    theater_play_name = new String[jsonArray.size()];
                    concert_hall_name = new String[jsonArray.size()];
                    concert_hall_address = new String[jsonArray.size()];

                    List<Concert_list> concert_lists = gson2.fromJson(jsonArray, token.getType());


                    concert_hall_name[0] = concert_lists.get(0).getConcert_hall_name();
                    concert_hall_address[0] = concert_lists.get(0).getConcert_hall_address();

                    Log.i("Test1", String.valueOf(theater_play_name[0]));



                    if (jsonArray.size() > 1) {
                        title.setText(concert_hall_name[0]);
                        location.setText("주소 : \n" + concert_hall_address[0]);
                        current_list.setText("공연목록 : \n");
                        reserve.setVisibility(View.VISIBLE);
                        for (int i = 0; i < jsonArray.size(); i++) {
                            theater_play_name[i] = concert_lists.get(i).getTheater_play_name();
                            current_list.append(theater_play_name[i] + ",\n");
                        }
                    }
                }

                @Override
                public void onFailure(Call<JsonArray> call, Throwable t) {
                    Log.d("오류출력", t.getMessage());
                }
            });
        } else if (place.equals("버스킹")) {
            busking_interface service;
            TypeToken<List<Busking>> token = new TypeToken<List<Busking>>() {};
            service = retrofit.create(busking_interface.class);
            Call<JsonArray> call = service.getbuskingDetail(id + 1);
            call.enqueue(new Callback<JsonArray>() {
                @Override
                public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                    String[] busking_genre;
                    String[] busking_address;
                    String[] busking_username;
                    String[] busking_place_name;
                    String[] busking_user_sns;

                    jsonArray = response.body();
                    busking_genre = new String[jsonArray.size()];
                    busking_address = new String[jsonArray.size()];
                    busking_username = new String[jsonArray.size()];
                    busking_place_name = new String[jsonArray.size()];
                    busking_user_sns = new String[jsonArray.size()];

                    List<Busking> buskingList = gson2.fromJson(jsonArray, token.getType());

                    busking_address[0] = buskingList.get(0).getBusking_place_address();
                    busking_genre[0] = buskingList.get(0).getBusking_genre();
                    busking_username[0] = buskingList.get(0).getBusking_user_name();
                    busking_place_name[0] = buskingList.get(0).getBusking_place_name();
                    busking_user_sns[0] = buskingList.get(0).getBusking_user_sns();

                    Log.i("Test1", String.valueOf(busking_username[0]));

                    title.setText(busking_username[0]);
                    location.setText("주소 : \n" + busking_address[0] +" " + busking_place_name[0]);
                    current_list.setText("공연자 : " + busking_username[0] + "\n");
                    current_list.append("장르 : " + busking_genre[0] + "\n");
                    current_list.append("sns : " + busking_user_sns[0] + "\n");

                }

                @Override
                public void onFailure(Call<JsonArray> call, Throwable t) {
                    Log.d("오류출력", t.getMessage());
                }
            });
        }

        long mNow;
        Date mDate;
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Reservation_Page.class);
                startActivity(intent);
                intent.putExtra("price", 10000);
                intent.putExtra("today", mDate);
                Log.i("mdate:", String.valueOf(mDate));
            }
        });
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
