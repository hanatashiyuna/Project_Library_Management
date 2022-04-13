package com.example.vido_manager_library.Interface;

import com.example.vido_manager_library.Models.Positions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiPositionAdmin {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    //https://zalobot.pmsa.com.vn/api/vitris
    ApiPositionAdmin apiPositionAdmin= new Retrofit.Builder()
            .baseUrl("https://zalobot.pmsa.com.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiPositionAdmin.class);

    //Set up api and link
    //==============================
    // lấy ra danh sách các tài khoản, mật khẩu để đăng nhập
    @GET("api/vitris")
    Call<List<Positions>> covertPositionAdmin();
    @GET("api/vitris/{id}")
    Call<Positions> convertPosition(@Path("id") int id);
    //==================================

    //==============================
    // Update data project upload database
    @PUT("api/vitris/{id}")
    Call<Positions> updateDataPositionAdmin(@Path("id") int id, @Body Positions positions);
    //==================================

    //Delete data and upload database
    @DELETE("api/vitris/{id}")
    Call<Positions> deleteDataPositionAdmin(@Path("id") int id);
    //==================================

    //Insert data and upload database
    @POST("api/vitris")
    Call<Positions> insertDataPositionAdmin(@Body Positions positions);
    //==================================
}
