package com.example.y_practice2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class busking_category extends AppCompatActivity {

    String [] buskingList = {"오늘은 새우깡","남쪽으로 도망가","쏘아올린 북극곰",
            "오늘은 새우깡","남쪽으로 도망가","쏘아올린 북극곰"};
    ListView listView;
    RelativeLayout relativeLayout;
    Main_Fragment main_fragment;
    Mypage_Fragment mypage_fragment;
    Map_Fragment map_fragment;
    Button request_permission;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busking_category);

        main_fragment = new Main_Fragment();
        mypage_fragment = new Mypage_Fragment();
        map_fragment = new Map_Fragment();
        request_permission = findViewById(R.id.btn_request_permission);
        request_permission.setOnClickListener(request_permission_click);
        relativeLayout = findViewById(R.id.busking_relativelayout);

        BottomNavigationView menu = findViewById(R.id.bottomNavigationView);

        listView = findViewById(R.id.busking_list);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplication(),buskingList);
        listView.setAdapter(customBaseAdapter);

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.person:
                        relativeLayout.setVisibility(View.GONE);
                        listView.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, mypage_fragment).commit();
                        return true;
                    case R.id.search:
                        relativeLayout.setVisibility(View.GONE);
                        listView.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, map_fragment).commit();
                        return true;
                    case R.id.home:
                        relativeLayout.setVisibility(View.GONE);
                        listView.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, main_fragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
    View.OnClickListener request_permission_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),Request_Permission.class);
            startActivity(intent);
        }
    };
}