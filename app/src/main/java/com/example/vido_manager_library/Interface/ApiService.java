package com.example.vido_manager_library.Interface;

import com.example.vido_manager_library.Models.UserAuthor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

//https://zalobot.pmsa.com.vn/api/tacgias
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://zalobot.pmsa.com.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    //Set up api and link
    //==============================
    // lấy ra danh sách các tài khoản, mật khẩu để đăng nhập
    @GET("api/tacgias")
    Call<List<UserAuthor>> covertUserAuthor();
    /*@GET("")
    Call<List<UserAuthor>> covertUserLecturers(@Query("id") String id);*/
    //==================================

    //===================================
    //lấy ra tên tài khoản để xác nhận đổi mật khẩu
    /*@GET("")
    Call<List<UserAuthor>> covertNameUserStudents(@Query("id") String id);

    @GET("")
    Call<List<UserAuthor>> covertNameUserLecturers(@Query("id") String id);*/
    //========================================================

    //==============================
    // Update data project upload database
    @PUT("api/tacgias/{id}")
    Call<UserAuthor> updateData(@Path("id") int id, @Body UserAuthor userAuthor);
    /*@GET("")
    Call<List<UserAuthor>> covertUserLecturers(@Query("id") String id);*/
    //==================================

    // Update data project upload database
    @PUT("api/tacgias/{id}")
    Call<UserAuthor> deleteData(@Path("id") int id);
    /*@GET("")
    Call<List<UserAuthor>> covertUserLecturers(@Query("id") String id);*/
    //==================================
}
