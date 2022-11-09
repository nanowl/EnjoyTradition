package com.example.y_practice2.vo;

public class ConcertHall {

    int concert_hall_id;
    String concert_hall_si;
    String concert_hall_gu;
    String concert_hall_address;
    String concert_hall_name;
    String concert_hall_date;
    String concert_hall_seat;

    public ConcertHall(int concert_hall_id, String concert_hall_si, String concert_hall_gu, String concert_hall_address, String concert_hall_name, String concert_hall_date, String concert_hall_seat) {
        this.concert_hall_id = concert_hall_id;
        this.concert_hall_si = concert_hall_si;
        this.concert_hall_gu = concert_hall_gu;
        this.concert_hall_address = concert_hall_address;
        this.concert_hall_name = concert_hall_name;
        this.concert_hall_date = concert_hall_date;
        this.concert_hall_seat = concert_hall_seat;
    }

    public int getConcert_hall_id() {
        return concert_hall_id;
    }

    public void setConcert_hall_id(int concert_hall_id) {
        this.concert_hall_id = concert_hall_id;
    }

    public String getConcert_hall_si() {
        return concert_hall_si;
    }

    public void setConcert_hall_si(String concert_hall_si) {
        this.concert_hall_si = concert_hall_si;
    }

    public String getConcert_hall_gu() {
        return concert_hall_gu;
    }

    public void setConcert_hall_gu(String concert_hall_gu) {
        this.concert_hall_gu = concert_hall_gu;
    }

    public String getConcert_hall_address() {
        return concert_hall_address;
    }

    public void setConcert_hall_address(String concert_hall_address) {
        this.concert_hall_address = concert_hall_address;
    }

    public String getConcert_hall_name() {
        return concert_hall_name;
    }

    public void setConcert_hall_name(String concert_hall_name) {
        this.concert_hall_name = concert_hall_name;
    }

    public String getConcert_hall_date() {
        return concert_hall_date;
    }

    public void setConcert_hall_date(String concert_hall_date) {
        this.concert_hall_date = concert_hall_date;
    }

    public String getConcert_hall_seat() {
        return concert_hall_seat;
    }

    public void setConcert_hall_seat(String concert_hall_seat) {
        this.concert_hall_seat = concert_hall_seat;
    }
}
