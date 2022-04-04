package com.example.vido_manager_library.Interface;

import com.example.vido_manager_library.Models.Books;
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

public interface ApiBookAdmin {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    //https://zalobot.pmsa.com.vn/api/saches
    ApiBookAdmin apiLecturers= new Retrofit.Builder()
            .baseUrl("https://zalobot.pmsa.com.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiBookAdmin.class);

    //Set up api and link
    //==============================
    // lấy ra danh sách các tài khoản, mật khẩu để đăng nhập
    @GET("api/saches")
    Call<List<Books>> covertUserLectuters();
    /*@GET("")
    Call<List<UserAuthor>> covertUserLecturers(@Query("id") String id);*/
    //==================================

    //==============================
    // Update data project upload database
    @PUT("api/saches/{id}")
    Call<Books> updateDataLecturers(@Path("id") int id, @Body Books books);
    //==================================

    //Delete data and upload database
    @PUT("api/saches/{id}")
    Call<Books> deleteDataLecturers(@Path("id") int id);
    //==================================

    //Insert data and upload database
    @PUT("api/saches/{id}")
    Call<Books> insertDataLecturers(@Path("id") int id, @Body Books books);
    //==================================
}
