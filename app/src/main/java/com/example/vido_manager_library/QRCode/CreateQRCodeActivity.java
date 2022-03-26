package com.example.vido_manager_library.QRCode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.ImageView;

import com.example.vido_manager_library.Activities.User.MainActivity;
import com.example.vido_manager_library.Models.UserAuthor;
import com.example.vido_manager_library.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

public class CreateQRCodeActivity extends AppCompatActivity {

    private ImageView back, imageQRCode;
    private UserAuthor userAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qrcode);

        back = findViewById(R.id.back);
        imageQRCode = findViewById(R.id.imageQRCode);
        String information = "2006010004";

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateQRCodeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //create QR Code
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(information, BarcodeFormat.QR_CODE, 300, 300);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imageQRCode.setImageBitmap(bitmap);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}