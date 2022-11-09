package com.example.y_practice2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.y_practice2.vo.BuskingItems;

import java.util.ArrayList;

public class BuskingRecyclerviewApdapter extends RecyclerView.Adapter<BuskingRecyclerviewApdapter.ViewHolder> implements BuskingRecyclerviewClickListenerInterface {
    private ArrayList<BuskingItems> posters = new ArrayList<BuskingItems>();
    private BuskingRecyclerviewClickListenerInterface buskingRecyclerviewClickListenerInterface;

    public ArrayList<BuskingItems> getPosterItmes(){
        return posters;
    }

    public void setPosterItems(ArrayList<BuskingItems> posterItems) {
        this.posters = posterItems;
    }

    public BuskingRecyclerviewClickListenerInterface getClickListenerInterface() {
        return buskingRecyclerviewClickListenerInterface;
    }

    public void setClickListenerInterface(BuskingRecyclerviewClickListenerInterface clickListenerInterface) {
        this.buskingRecyclerviewClickListenerInterface = clickListenerInterface;
    }

    @NonNull
    @Override
    public BuskingRecyclerviewApdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewitems = inflater.inflate(R.layout.activity_buskinglist_item,parent,false);
        return new ViewHolder(viewitems,buskingRecyclerviewClickListenerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull BuskingRecyclerviewApdapter.ViewHolder holder, int position) {
        BuskingItems buskingItems = posters.get(position);
        holder.setItem(buskingItems);
    }

    @Override
    public int getItemCount() {
        return posters.size();
    }


    @Override
    public void onItemClick(BuskingRecyclerviewApdapter.ViewHolder holder, View view, int position) {
        if (buskingRecyclerviewClickListenerInterface != null){
            buskingRecyclerviewClickListenerInterface.onItemClick(holder,view,position);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_bukinglist;
        TextView tv_buskinglist;
        TextView tv_buskingcomentlist;
        public ViewHolder(@NonNull View itemView, BuskingRecyclerviewClickListenerInterface buskingRecyclerviewClickListenerInterface) {
            super(itemView);
            iv_bukinglist=itemView.findViewById(R.id.iv_bukinglist);
            tv_buskinglist=itemView.findViewById(R.id.tv_buskinglist);
            tv_buskingcomentlist=itemView.findViewById(R.id.tv_buskingcomentlist);
            iv_bukinglist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (buskingRecyclerviewClickListenerInterface != null){
                        buskingRecyclerviewClickListenerInterface.onItemClick(ViewHolder.this,view,pos);
                    }
                }
            });
            tv_buskinglist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (buskingRecyclerviewClickListenerInterface != null){
                        buskingRecyclerviewClickListenerInterface.onItemClick(ViewHolder.this,view,pos);
                    }
                }
            });
            tv_buskingcomentlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (buskingRecyclerviewClickListenerInterface != null){
                        buskingRecyclerviewClickListenerInterface.onItemClick(ViewHolder.this,view,pos);
                    }
                }
            });
        }

        public void setItem(BuskingItems buskingItems) {
            iv_bukinglist.setImageResource(buskingItems.getIv_bukinglist());
            tv_buskinglist.setText(buskingItems.getTv_buskinglist());
            tv_buskingcomentlist.setText(buskingItems.getTv_buskingcomentlist());
        }
    }
    public void addItems(BuskingItems items){
        posters.add(items);
    }
    public void setItem(ArrayList<BuskingItems> buskingItems){this.posters = buskingItems;}
    public BuskingItems getItem(int position){
        return posters.get(position);
    }
    public void setPosters(int position,BuskingItems items){
        posters.set(position,items);
    }
}

