package com.allaber.viewer;

import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("id")
    public int id;

    @SerializedName("home_town")
    public String home_town;

    @SerializedName("status")
    public String status;

    @SerializedName("first_name")
    public String first_name;

    @SerializedName("last_name")
    public String last_name;

    @SerializedName("bdate")
    public String bdate;

    @SerializedName("bdate_visibility")
    public int bdate_visibility;

    @SerializedName("city")
    public City city;

    @SerializedName("country")
    public Country country;

    @SerializedName("phone")
    public String phone;

    @SerializedName("relation")
    public int relation;

    @SerializedName("screen_name")
    public String screen_name;

    @SerializedName("sex")
    public int sex;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", home_town='" + home_town + '\'' +
                ", status='" + status + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", bdate='" + bdate + '\'' +
                ", bdate_visibility=" + bdate_visibility +
                ", city=" + city +
                ", country=" + country +
                ", phone='" + phone + '\'' +
                ", relation=" + relation +
                ", screen_name='" + screen_name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
