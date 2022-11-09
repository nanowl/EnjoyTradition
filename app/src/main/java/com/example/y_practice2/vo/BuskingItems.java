package com.example.y_practice2.vo;

public class BuskingItems {
    int iv_bukinglist;

    public int getIv_bukinglist() {
        return iv_bukinglist;
    }

    public void setIv_bukinglist(int iv_bukinglist) {
        this.iv_bukinglist = iv_bukinglist;
    }

    public String getTv_buskinglist() {
        return tv_buskinglist;
    }

    public void setTv_buskinglist(String tv_buskinglist) {
        this.tv_buskinglist = tv_buskinglist;
    }

    public String getTv_buskingcomentlist() {
        return tv_buskingcomentlist;
    }

    public void setTv_buskingcomentlist(String tv_buskingcomentlist) {
        this.tv_buskingcomentlist = tv_buskingcomentlist;
    }

    String tv_buskinglist;
    String tv_buskingcomentlist;


    public BuskingItems(int iv_bukinglist, String tv_buskinglist, String tv_buskingcomentlist) {
        this.iv_bukinglist = iv_bukinglist;
        this.tv_buskinglist = tv_buskinglist;
        this.tv_buskingcomentlist = tv_buskingcomentlist;
    }

    public BuskingItems(){super();}



}
