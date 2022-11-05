package com.example.y_practice2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Kakao_Maps extends AppCompatActivity {

    private EditText mEtAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_search_interface);

        mEtAddress = findViewById(R.id.et_address);
        //block touch
        mEtAddress.setFocusable(false);
        mEtAddress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Kakao_Maps.this, SearchActivity.class);
                getSearchResult.launch(intent);
            }
        });
    }

    private final ActivityResultLauncher<Intent> getSearchResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                // Search Activity 로부터의 결과 값이 이곳으로 전달 된다.
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null) {
                        String data = result.getData().getStringExtra("data");
                        mEtAddress.setText(data);
                    }
                }
            }
    );

}