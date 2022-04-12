package com.example.vido_manager_library.Interface;

import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.Models.SearchBooks;
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
import retrofit2.http.Query;

public interface ApiBookAdmin {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    //https://zalobot.pmsa.com.vn/api/booklists?search=
    ApiBookAdmin apiBookAdmin= new Retrofit.Builder()
            .baseUrl("https://zalobot.pmsa.com.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiBookAdmin.class);

    //Set up api and link
    //==============================
    // lấy ra danh sách các tài khoản, mật khẩu để đăng nhập
    @GET("api/booklists?")
    Call<List<SearchBooks>> covertBookAdmin(@Query("search") String search);
    @GET("api/booklists?")
    Call<SearchBooks> covertBookSAdmin(@Query("search") String search);
    @GET("api/saches")
    Call<List<Books>> convertBookOriginalAdmin();
    @GET("api/saches/{id}")
    Call<Books> convertSingleBookOriginalAdmin(@Path("id") int id);
    //==================================

    //==============================
    // Update data project upload database
    @PUT("api/saches/{id}")
    Call<Books> updateDataBookAdmin(@Path("id") int id, @Body Books books);
    //==================================

    //Delete data and upload database
    @DELETE("api/saches/{id}")
    Call<Books> deleteDataBookAdmin(@Path("id") int id);
    //==================================

    //Insert data and upload database
    @POST("api/saches")
    Call<Books> insertDataBookAdmin(@Body Books books);
    //==================================
}
