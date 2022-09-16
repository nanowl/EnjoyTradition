package com.example.y_practice2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class detailed_category_1 extends AppCompatActivity {

    String [] fruitsList = {"로맨스","개그","감동"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_category1);

        listView = findViewById(R.id.v_list);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplication(),fruitsList);
        listView.setAdapter(customBaseAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("OOO 카테고리");
    }
}