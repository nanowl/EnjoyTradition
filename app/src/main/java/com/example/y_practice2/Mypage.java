package com.example.y_practice2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Mypage extends AppCompatActivity {
    Mypage_Fragment mypage_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);
        mypage_fragment = new Mypage_Fragment();

        BottomNavigationView menu = findViewById(R.id.bottomNavigationView);


        getSupportFragmentManager().beginTransaction().replace(R.id.my_page, mypage_fragment).commit();

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.person:
                        Intent intent1 = new Intent(getApplicationContext(),Mypage_Fragment.class);
                        startActivity(intent1);
                    case R.id.search:
                        Intent intent2 = new Intent(getApplicationContext(),Map_UserInterface.class);
                        startActivity(intent2);
                    case R.id.home:
                        Intent intent3 = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent3);
                }
                return false;
            }
        });
    }

}
