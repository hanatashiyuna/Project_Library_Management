package com.example.vido_manager_library.QRCode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vido_manager_library.Activities.User.MainActivity;
import com.example.vido_manager_library.Emtity.AccountModify;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;
import java.util.List;

public class CreateQRCodeActivity extends AppCompatActivity {

    private UserStu infor_qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qrcode);
        List<UserStu> mlistAccount = new ArrayList<UserStu>();

        ImageView back = findViewById(R.id.back);
        ImageView imageQRCode = findViewById(R.id.imageQRCode);
        TextView nameStudent = findViewById(R.id.name_student);
        TextView codeStudent = findViewById(R.id.code_student);
        TextView classStudent = findViewById(R.id.class_student);

        //api setter
        Cursor cursor = AccountModify.findTheFirst();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String masosinhvien = cursor.getString(6);
            String tensinhvien = cursor.getString(1);
            String matkhau = cursor.getString(2);
            String diachi = cursor.getString(3);
            String lop = cursor.getString(4);
            String email = cursor.getString(5);
            String soCmnd = cursor.getString(7);
            String ngaysinh = cursor.getString(8);
            String khoa = cursor.getString(9);
            mlistAccount.add(new UserStu(id, masosinhvien, tensinhvien, diachi, lop, email, matkhau, soCmnd, ngaysinh, khoa));
            cursor.moveToNext();
        }
        cursor.close();

        for (UserStu userStu: mlistAccount) {
            infor_qr = userStu;
        }

        String information = String.valueOf(infor_qr.getMasosinhvien());

        back.setOnClickListener(view -> {
            Intent intent = new Intent(CreateQRCodeActivity.this, MainActivity.class);
            startActivity(intent);
        });

        //information student
        nameStudent.setText(infor_qr.getTensinhvien());
        codeStudent.setText(information);
        classStudent.setText(infor_qr.getLop());

        //create QR Code
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(information, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imageQRCode.setImageBitmap(bitmap);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}