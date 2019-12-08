package com.example.imagesliderapp;

import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<String> imgurl;

    public City(String name, ArrayList<String> imgurl) {
        this.name = name;
        this.imgurl = imgurl;
    }

//    public City() {
//        imgurl = new ArrayList<>();
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getImgurl() {
        return imgurl;
    }

    public void setImgurl(ArrayList<String> imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", imgurl=" + imgurl +
                '}';
    }
}
