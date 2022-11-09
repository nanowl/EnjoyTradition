package com.example.y_practice2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Mypage_Fragment extends Fragment implements View.OnClickListener{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mypage_frame, container, false);

        Button button = view.findViewById(R.id.btn_customer_center);
        Button reservation_btn_list = view.findViewById(R.id.btn_request_center);
        button.setOnClickListener(this);
        reservation_btn_list.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_customer_center:
                Intent intent = new Intent(getActivity(),Customer_center.class);
                startActivity(intent);
                break;
            case R.id.btn_request_center:
                Intent intent2 = new Intent(getActivity(),reservation_list_web_view.class);
                startActivity(intent2);
        }

    }
}