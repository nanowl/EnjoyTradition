package com.example.y_practice2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.y_practice2.retrofit.customer_interface;
import com.example.y_practice2.vo.Customer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sign_up extends AppCompatActivity {
    customer_interface service;
    Button btn_signup_complete;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_main);

        btn_signup_complete = findViewById(R.id.btn_signup_complete);
        btn_signup_complete.setOnClickListener(btn_signup_complete_click);
        // 회원가입 retrofit 통신

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://caramels.kro.kr:9632/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(customer_interface.class);


    }
    View.OnClickListener btn_signup_complete_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //editText 값들 가져오기
            int editTextId[] = {R.id.customer_id, R.id.customer_passwd,
                    R.id.customer_email, R.id.customer_name, R.id.customer_phoneNum};
            EditText editText[] = new EditText[editTextId.length];

            for (int i = 0; i < editText.length; i++) {
                editText[i] = findViewById(editTextId[i]);
                if (editText[i].getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "빈칸없이 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            String id = editText[0].getText().toString();
            String passwd = editText[1].getText().toString();
            String email = editText[2].getText().toString();
            String name = editText[3].getText().toString();
            String phone_num = editText[4].getText().toString();

            Customer customer = new Customer(id,1,passwd,name,email,phone_num);
            Call<String> call = service.customerRegister(customer);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("성공","됫나"+response.code());
                    if(response.isSuccessful()){
                        result = response.body();
                        if(!result.equals(1)){
                            Toast.makeText(getApplicationContext(),"이미있는회원입니다..",Toast.LENGTH_SHORT).show();
                            return;
                        }else {
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(),"회원가입을축하합니다.",Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("실패",t.getMessage());
                }
            });
        }
    };
}
