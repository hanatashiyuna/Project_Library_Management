package com.example.vido_manager_library.Interface;

import com.example.vido_manager_library.Models.UserLectuters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiLecturers {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    //https://zalobot.pmsa.com.vn/api/thuthus
    ApiLecturers apiLecturers= new Retrofit.Builder()
            .baseUrl("https://zalobot.pmsa.com.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiLecturers.class);

    //Set up api and link
    //==============================
    // lấy ra danh sách các tài khoản, mật khẩu để đăng nhập
    @GET("api/thuthus")
    Call<List<UserLectuters>> covertUserLectuters();
    /*@GET("")
    Call<List<UserAuthor>> covertUserLecturers(@Query("id") String id);*/
    //==================================

    //==============================
    // Update data project upload database
    @PUT("api/thuthus/{id}")
    Call<UserLectuters> updateDataLecturers(@Path("id") int id, @Body UserLectuters userLectuters);
    //==================================

    //Delete data and upload database
    @PUT("api/thuthus/{id}")
    Call<UserLectuters> deleteDataLecturers(@Path("id") int id);
    //==================================

    //Insert data and upload database
    @PUT("api/thuthus/{id}")
    Call<UserLectuters> insertDataLecturers(@Path("id") int id, @Body UserLectuters userLectuters);
    //==================================
}