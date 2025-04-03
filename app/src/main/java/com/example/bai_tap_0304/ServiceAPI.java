package com.example.bai_tap_0304;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ServiceAPI {
    public static final String BASE_URL = "http://app.iotstar.vn:8081/appfoods/";

    Gson gson = new GsonBuilder().setDateFormat("yyyy MM dd HH:mm:ss").create();

    ServiceAPI serviceapi = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ServiceAPI.class);


    @Multipart
    @POST("updateimages.php")
    Call<List<ImageUpload>> upload(@Part(Const.ID)RequestBody id,
                                   @Part MultipartBody.Part images);


}
