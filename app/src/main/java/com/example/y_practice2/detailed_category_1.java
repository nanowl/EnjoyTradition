package com.example.y_practice2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class detailed_category_1 extends AppCompatActivity {

    Main_Fragment main_fragment;
    Mypage_Fragment mypage_fragment;
    Map_Fragment map_fragment;

    String [] fruitsList = {"오늘은 새우깡","남쪽으로 도망가","쏘아올린 북극곰",
            "오늘은 새우깡","남쪽으로 도망가","쏘아올린 북극곰"};
    ListView listView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_category1);
        main_fragment = new Main_Fragment();
        mypage_fragment = new Mypage_Fragment();
        map_fragment = new Map_Fragment();

        BottomNavigationView menu = findViewById(R.id.bottomNavigationView);

        textView = findViewById(R.id.tv_deteailed_category1);
        listView = findViewById(R.id.v_list);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplication(),fruitsList);
        listView.setAdapter(customBaseAdapter);

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.person:
                        textView.setVisibility(View.GONE);
                        listView.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, mypage_fragment).commit();
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
    }
