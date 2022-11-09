package com.example.y_practice2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.y_practice2.vo.BuskingItems;
import com.example.y_practice2.vo.MovieItems;
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
    private RecyclerView recyclerView;
    BuskingRecyclerviewApdapter busRecyclerviewApdapter;



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

        busrecyclerviewdatasetting();

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
    public void busrecyclerviewlistsetting(){
        recyclerView = (RecyclerView) findViewById(R.id.busking_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        busRecyclerviewApdapter = new BuskingRecyclerviewApdapter();
    }
    public void busrecyclerviewdatasetting(){
        busrecyclerviewlistsetting();
        for (int i=0; i<5; i++){
            busRecyclerviewApdapter.addItems(new BuskingItems(R.drawable.busker,"버스킹제목","버스킹내용"));
        }
        recyclerView.setAdapter(busRecyclerviewApdapter);

        busRecyclerviewApdapter.setClickListenerInterface(new BuskingRecyclerviewClickListenerInterface() {
            @Override
            public void onItemClick(BuskingRecyclerviewApdapter.ViewHolder holder, View view, int position) {
                BuskingItems buskingItems = busRecyclerviewApdapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(),Categorie_detail.class);
                intent.putExtra("buskingid",position);
                Log.d("뭐지",position+"");
                startActivity(intent);
            }
        });
    }
}
