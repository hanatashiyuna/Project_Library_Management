package com.example.vido_manager_library.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.vido_manager_library.Emtity.AccountModify;

public class DB_HelperAdmin extends SQLiteOpenHelper{
    private static final int DB_VERSION = 3;
    private static final String DB_NAME = "accountadmin";

    public static DB_HelperAdmin instance = null;

    public synchronized static DB_HelperAdmin getInstance(Context context) {
        if (instance == null) {
            instance =new DB_HelperAdmin(context);
        }
        return instance;
    }


    private DB_HelperAdmin(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_addDbStu = AccountModify.QUERY_CREATE_TABLE_STU;
        sqLiteDatabase.execSQL(sql_addDbStu);
//        String sql_addDbAdmin = AccountAdminModify.QUERY_CREATE_TABLE_ADMIN;
//        sqLiteDatabase.execSQL(sql_addDbAdmin);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}