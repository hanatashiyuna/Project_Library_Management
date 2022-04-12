package com.example.vido_manager_library.Interface;

import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.Models.Borrow;
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

public interface ApiBorrowAdmin {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    //https://zalobot.pmsa.com.vn/api/booklists?search=
    ApiBorrowAdmin apiBorrowAdmin= new Retrofit.Builder()
            .baseUrl("https://zalobot.pmsa.com.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiBorrowAdmin.class);

    //Set up api and link
    //==============================
    // lấy ra danh sách các tài khoản, mật khẩu để đăng nhập
    @GET("api/muons")
    Call<List<Borrow>> covertBorrowkAdmin();

    @GET("api/muons/{id}")
    Call<Borrow> covertBorrowSingleAdmin(@Path("id") int id);

    //==================================

    //==============================
    // Update data project upload database
    @PUT("api/muons/{id}")
    Call<Borrow> updateDataBookAdmin(@Path("id") int id, @Body Borrow borrow);
    //==================================

    //Delete data and upload database
    @DELETE("api/muons/{id}")
    Call<Borrow> deleteDataBorrowAdmin(@Path("id") int id);
    //==================================

    //Insert data and upload database
    @POST("api/muons")
    Call<Borrow> insertDataBorrowAdmin(@Body Borrow borrow);
    //==================================
}
