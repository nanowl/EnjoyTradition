package com.example.y_practice2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

public class Main_Fragment extends Fragment implements View.OnClickListener{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_frame, container, false);

        ImageButton moviebutton = view.findViewById(R.id.movie);
        ImageButton stagebutton = view.findViewById(R.id.stage);
        ImageButton concertbutton = view.findViewById(R.id.concert);
        ImageButton buskingbutton = view.findViewById(R.id.busking);

        moviebutton.setOnClickListener(this);
        stagebutton.setOnClickListener(this);
        concertbutton.setOnClickListener(this);
        buskingbutton.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.movie:
                Intent intent = new Intent(getActivity(),detailed_category_1.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("movie","영화관");
                startActivity(intent);
                Log.d("onclick","btnNum : "+ R.id.movie);
                break;
            case R.id.stage:
                Intent intent2 = new Intent(getActivity(),detailed_category_1.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent2.putExtra("movie","연극장");
                startActivity(intent2);
                Log.d("onclick","btnNum : "+ R.id.stage);
                break;
            case R.id.concert:
                Intent intent3 = new Intent(getActivity(),detailed_category_1.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent3.putExtra("movie","공연장");
                startActivity(intent3);
                Log.d("onclick","btnNum : "+ R.id.concert);
                break;
            case R.id.busking:
                Intent intent4 = new Intent(getActivity(),busking_category.class);
                intent4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent4.putExtra("movie","버스킹");
                startActivity(intent4);
                Log.d("onclick","btnNum : "+ R.id.busking);
                break;
        }
    }
}
