package com.example.bai_tap_0304;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {
    @POST("upload_file")
    Call<ResponseBody> uploadFile(@Part MultipartBody.Part file);
}
