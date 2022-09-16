package com.example.y_practice2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String listFruits[];

    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx,String [] listFruits){
        this.context=ctx;
        this.listFruits=listFruits;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listFruits.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_list_item,null);
        TextView tv_categoryList=(TextView) view.findViewById(R.id.tv_category1);
        tv_categoryList.setText(listFruits[position]);
        return view;
    }
}
