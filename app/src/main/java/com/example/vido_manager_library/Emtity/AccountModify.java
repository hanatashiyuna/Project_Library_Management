package com.example.vido_manager_library.Emtity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.vido_manager_library.DataBase.DB_Helper;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.Models.UserStu;

public class AccountModify {
    public static final String QUERY_CREATE_TABLE_STU = "create table accountstulist(\n"+
            "\t_id integer,\n"+
            "\tnameaccount varchar(150),\n"+
            "\tpassword varchar(150)\n"+
            ")";

//    public static final String QUERY_ADD_EMAIL_COLUMN_TABLE = "alter table numberlist\n"
//            +"\tadd column email varchar(100)";
//
//    public static final String QUERY_ADD_DATE_COLUMN_TABLE = "alter table numberlist\n"
//            +"\tadd column date text";

    public static Cursor findTheFirst() {
        String sql = "select * from accountstulist limit 1";
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }

    public static boolean serchDB() {
        boolean reValue = false;
        int count = 0;
        String sql = "select * from accountstulist limit 1";
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(1);

            if (!name.equals("")) {
                count += 1;
            }
            cursor.moveToNext();
        }
        if (count >= 1){
            reValue = true;
        }else {
            reValue = false;
        }
        count = 0;
        return reValue;
    }

    public static void insert(UserAuthor userAuthor) {
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id",userAuthor.getTacgiaId());
        values.put("nameaccount", userAuthor.getTentacgia());
        values.put("password",userAuthor.getTentacgia());
        sqLiteDatabase.insert("accountstulist",null,values);
    }

    public static void delete(int id) {
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getWritableDatabase();
        sqLiteDatabase.delete("accountstulist"," _id="+id,null);
    }
}
