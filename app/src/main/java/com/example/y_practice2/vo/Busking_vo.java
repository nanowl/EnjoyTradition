package com.example.y_practice2.vo;

public class Busking_vo {
    int busking_id;
    String member_id;
    String busking_user_name;
    String busking_genre;
    String busking_image;
    String busking_place_address;
    String busking_user_sns;
    String busking_start_timestamp;
    String busking_end_timestamp;
    String busking_place_name;

    public int getBusking_id() {
        return busking_id;
    }

    public void setBusking_id(int busking_id) {
        this.busking_id = busking_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getBusking_user_name() {
        return busking_user_name;
    }

    public void setBusking_user_name(String busking_user_name) {
        this.busking_user_name = busking_user_name;
    }

    public String getBusking_genre() {
        return busking_genre;
    }

    public void setBusking_genre(String busking_genre) {
        this.busking_genre = busking_genre;
    }

    public String getBusking_image() {
        return busking_image;
    }

    public void setBusking_image(String busking_image) {
        this.busking_image = busking_image;
    }

    public String getBusking_place_address() {
        return busking_place_address;
    }

    public void setBusking_place_address(String busking_place_address) {
        this.busking_place_address = busking_place_address;
    }

    public String getBusking_user_sns() {
        return busking_user_sns;
    }

    public void setBusking_user_sns(String busking_user_sns) {
        this.busking_user_sns = busking_user_sns;
    }

    public String getBusking_start_timestamp() {
        return busking_start_timestamp;
    }

    public void setBusking_start_timestamp(String busking_start_timestamp) {
        this.busking_start_timestamp = busking_start_timestamp;
    }

    public String getBusking_end_timestamp() {
        return busking_end_timestamp;
    }

    public void setBusking_end_timestamp(String busking_end_timestamp) {
        this.busking_end_timestamp = busking_end_timestamp;
    }

    public String getBusking_place_name() {
        return busking_place_name;
    }

    public void setBusking_place_name(String busking_place_name) {
        this.busking_place_name = busking_place_name;
    }


    public Busking_vo(int busking_id, String member_id, String busking_user_name, String busking_genre, String busking_image, String busking_place_address, String busking_user_sns, String busking_start_timestamp, String busking_end_timestamp, String busking_place_name) {
        this.busking_id = busking_id;
        this.member_id = member_id;
        this.busking_user_name = busking_user_name;
        this.busking_genre = busking_genre;
        this.busking_image = busking_image;
        this.busking_place_address = busking_place_address;
        this.busking_user_sns = busking_user_sns;
        this.busking_start_timestamp = busking_start_timestamp;
        this.busking_end_timestamp = busking_end_timestamp;
        this.busking_place_name = busking_place_name;
    }

    public  Busking_vo(){super();}
}
