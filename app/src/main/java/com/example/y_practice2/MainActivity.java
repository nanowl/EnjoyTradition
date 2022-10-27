package com.example.y_practice2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Main_Fragment main_fragment;
    Mypage_Fragment mypage_fragment;
    Map_Fragment map_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getHashKey(); //키해시를 호출
        main_fragment = new Main_Fragment();
        mypage_fragment = new Mypage_Fragment();
        map_fragment = new Map_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, main_fragment).commit();
        ImageButton moviebutton = findViewById(R.id.movie);
        ImageButton stagebutton = findViewById(R.id.stage);
        ImageButton concertbutton = findViewById(R.id.concert);
        ImageButton buskingbutton = findViewById(R.id.busking);
//      하단바 선언
        BottomNavigationView menu = findViewById(R.id.bottomNavigationView);

        Bundle extras = getIntent().getExtras(); //로그인했을경우 login_main에서 넘겨주는 값 받는 변수


//        stagebutton.setOnClickListener(stagebuttonlistener);
//        concertbutton.setOnClickListener(concertbuttonlistener);
//        buskingbutton.setOnClickListener(buskingbuttonlistener);
//        moviebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(),detailed_category_1.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivity(intent);
//            }
//        });


        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.person:
                        if (extras != null && !extras.equals("")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, mypage_fragment).commit();
                            return true;
                        } Intent intent = new Intent(getApplicationContext(),Login_main.class);
                          startActivity(intent);
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, map_fragment).commit();
                        return true;
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, main_fragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
//    View.OnClickListener stagebuttonlistener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Intent intent = new Intent(getApplicationContext(),detailed_category_1.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//            startActivity(intent);
//        }
//    };
//    View.OnClickListener concertbuttonlistener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Intent intent = new Intent(getApplicationContext(),detailed_category_1.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//            startActivity(intent);
//        }
//    };
//    View.OnClickListener buskingbuttonlistener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Intent intent = new Intent(getApplicationContext(),busking_category.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//            startActivity(intent);
//        }
//    };

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


