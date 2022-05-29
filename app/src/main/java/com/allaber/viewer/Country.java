package com.allaber.viewer;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("id")
    public int id;

    @SerializedName("title")
    public String title;

    public Country() {
    }
}
