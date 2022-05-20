package com.example.vido_manager_library.Interface;

import com.example.vido_manager_library.Models.Borrow;
import com.example.vido_manager_library.Models.GiveBack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiGiveBackAdmin {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    //https://zalobot.pmsa.com.vn/api/booklists?search=
    ApiGiveBackAdmin apiGiveBackAdmin= new Retrofit.Builder()
            .baseUrl("http://zalobot.pmsa.com.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiGiveBackAdmin.class);

    //Set up api and link
    //==============================
    // lấy ra danh sách các tài khoản, mật khẩu để đăng nhập
    @GET("api/tras")
    Call<List<GiveBack>> covertGiveBackAdmin();

    //==================================

    //==============================
    // Update data project upload database
    @PUT("api/tras/{id}")
    Call<GiveBack> updateDataGiveBackAdmin(@Path("id") int id, @Body GiveBack giveBack);
    //==================================

    //Delete data and upload database
    @PUT("api/tras/{id}")
    Call<GiveBack> deleteDataGiveBackAdmin(@Path("id") int id);
    //==================================

    //Insert data and upload database
    @POST("api/tras")
    Call<GiveBack> insertDataGiveBackAdmin(@Body GiveBack giveBack);
    //==================================
}
