package com.example.hamoudApp.Config;

import com.example.hamoudApp.models.FileModel;
import com.example.hamoudApp.models.secondFileModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface HttpService {

    @Multipart
    @POST("API/upload_api.php")
    Call<FileModel> callUploadApi(@Part("title") RequestBody title,@Part("date") RequestBody date,@Part("time") RequestBody time,@Part("message") RequestBody message, @Part MultipartBody.Part image);

    @FormUrlEncoded
    @POST("API/addOneTaskDetail.php")
    Call<secondFileModel> loadDetail(@Field("id_task") String id_task, @Field("worker") String worker);

}
