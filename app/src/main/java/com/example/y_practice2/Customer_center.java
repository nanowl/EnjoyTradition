package com.example.y_practice2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Customer_center extends AppCompatActivity {
    Main_Fragment main_fragment;
    Mypage_Fragment mypage_fragment;
    Map_Fragment map_fragment;

    TextView textView;
    String[] items = {"계정 문제","버스킹 문의","기타 문의"};

    RelativeLayout relativeLayout;
    ScrollView scrollView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_and_answer);

        main_fragment = new Main_Fragment();
        mypage_fragment = new Mypage_Fragment();
        map_fragment = new Map_Fragment();

        relativeLayout = findViewById(R.id.customer_service_relativelayout);
        scrollView = findViewById(R.id.customer_service_scrollview);
        frameLayout = findViewById(R.id.main_frame);
        BottomNavigationView menu = findViewById(R.id.bottomNavigationView);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_select);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,items);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        textView = findViewById(R.id.tv_customer_center);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(items[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textView.setText("");
            }
        });

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.person:
                        relativeLayout.setVisibility(View.GONE);
                        scrollView.setVisibility(View.GONE);
                        frameLayout.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, mypage_fragment).commit();
                        return true;
                    case R.id.search:
                        relativeLayout.setVisibility(View.GONE);
                        scrollView.setVisibility(View.GONE);
                        frameLayout.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, map_fragment).commit();
                        return true;
                    case R.id.home:
                        relativeLayout.setVisibility(View.GONE);
                        scrollView.setVisibility(View.GONE);
                        frameLayout.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, main_fragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

}
