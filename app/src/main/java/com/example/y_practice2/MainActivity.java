package com.example.y_practice2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getHashKey(); //키해시를 호출

        ImageButton moviebutton = findViewById(R.id.movie);
        ImageButton stagebutton = findViewById(R.id.stage);
        ImageButton concertbutton = findViewById(R.id.concert);
        ImageButton buskingbutton = findViewById(R.id.busking);
        BottomNavigationView menu = findViewById(R.id.bottomNavigationView);

        stagebutton.setOnClickListener(stagebuttonlistener);
        concertbutton.setOnClickListener(concertbuttonlistener);
        buskingbutton.setOnClickListener(buskingbuttonlistener);
        moviebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),detailed_category_1.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

//        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.person:
////                        Intent mypage = new Intent(getApplicationContext(),)
//                        return true;
//                    case R.id.search:
//                        Intent search = new Intent(getApplicationContext(),Map_UserInterface.class);
//                        startActivity(search);
//                        overridePendingTransition(0, 0); //애니메이션 없애기
//                    case R.id.home:
//                        Intent homepage = new Intent(getApplicationContext(),MainActivity.class);
//                        startActivity(homepage);
//                        overridePendingTransition(0, 0); //애니메이션 없애기
//                }
//                return false;
//            }
//        });
    }
    View.OnClickListener stagebuttonlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),detailed_category_1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
    };
    View.OnClickListener concertbuttonlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),detailed_category_1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
    };
    View.OnClickListener buskingbuttonlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),busking_category.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
    };

    //해당 앱의 키 해시를 구하는 로직
//    private void getHashKey() {
//        PackageInfo packageInfo = null;
//        try {
//            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        if (packageInfo == null)
//            Log.e("KeyHash", "KeyHash:null");
//
//        for (Signature signature : packageInfo.signatures) {
//            try {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            } catch (NoSuchAlgorithmException e) {
//                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
//            }
//        }
    }


