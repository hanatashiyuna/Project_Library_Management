package com.example.vido_manager_library.Emtity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.vido_manager_library.DataBase.DB_Helper;
import com.example.vido_manager_library.Models.UserStu;

public class AccountModify {
    public static final String QUERY_CREATE_TABLE_STU = "create table accountstulist(\n"+
            "\tsinhvienId int,\n"+
            "\ttensinhvien varchar(150),\n"+
            "\tmatkhau varchar(150),\n"+
            "\tdiachi text,\n"+
            "\tlop varchar(50),\n"+
            "\temail varchar(200),\n"+
            "\tmasosinhvien varchar(200),\n"+
            "\tsocmnd varchar(150),\n"+
            "\tngaysinh varchar(150),\n"+
            "\tkhoa text\n"+
            ")";

    public static Cursor findTheFirst() {
        String sql = "select * from accountstulist limit 1";
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }

    public static boolean serchDB() {
        boolean reValue = false;
        int count = 0;
        String name = "";
        String sql = "select * from accountstulist limit 1";
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            name = cursor.getString(1);

            if (name != "") {
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

    public static void insert(UserStu userStu) {
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("sinhvienId",userStu.getSinhvienId());
        values.put("tensinhvien", userStu.getTensinhvien());
        values.put("matkhau",userStu.getMatkhau());
        values.put("diachi",userStu.getDiachi());
        values.put("lop", userStu.getLop());
        values.put("email",userStu.getEmail());
        values.put("masosinhvien",userStu.getMasosinhvien());
        values.put("socmnd", userStu.getSoCmnd());
        values.put("ngaysinh",userStu.getNgaysinh());
        values.put("khoa",userStu.getKhoa());

        sqLiteDatabase.insert("accountstulist",null,values);
    }

    public static void delete(int id) {
        SQLiteDatabase sqLiteDatabase = DB_Helper.getInstance(null).getWritableDatabase();
        sqLiteDatabase.delete("accountstulist"," sinhvienId="+id,null);
    }
}
