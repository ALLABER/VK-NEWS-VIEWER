package com.allaber.viewer;

import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("id")
    public int id;

    @SerializedName("title")
    public String title;

    public City() {
    }
}
