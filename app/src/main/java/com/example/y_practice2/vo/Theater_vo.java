package com.example.y_practice2.vo;

public class Theater_vo {
    int theater_id;
    String theater_municipal_government;
    String theater_name;
    String theater_manage_number;
    String theater_license_number;
    String theater_phone_number;
    int theater_postal_code;
    String theater_all_address;
    String theater_road_address;
    int theater_road_postal_code;

    public Theater_vo(int theater_id, String theater_municipal_government, String theater_name, String theater_manage_number, String theater_license_number, String theater_phone_number, int theater_postal_code, String theater_all_address, String theater_road_address, int theater_road_postal_code) {
        this.theater_id = theater_id;
        this.theater_municipal_government = theater_municipal_government;
        this.theater_name = theater_name;
        this.theater_manage_number = theater_manage_number;
        this.theater_license_number = theater_license_number;
        this.theater_phone_number = theater_phone_number;
        this.theater_postal_code = theater_postal_code;
        this.theater_all_address = theater_all_address;
        this.theater_road_address = theater_road_address;
        this.theater_road_postal_code = theater_road_postal_code;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public String getTheater_municipal_government() {
        return theater_municipal_government;
    }

    public void setTheater_municipal_government(String theater_municipal_government) {
        this.theater_municipal_government = theater_municipal_government;
    }

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    public String getTheater_manage_number() {
        return theater_manage_number;
    }

    public void setTheater_manage_number(String theater_manage_number) {
        this.theater_manage_number = theater_manage_number;
    }

    public String getTheater_license_number() {
        return theater_license_number;
    }

    public void setTheater_license_number(String theater_license_number) {
        this.theater_license_number = theater_license_number;
    }

    public String getTheater_phone_number() {
        return theater_phone_number;
    }

    public void setTheater_phone_number(String theater_phone_number) {
        this.theater_phone_number = theater_phone_number;
    }

    public int getTheater_postal_code() {
        return theater_postal_code;
    }

    public void setTheater_postal_code(int theater_postal_code) {
        this.theater_postal_code = theater_postal_code;
    }

    public String getTheater_all_address() {
        return theater_all_address;
    }

    public void setTheater_all_address(String theater_all_address) {
        this.theater_all_address = theater_all_address;
    }

    public String getTheater_road_address() {
        return theater_road_address;
    }

    public void setTheater_road_address(String theater_road_address) {
        this.theater_road_address = theater_road_address;
    }

    public int getTheater_road_postal_code() {
        return theater_road_postal_code;
    }

    public void setTheater_road_postal_code(int theater_road_postal_code) {
        this.theater_road_postal_code = theater_road_postal_code;
    }



    public  Theater_vo(){super();}
    }
