package com.example.y_practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class busking_category extends AppCompatActivity {

    String [] buskingList = {"오늘은 새우깡","남쪽으로 도망가","쏘아올린 북극곰",
            "오늘은 새우깡","남쪽으로 도망가","쏘아올린 북극곰"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busking_category);

        listView = findViewById(R.id.busking_list);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplication(),buskingList);
        listView.setAdapter(customBaseAdapter);

    }
}