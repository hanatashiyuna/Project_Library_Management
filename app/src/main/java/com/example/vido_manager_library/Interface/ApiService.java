package com.example.vido_manager_library.Interface;

import com.example.vido_manager_library.Models.UserStu;
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

public interface ApiService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    //https://zalobot.pmsa.com.vn/api/sinhviens
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://zalobot.pmsa.com.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    //Set up api and link
    //==============================
    // lấy ra danh sách các tài khoản, mật khẩu để đăng nhập
    @GET("api/SinhViens")
    Call<List<UserStu>> covertUserStu();
    /*@GET("")
    Call<List<UserAuthor>> covertUserLecturers(@Query("id") String id);*/
    //==================================

    //==============================
    // Update data project upload database
    @PUT("api/SinhViens/{id}")
    Call<UserStu> updateDataStu(@Path("id") int id, @Body UserStu userStu);
    //==================================

    //Delete data and upload database
    @PUT("api/SinhViens/{id}")
    Call<UserStu> deleteDataStu(@Path("id") int id);
    //==================================

    //Insert data and upload database
    @PUT("api/SinhViens/{id}")
    Call<UserStu> insertDataStu(@Path("id") int id, @Body UserStu userStu);
    //==================================
}
