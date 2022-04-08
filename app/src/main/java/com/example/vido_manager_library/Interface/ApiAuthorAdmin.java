package com.example.vido_manager_library.Interface;

import com.example.vido_manager_library.Models.Authors;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiAuthorAdmin {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    //https://zalobot.pmsa.com.vn/api/tacgias
    ApiAuthorAdmin apiauthoradmin = new Retrofit.Builder()
            .baseUrl("https://zalobot.pmsa.com.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiAuthorAdmin.class);

    //Set up api and link
    //==============================
    // lấy ra danh sách các tài khoản, mật khẩu để đăng nhập
    @GET("api/tacgias")
    Call<List<Authors>> covertAuthorAdmin();

    //==================================

    //==============================
    // Update data project upload database
    @PUT("api/tacgias/{id}")
    Call<Authors> updateDataAuthorAdmin(@Path("id") int id, @Body Authors authors);
    //==================================

    //Delete data and upload database
    @DELETE("api/tacgias/{id}")
    Call<Authors> deleteAuthorAdmin(@Path("id") int id);
    //==================================

    //Insert data and upload database
    @POST("api/tacgias")
    Call<Authors> insertDataAuthorAdmin(@Body Authors authors);
    //==================================
}
