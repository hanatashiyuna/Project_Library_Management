package com.example.vido_manager_library.Emtity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.vido_manager_library.DataBase.DB_Helper;
import com.example.vido_manager_library.Models.UserAuthor;

public class AccountAdminModify {
    public static final String QUERY_CREATE_TABLE_ADMIN = "create table accountleclist(\n"+
            "\t_id integer,\n"+
            "\tnameaccount varchar(150),\n"+
            "\tpassword varchar(150)\n"+
            ")";

    /*public static final String QUERY_ADD_EMAIL_COLUMN_TABLE = "alter table numberlist\n"
            +"\tadd column email varchar(100)";

    public static final String QUERY_ADD_DATE_COLUMN_TABLE = "alter table numberlist\n"
            +"\tadd column date text";*/

    public static Cursor findAll() {
        String sql = "select * from accountleclist";
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }

    public static void insert(UserAuthor userAuthor) {
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id",userAuthor.getTacgiaId());
        values.put("nameaccount", userAuthor.getTentacgia());
        values.put("password",userAuthor.getTentacgia());

        sqLiteDatabase.insert("accountleclist",null,values);
    }

    public static void delete(int id) {
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getWritableDatabase();
        sqLiteDatabase.delete("list"," _id="+id,null);
    }
}
