package com.allaber.viewer;

import com.google.gson.annotations.SerializedName;

public class ProfileInfo {

    @SerializedName("response")
    private User response;

    public ProfileInfo(User response) {
        this.response = response;
    }

    public ProfileInfo() {
    }

    public User getResponse() {
        return response;
    }

    public void setResponse(User response) {
        this.response = response;
    }
}
