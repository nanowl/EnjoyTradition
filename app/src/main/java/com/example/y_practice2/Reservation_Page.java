package com.example.y_practice2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.exoplayer2.util.Log;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Reservation_Page extends AppCompatActivity{
    String logincheck = "";
    String select_text;
    String[] items = {"15:00","16:00","18:00","19:30"};

    ScrollView scrollView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation);

        SharedPreferences pref = getSharedPreferences("token", MODE_PRIVATE);    // token 이름의 기본모드 설정
        logincheck = pref.getString("Login", "");
        scrollView = findViewById(R.id.Reservation_Page_ScrollView);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_select_reservation_page);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                select_text = items[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                select_text = "";
            }
        });
    }
}
