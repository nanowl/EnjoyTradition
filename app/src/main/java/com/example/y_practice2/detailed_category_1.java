package com.example.y_practice2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class detailed_category_1 extends AppCompatActivity {

    Main_Fragment main_fragment;
    Mypage_Fragment mypage_fragment;
    Map_Fragment map_fragment;
    TextView tv_topname;
    String textchange = "";
    String logincheck = "";
    String [] fruitsList = {"오늘은 새우깡","남쪽으로 도망가","쏘아올린 북극곰",
            "오늘은 새우깡","남쪽으로 도망가","쏘아올린 북극곰"};
    ListView listView;
    TextView textView;
    private RecyclerView recyclerView;
    MovieRecyclerviewApdapter movieRecyclerviewApdapter;

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

        Bundle extras = getIntent().getExtras(); //Main_Fragment에서 넘겨주는 값 받는 변수

        //쉐어드
        SharedPreferences pref = getSharedPreferences("token", MODE_PRIVATE);    // token 이름의 기본모드 설정
        logincheck = pref.getString("Login", "");

        if (extras != null) {
            textchange = extras.getString("movie"); //key값인 movie를 받아와 버튼을 구분
        }

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
//        listView = findViewById(R.id.v_list);
//        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplication(),fruitsList);
//        listView.setAdapter(customBaseAdapter);


        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.person:
                        textView.setVisibility(View.GONE);
                        listView.setVisibility(View.GONE);
                        if(logincheck.equals("")){
                            Intent intent = new Intent(getApplicationContext(),Login_main.class);
                            startActivity(intent);
                        }else {
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, mypage_fragment).commit();
                        }
                        return true;
                    case R.id.search:
                        textView.setVisibility(View.GONE);
                        listView.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, map_fragment).commit();
                        return true;
                    case R.id.home:
                        textView.setVisibility(View.GONE);
                        listView.setVisibility(View.GONE);
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

        movieRecyclerviewApdapter.addItem(new MovieItems(R.drawable.busker,"영화관이름","내용"));
        movieRecyclerviewApdapter.addItem(new MovieItems(R.drawable.busker,"제발되라","내용"));
        recyclerView.setAdapter(movieRecyclerviewApdapter);

        movieRecyclerviewApdapter.setClickListenerInterface(new MainRecyclerviewClickListenerInterface() {
            @Override
            public void onItemClick(MovieRecyclerviewApdapter.ViewHolder holder, View view, int position) {
                MovieItems items = movieRecyclerviewApdapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(),Categorie_detail.class);
                intent.putExtra("movieid",position);
                startActivity(intent);
            }
        });
    }
    }
