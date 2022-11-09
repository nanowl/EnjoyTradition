package com.example.y_practice2.vo;

public class Movie {

    int movie_id;
    String movie_name_kr;
    String movie_name_en;
    int movie_year;
    String movie_country;
    String movie_type;
    String movie_genre;
    String movie_state;
    String movie_director;
    String movie_company;

    public Movie(int movie_id, String movie_name_kr, String movie_name_en, int movie_year, String movie_country, String movie_type, String movie_genre, String movie_state, String movie_director, String movie_company) {
        this.movie_id = movie_id;
        this.movie_name_kr = movie_name_kr;
        this.movie_name_en = movie_name_en;
        this.movie_year = movie_year;
        this.movie_country = movie_country;
        this.movie_type = movie_type;
        this.movie_genre = movie_genre;
        this.movie_state = movie_state;
        this.movie_director = movie_director;
        this.movie_company = movie_company;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name_kr() {
        return movie_name_kr;
    }

    public void setMovie_name_kr(String movie_name_kr) {
        this.movie_name_kr = movie_name_kr;
    }

    public String getMovie_name_en() {
        return movie_name_en;
    }

    public void setMovie_name_en(String movie_name_en) {
        this.movie_name_en = movie_name_en;
    }

    public int getMovie_year() {
        return movie_year;
    }

    public void setMovie_year(int movie_year) {
        this.movie_year = movie_year;
    }

    public String getMovie_country() {
        return movie_country;
    }

    public void setMovie_country(String movie_country) {
        this.movie_country = movie_country;
    }

    public String getMovie_type() {
        return movie_type;
    }

    public void setMovie_type(String movie_type) {
        this.movie_type = movie_type;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    public String getMovie_state() {
        return movie_state;
    }

    public void setMovie_state(String movie_state) {
        this.movie_state = movie_state;
    }

    public String getMovie_director() {
        return movie_director;
    }

    public void setMovie_director(String movie_director) {
        this.movie_director = movie_director;
    }

    public String getMovie_company() {
        return movie_company;
    }

    public void setMovie_company(String movie_company) {
        this.movie_company = movie_company;
    }
}
