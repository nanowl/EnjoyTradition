package com.example.y_practice2.vo;

public class Customer {

    String member_id;
    int members_rating_id;
    String member_pw;
    String member_name;
    String member_email;
    String member_phone;


    public Customer(String member_id,int members_rating_id, String member_pw, String member_name, String member_email, String member_phone) {
        this.member_id = member_id;
        this.members_rating_id = members_rating_id;
        this.member_pw = member_pw;
        this.member_name = member_name;
        this.member_email = member_email;
        this.member_phone = member_phone;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public int getMembers_rating_id() {
        return members_rating_id;
    }

    public void setMembers_rating_id(int members_rating_id) {
        this.members_rating_id = members_rating_id;
    }

    public String getMember_pw() {
        return member_pw;
    }

    public void setMember_pw(String member_pw) {
        this.member_pw = member_pw;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public String getMember_phone() {
        return member_phone;
    }

    public void setMember_phone(String member_phone) {
        this.member_phone = member_phone;
    }


}
