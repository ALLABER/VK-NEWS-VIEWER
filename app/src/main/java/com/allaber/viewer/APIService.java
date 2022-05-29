package com.allaber.viewer;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    @POST("account.getProfileInfo")
    Call<ProfileInfo> getProfileInfo(@Query("access_token") String access_token, @Query("v") String v);
}
