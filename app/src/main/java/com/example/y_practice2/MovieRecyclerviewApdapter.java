package com.example.y_practice2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieRecyclerviewApdapter extends RecyclerView.Adapter<MovieRecyclerviewApdapter.ViewHolder> implements MainRecyclerviewClickListenerInterface {
    private ArrayList<MovieItems> posters = new ArrayList<MovieItems>();
    private MainRecyclerviewClickListenerInterface mainRecyclerviewClickListenerInterface;

    public ArrayList<MovieItems> getPosterItmes(){
        return posters;
    }

    public void setPosterItems(ArrayList<MovieItems> posterItems) {
        this.posters = posterItems;
    }

    public MainRecyclerviewClickListenerInterface getClickListenerInterface() {
        return mainRecyclerviewClickListenerInterface;
    }

    public void setClickListenerInterface(MainRecyclerviewClickListenerInterface clickListenerInterface) {
        this.mainRecyclerviewClickListenerInterface = clickListenerInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewitems = inflater.inflate(R.layout.activity_list_item,parent,false);
        return new ViewHolder(viewitems,mainRecyclerviewClickListenerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieItems movieItems = posters.get(position);
        holder.setItem(movieItems);
    }

    @Override
    public int getItemCount() {
        return posters.size();
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(mainRecyclerviewClickListenerInterface != null){
            mainRecyclerviewClickListenerInterface.onItemClick(holder,view,position);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_rvimg;
        TextView tv_rvt;
        TextView tv_rvc;
        public ViewHolder(@NonNull View itemView, MainRecyclerviewClickListenerInterface mainRecyclerviewClickListenerInterface) {
            super(itemView);
            iv_rvimg = itemView.findViewById(R.id.iv_rvimg);
            tv_rvt = itemView.findViewById(R.id.tv_rvt);
            tv_rvc = itemView.findViewById(R.id.tv_rvc);
            iv_rvimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        if (mainRecyclerviewClickListenerInterface != null){
                            mainRecyclerviewClickListenerInterface.onItemClick(ViewHolder.this,view,pos);
                        }
                    }
                }
            });
        }

        public void setItem(MovieItems movieItems) {
            iv_rvimg.setImageResource(movieItems.getIv_movielist());
            tv_rvt.setText(movieItems.getTv_movielist());
            tv_rvc.setText(movieItems.getTv_comentlist());
        }
    }
    public void addItem(MovieItems items) {
        posters.add(items);
    }
    public void setItem(ArrayList<MovieItems> movieItems){
        this.posters = movieItems;
    }
    public MovieItems getItem(int position) {
        return posters.get(position);
    }
    public void setPosters(int position,MovieItems items){
        posters.set(position,items);
    }
}
