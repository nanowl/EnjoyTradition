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

import com.example.y_practice2.retrofit.busking_interface;
import com.example.y_practice2.retrofit.customer_interface;
import com.example.y_practice2.vo.BuskingItems;
import com.example.y_practice2.vo.Busking_vo;
import com.example.y_practice2.vo.MovieItems;
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

    busking_interface busking_interface;
    Gson gson = new GsonBuilder().setLenient().create();
    String[] buskinglist;
    String[] buskingcommnetlist;
    JsonArray jsonArray;
    TypeToken<List<Busking_vo>> typeToken =
            new TypeToken<List<Busking_vo>>() {};
    Busking_vo busking_vo;
    Gson gson2 = new Gson();


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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://caramels.kro.kr:9632/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        busking_interface = retrofit.create(busking_interface.class);

        busrecyclerviewdatasetting();


        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.person:
                        relativeLayout.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, mypage_fragment).commit();
                        return true;
                    case R.id.search:
                        relativeLayout.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, map_fragment).commit();
                        return true;
                    case R.id.home:
                        relativeLayout.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
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
        Call<JsonArray> call = busking_interface.getbusking();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                Log.d("성공", response.code() + "");
                if (response.isSuccessful()) {

                    jsonArray = response.body();
                    buskinglist = new String[jsonArray.size()];
                    buskingcommnetlist = new String[jsonArray.size()];
                    List<Busking_vo> list =
                            gson2.fromJson(jsonArray, typeToken.getType());
                    for (int i = 0; i < jsonArray.size(); i++) {
                        final int index = i;
                        buskinglist[index] = list.get(index).getBusking_user_name();
                        buskingcommnetlist[index] = list.get(index).getBusking_genre();
                        busRecyclerviewApdapter.addItems(new BuskingItems(R.drawable.busker,buskinglist[i],buskingcommnetlist[i]));
                    }
                    recyclerView.setAdapter(busRecyclerviewApdapter);
                    Log.d("결과값", buskinglist[0]);
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("결과값", t.getMessage());
            }
        });


        busRecyclerviewApdapter.setClickListenerInterface(new BuskingRecyclerviewClickListenerInterface() {
            @Override
            public void onItemClick(BuskingRecyclerviewApdapter.ViewHolder holder, View view, int position) {
                BuskingItems buskingItems = busRecyclerviewApdapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(),Categorie_detail.class);
                intent.putExtra("buskingid",position);
                intent.putExtra("place","버스킹");
                Log.d("뭐지",position+"");
                startActivity(intent);
            }
        });
    }

}
