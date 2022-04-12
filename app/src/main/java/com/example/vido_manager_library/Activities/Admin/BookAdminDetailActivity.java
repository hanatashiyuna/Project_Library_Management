package com.example.vido_manager_library.Activities.Admin;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.Fragment.Admin.AdminBookFragment;
import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.Interface.ApiBookAdmin;
import com.example.vido_manager_library.Interface.ApiCategoryAdmin;
import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.Models.Categorys;
import com.example.vido_manager_library.Models.PC;
import com.example.vido_manager_library.Models.Positions;
import com.example.vido_manager_library.R;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookAdminDetailActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 10;
    List<Books> mListBooks;
    List<Authors> mListAuthor;
    List<Categorys> mListCategory;
    List<PC> mListPublisher;
    List<Positions> mListPosition;

    ArrayList<String> arrayListAuthor, arrayListCategory, arrayListPublisher, arrayListPosition;

    private static String searchBook = "";
    private static String getIdAuthor = "";
    private static String getIdCategory = "";
    private static String getIdPublisher = "";
    private static String getIdPosition = "";

    private EditText ed_authorId;
    private String getNameAuthor;
    ImageView upload;

    private ActivityResultLauncher<Intent> mActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.e("", "onActivityResult");
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        if(data == null){
                            return;
                        }
                        Uri uri = data.getData();

                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                            upload.setImageBitmap(bitmap);
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_admin_detail);

        arrayListAuthor = new ArrayList<>();

        Button btn_upload = findViewById(R.id.btn_upload_image);
        upload = findViewById(R.id.upload_image);

        onClickRequestPermission();

        ImageView imgAdminBook = findViewById(R.id.imgBookAdmin);
        //Tiêu đề của file BookAdminDetailActivity
        TextView title_codeBook = findViewById(R.id.title_codeBook);
        TextView title_nameBook = findViewById(R.id.title_nameBook);
        TextView title_authorId = findViewById(R.id.title_authorId);
        TextView title_categoryId = findViewById(R.id.title_categoryId);
        TextView title_publisherId = findViewById(R.id.title_publisherId);
        TextView title_pbYear = findViewById(R.id.title_publish_year);
        TextView title_amount = findViewById(R.id.title_Amount);
        TextView title_position = findViewById(R.id.title_position);
        //Nhận Dữ Liệu
        EditText ed_codeBook = findViewById(R.id.ed_codeBook);
        EditText ed_nameBook = findViewById(R.id.ed_nameBook);
        ed_authorId = findViewById(R.id.Ed_authorId);
        EditText ed_categoryId = findViewById(R.id.Ed_categoryId);
        EditText ed_publisherId = findViewById(R.id.Ed_publisherId);
        EditText ed_pbYear = findViewById(R.id.Ed_publisher_year);
        EditText ed_amount = findViewById(R.id.Ed_amount);
        EditText ed_position = findViewById(R.id.Ed_position);

        /*ed_authorId.setOnClickListener(view -> {
            ListView lvAuthor = findViewById(R.id.lv_authorName);

            getSelectListAuthorFormApi(lvAuthor);
        });*/

        Bundle bundle = getIntent().getExtras();

        //xu ly btn delete & repair
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_repair = findViewById(R.id.btn_repair);

        if(bundle == null){
            return;
        }
        if(bundle.containsKey("book_information")){
            Books books = (Books) bundle.get("book_information");

            getIdAuthor = String.valueOf(books.getTacgiaID());

            /*ApiAuthorAdmin.apiauthoradmin.covertAuthorAdmin().enqueue(new Callback<List<Authors>>() {
                @Override
                public void onResponse(Call<List<Authors>> call, Response<List<Authors>> response) {
                    mListAuthor = response.body();
                    for (Authors authors : mListAuthor) {
                        if(authors.getTacgiaId() == books.getTacgiaID()){
                            arrayListAuthor.add(authors.getTentacgia());
                            getNameAuthor = authors.getTentacgia();
                            Log.e("id", String.valueOf(authors.getTentacgia()) + "========================================= ");
                            return;
                        }
                        //Log.e("id", String.valueOf(arrayListAuthor.get(0)) + "========================================= " + getNameAuthor);
                    }
                }

                @Override
                public void onFailure(Call<List<Authors>> call, Throwable t) {
                    Toast.makeText(BookAdminDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                }
            });*/


            imgAdminBook.setImageResource(R.drawable.androidprogram);

            title_codeBook.setText("Mã Sách: ");
            ed_codeBook.setHint(books.getMasach());

            title_nameBook.setText("Tên Sách: ");
            ed_nameBook.setHint(books.getTensach());

            title_authorId.setText("Tên/Id Tác Giả: ");
            ed_authorId.setHint(String.valueOf(books.getTacgiaID()));
            //Log.e("id", "========================================= " + getNameAuthor);

            title_categoryId.setText("Tên/Id Thể Loại: ");
            ed_categoryId.setHint(String.valueOf(books.getTheloaiID()));

            title_publisherId.setText("Id Nhà Xuất Bản: ");
            ed_publisherId.setHint(String.valueOf(books.getNhaxbID()));

            title_pbYear.setText("Năm Xuất Bản: ");
            ed_pbYear.setHint(books.getNamxb());

            title_amount.setText("Số Lượng: ");
            ed_amount.setHint(String.valueOf(books.getSoban()));

            title_position.setText("Id Vị Trí: ");
            ed_position.setHint(String.valueOf(books.getVitriID()));

            btn_repair.setOnClickListener(view -> {
                String code_book = ed_codeBook.getText().toString().trim();
                String name_book = ed_nameBook.getText().toString().trim();
                if (!code_book.equals("") && !name_book.equals("")) {
                    ApiBookAdmin.apiBookAdmin.updateDataBookAdmin(books.getSachID(), books).enqueue(new Callback<Books>() {
                        @Override
                        public void onResponse(Call<Books> call, Response<Books> response) {
                            Toast.makeText(BookAdminDetailActivity.this, "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                            switchActivity();
                        }
                        @Override
                        public void onFailure(Call<Books> call, Throwable t) {
                            Toast.makeText(BookAdminDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                        }
                    });

                }else {
                    Toast.makeText(BookAdminDetailActivity.this, "Thiếu Tên Tác Giả Hoặc Ngày Sinh", Toast.LENGTH_SHORT).show();

                }
            });
            btn_delete.setOnClickListener(view -> ApiBookAdmin.apiBookAdmin.deleteDataBookAdmin(books.getSachID()).enqueue(new Callback<Books>() {
                @Override
                public void onResponse(Call<Books> call, Response<Books> response) {
                    Toast.makeText(BookAdminDetailActivity.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    switchActivity();
                }
                @Override
                public void onFailure(Call<Books> call, Throwable t) {
                    Toast.makeText(BookAdminDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                }
            }));

        }else{
            Toast.makeText(BookAdminDetailActivity.this, "Hệ Thống Đang Gặp Vấn Đề Vui Lòng Liên Hệ Với Admin", Toast.LENGTH_SHORT).show();
        }

        ImageView back =  findViewById(R.id.back);
        back.setOnClickListener(view -> switchActivity());


    }

    private void onClickRequestPermission() {
        if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            openGallery();
        }else{
            String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
            requestPermissions(permission, MY_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == MY_REQUEST_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openGallery();
            }
        }
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        mActivityResultLauncher.launch(Intent.createChooser(intent, "Select Picture"));
    }

    public void getSelectListAuthorFormApi(ListView listView){
        ApiAuthorAdmin.apiauthoradmin.covertAuthorAdmin().enqueue(new Callback<List<Authors>>() {
            @Override
            public void onResponse(Call<List<Authors>> call, Response<List<Authors>> response) {
                mListAuthor = response.body();
                for(Authors authors: mListAuthor){
                    arrayListAuthor.add(authors.getTentacgia());
                }
                //khởi tạo array adapter
                ArrayAdapter<String> adapter = new ArrayAdapter<>(BookAdminDetailActivity.this, android.R.layout.simple_list_item_1, arrayListAuthor);
                listView.setAdapter(adapter);

                ed_authorId.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        //filter array list
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listView.setOnItemClickListener((adapterView, view1, i, l) -> {
                    ed_authorId.setText(adapter.getItem(i));
                    getIdAuthor = adapter.getItem(i);
                    listView.setAdapter(null);
                });
            }

            @Override
            public void onFailure(Call<List<Authors>> call, Throwable t) {
                Toast.makeText(BookAdminDetailActivity.this, "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public int GetIDAuthor(){
        int IDAuthor = 0;
        if(mListAuthor != null){
            for(Authors getauthors: mListAuthor){
                if(getauthors.getTentacgia().equals(getIdAuthor)){
                    IDAuthor = getauthors.getTacgiaId();
                    break;
                }
            }
        }
        return IDAuthor;
    }

    public void switchActivity(){
        Intent intent = new Intent(BookAdminDetailActivity.this, HomeAdminActivity.class);
        startActivity(intent);
    }
}