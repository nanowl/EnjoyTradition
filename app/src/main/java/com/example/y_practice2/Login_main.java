package com.example.y_practice2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.y_practice2.retrofit.customer_interface;
import com.example.y_practice2.vo.Customer;
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

public class Login_main extends AppCompatActivity {

    customer_interface service;
    Button btn_login;
    TextView tv_res;
    Intent intent;
    String result;

    Gson gson = new GsonBuilder().setLenient().create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(btn_login_click);
        tv_res = findViewById(R.id.tv_res);
        tv_res.setOnClickListener(tv_click);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://caramels.kro.kr:9632/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(customer_interface.class);


    }

    View.OnClickListener btn_login_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int editTextId[] = {R.id.et_id, R.id.et_pw};
            EditText editText[] = new EditText[editTextId.length];

            for (int i = 0; i < editText.length; i++) {
                editText[i] = findViewById(editTextId[i]);
                if (editText[i].getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "빈칸없이 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

                String member_id = editText[0].getText().toString();
                String member_pw = editText[1].getText().toString();

                Log.d("id",member_id);
                Log.d("passwd",member_pw);

                Call<String> call = service.customerLogin(member_id,member_pw);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d("성공","됫나"+response.code());
                        if(response.isSuccessful()){
                            result = response.body();
                            Log.d("결과값",result);
                            if (result.equals("1")){
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                SharedPreferences pref= getSharedPreferences("token", MODE_PRIVATE);    // token 이름의 기본모드 설정
                                SharedPreferences.Editor editor= pref.edit(); //sharedPreferences를 제어할 editor를 선언
                                editor.putString("Login",member_id); // key,value 형식으로 저장
                                editor.commit();    //최종 커밋. 커밋을 해야 저장이 된다.
                                intent.putExtra("checklogin",member_id);
                                Log.d("checkLogin",member_id);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(),"로그인되었습니다.",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getApplicationContext(),"비밀번호가틀렸습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("실패",t.getMessage());
                        t.printStackTrace();
                    }
                });
        }
    };
    View.OnClickListener tv_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            intent = new Intent(getApplicationContext(),Sign_up.class);
            startActivity(intent);
        }
    };

}
