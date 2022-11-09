package com.example.y_practice2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.y_practice2.retrofit.Theater_interface;
import com.example.y_practice2.retrofit.busking_interface;
import com.example.y_practice2.vo.BuskingItems;
import com.example.y_practice2.vo.Busking_vo;
import com.example.y_practice2.vo.MovieItems;
import com.example.y_practice2.vo.Theater_vo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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

public class detailed_category_1 extends AppCompatActivity {

    Main_Fragment main_fragment;
    Mypage_Fragment mypage_fragment;
    Map_Fragment map_fragment;
    FrameLayout main_frame;
    TextView tv_topname;
    String textchange = "";
    String logincheck = "";
    String [] fruitsList = {"오늘은 새우깡","남쪽으로 도망가","쏘아올린 북극곰",
            "오늘은 새우깡","남쪽으로 도망가","쏘아올린 북극곰"};
    TextView textView;
    private RecyclerView recyclerView;
    MovieRecyclerviewApdapter movieRecyclerviewApdapter;
    Gson gson = new GsonBuilder().setLenient().create();
    Theater_interface theater_interface;
    JsonArray jsonArray;
    TypeToken<List<Theater_vo>> typeToken =
            new TypeToken<List<Theater_vo>>() {};
    Gson gson2 = new Gson();
    int[] theaterid;
    String[] theatername;
    String[] theater_phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_category1);
        main_fragment = new Main_Fragment();
        mypage_fragment = new Mypage_Fragment();
        map_fragment = new Map_Fragment();
        MovieRecyclerviewApdapter movieRecyclerviewApdapter;

        BottomNavigationView menu = findViewById(R.id.bottomNavigationView);
        tv_topname = findViewById(R.id.tv_deteailed_category1);
        main_frame = findViewById(R.id.main_frame);
        Bundle extras = getIntent().getExtras(); //Main_Fragment에서 넘겨주는 값 받는 변수

        //쉐어드
        SharedPreferences pref = getSharedPreferences("token", MODE_PRIVATE);    // token 이름의 기본모드 설정
        logincheck = pref.getString("Login", "");
        Log.d("뭐지",logincheck);
        if (extras != null) {
            textchange = extras.getString("movie"); //key값인 movie를 받아와 버튼을 구분
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://caramels.kro.kr:9632/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        theater_interface = retrofit.create(Theater_interface.class);

        //버튼을 구분하여 상단 메시지 변경
        //영화관
        if (textchange.equals("영화관")){
            tv_topname.setText("영화관");
        }//연극장
        else if (textchange.equals("연극장")){
            tv_topname.setText("연극장");
        }//콘서트장
        else if (textchange.equals("공연장")){
            tv_topname.setText("공연장");
        }
        recyclerViewMoviedataSetting();

        textView = findViewById(R.id.tv_deteailed_category1);


        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.person:
                        textView.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                        if(logincheck.equals("")){
                            Intent intent = new Intent(getApplicationContext(),Login_main.class);
                            startActivity(intent);
                        }else {
                            main_frame.setVisibility(View.VISIBLE);
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, mypage_fragment).commit();
                        }
                        return true;
                    case R.id.search:
                        textView.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                        main_frame.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, map_fragment).commit();
                        return true;
                    case R.id.home:
                        textView.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                        main_frame.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, main_fragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
    //영화관 리스트 recyclerview 어뎁터 설정
    public void recyclerViewMovieListSetting() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        movieRecyclerviewApdapter = new MovieRecyclerviewApdapter();
    }
    public void recyclerViewMoviedataSetting(){
        recyclerViewMovieListSetting();
        if (textchange.equals("영화관")){
            movie();
        } else if(textchange.equals("공연장")){

        } else if (textchange.equals("연극장")){

        }

        movieRecyclerviewApdapter.setClickListenerInterface(new MainRecyclerviewClickListenerInterface() {
            @Override
            public void onItemClick(MovieRecyclerviewApdapter.ViewHolder holder, View view, int position) {
                MovieItems items = movieRecyclerviewApdapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(),Categorie_detail.class);
                intent.putExtra("movieid",position);
                Log.d("movieid",""+position);
                startActivity(intent);
            }
        });
    }
    public void movie(){
        Call<JsonArray> call = theater_interface.getTheater();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                Log.d("성공", response.code() + "");
                if (response.isSuccessful()) {

                    jsonArray = response.body();
                    theaterid = new int[jsonArray.size()];
                    theatername = new String[jsonArray.size()];
                    theater_phone_number = new String[jsonArray.size()];
                    List<Theater_vo> list =
                            gson2.fromJson(jsonArray, typeToken.getType());
                    for (int i = 0; i < 6; i++) {
                        final int index = i;
                        theaterid[index] = list.get(index).getTheater_id();
                        theatername[index] = list.get(index).getTheater_name();
                        theater_phone_number[index] = list.get(index).getTheater_phone_number();
                        movieRecyclerviewApdapter.addItem(new MovieItems(R.drawable.busker,theatername[i],theater_phone_number[i]));
                    }
                    recyclerView.setAdapter(movieRecyclerviewApdapter);
                    Log.d("결과값", theaterid[0]+"");
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("결과값", t.getMessage());
            }
        });

    }

    }
