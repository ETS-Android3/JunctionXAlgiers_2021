package com.example.hamoudApp.models;

public class myTaskModelList {
    private int image;
    private String desc;
    private String dateText ;
    private String timeText ;

    public myTaskModelList(int image, String desc , String dateText , String timeText) {
        this.image = image;
        this.desc = desc;
        this.dateText = dateText ;
        this.timeText = timeText ;
    }

    public String getdateText() {
        return dateText;
    }

    public void setdateText(String dateText) {
        this.dateText = dateText;
    }

    public String gettimeText() {
        return timeText;
    }

    public void settimeText(String timeText) {
        this.timeText = timeText;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}