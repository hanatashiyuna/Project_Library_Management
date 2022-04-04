package com.example.vido_manager_library.Interface;

import com.example.vido_manager_library.Models.Categorys;
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

public interface ApiCategoryAdmin {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    //https://zalobot.pmsa.com.vn/api/theloais
    ApiCategoryAdmin apiLecturers= new Retrofit.Builder()
            .baseUrl("https://zalobot.pmsa.com.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiCategoryAdmin.class);

    //Set up api and link
    //==============================
    // lấy ra danh sách các tài khoản, mật khẩu để đăng nhập
    @GET("api/theloais")
    Call<List<Categorys>> covertUserLectuters();
    /*@GET("")
    Call<List<UserAuthor>> covertUserLecturers(@Query("id") String id);*/
    //==================================

    //==============================
    // Update data project upload database
    @PUT("api/theloais/{id}")
    Call<Categorys> updateDataLecturers(@Path("id") int id, @Body Categorys categorys);
    //==================================

    //Delete data and upload database
    @PUT("api/theloais/{id}")
    Call<Categorys> deleteDataLecturers(@Path("id") int id);
    //==================================

    //Insert data and upload database
    @PUT("api/theloais/{id}")
    Call<Categorys> insertDataLecturers(@Path("id") int id, @Body Categorys categorys);
    //==================================
}
