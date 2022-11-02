package com.example.y_practice2;

public class MovieItems {
    int iv_movielist;
    String tv_movielist;

    public String getTv_comentlist() {
        return tv_comentlist;
    }

    public void setTv_comentlist(String tv_comentlist) {
        this.tv_comentlist = tv_comentlist;
    }

    String tv_comentlist;
    public int getIv_movielist() {
        return iv_movielist;
    }

    public void setIv_movielist(int iv_movielist) {
        this.iv_movielist = iv_movielist;
    }

    public String getTv_movielist() {
        return tv_movielist;
    }

    public void setTv_movielist(String tv_movielist) {
        this.tv_movielist = tv_movielist;
    }

    public MovieItems(int iv_movielist, String tv_movielist,String tv_comentlist) {
        this.iv_movielist = iv_movielist;
        this.tv_movielist = tv_movielist;
        this.tv_comentlist = tv_comentlist;
    }

    public MovieItems(){super();}



}
