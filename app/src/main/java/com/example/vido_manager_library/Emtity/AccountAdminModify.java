package com.example.vido_manager_library.Emtity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.vido_manager_library.DataBase.DB_Helper;
import com.example.vido_manager_library.Models.UserLectuters;

public class AccountAdminModify {
    public static final String QUERY_CREATE_TABLE_ADMIN = "create table accountleclist(\n"+
            "\tthuthuId int,\n"+
            "\thoten varchar(150),\n"+
            "\tngaysinh varchar(150),\n"+
            "\tdiachi text,\n"+
            "\tsdt varchar(50),\n"+
            "\temail varchar(200),\n"+
            "\tusername varchar(150)\n"+

            ")";

    public static Cursor findTheFirstAdmin() {
        String sql = "select * from accountleclist limit 1";
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }

    public static boolean serchDBAdmin() {
        boolean reValue = false;
        int count = 0;
        String sql = "select * from accountleclist limit 1";
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
        return reValue;
    }


    /*    thuthuId: 1,
    hoten: "Nguyễn Thị Đào",
    ngaysinh: "1972-02-15T00:00:00",
    sdt: "0912348569",
    diachi: "Công viên phần mềm, Lô 2 Đường Số 16, Quang Trung, Quận 12",
    email: "nguyedao@gmail.com",
    username: "AdminDao",
    matkhau: "123",
    muons: [ ],
    tras: [ ],*/

    public static void insert(UserLectuters userLectuters) {
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("thuthuId",userLectuters.getThuthuId());
        values.put("hoten", userLectuters.getHoten());
        values.put("diachi",userLectuters.getDiachi());
        values.put("sdt", userLectuters.getSdt());
        values.put("email",userLectuters.getEmail());
        values.put("username",userLectuters.getUsername());
        values.put("ngaysinh",userLectuters.getNgaysinh());

        sqLiteDatabase.insert("accountleclist",null,values);
    }

    public static void delete(int id) {
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getWritableDatabase();
        sqLiteDatabase.delete("accountleclist"," masosinhvien="+id,null);
    }
}
