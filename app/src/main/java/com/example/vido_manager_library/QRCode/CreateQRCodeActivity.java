package com.example.vido_manager_library.QRCode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.vido_manager_library.Activities.User.MainActivity;
import com.example.vido_manager_library.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class CreateQRCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qrcode);

        ImageView back = findViewById(R.id.back);
        ImageView imageQRCode = findViewById(R.id.imageQRCode);
        String information = "2006010004";

        back.setOnClickListener(view -> {
            Intent intent = new Intent(CreateQRCodeActivity.this, MainActivity.class);
            startActivity(intent);
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