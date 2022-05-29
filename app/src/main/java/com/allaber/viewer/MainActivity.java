package com.allaber.viewer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.vk.api.sdk.VK;
import com.vk.api.sdk.auth.VKAccessToken;
import com.vk.api.sdk.auth.VKAuthCallback;
import com.vk.api.sdk.auth.VKScope;
import com.vk.api.sdk.exceptions.VKAuthException;

import java.lang.reflect.Array;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private VKAccessToken access_token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VK.login(this, Arrays.asList(VKScope.WALL, VKScope.PHOTOS));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        VKAuthCallback callback = new VKAuthCallback() {
            @Override
            public void onLoginFailed(@NonNull VKAuthException e) {
                Toast.makeText(getApplicationContext(), "RESULT_WRONG", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onLogin(@NonNull VKAccessToken vkAccessToken) {
                access_token = vkAccessToken;



                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.vk.com/method/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Call<ProfileInfo> profileInfo = retrofit.create(APIService.class).getProfileInfo(access_token.getAccessToken(), "5.131");

                profileInfo.enqueue(new Callback<ProfileInfo>() {
                    @Override
                    public void onResponse(Call<ProfileInfo> call, Response<ProfileInfo> response) {
                        if (response.isSuccessful()) {
                            ProfileInfo body = response.body();
                            User response1 = body.getResponse();
                            Toast.makeText(getApplicationContext(), response1.toString(), Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(getApplicationContext(), "response code " + response.code(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ProfileInfo> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
                    }
                });

               // Toast.makeText(getApplicationContext(), "RESULT_OK", Toast.LENGTH_SHORT).show();
            }
        };



        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data);
        }



    }
}