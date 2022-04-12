package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Adapters.SearchBooksAdapter;
import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.Interface.ApiBookAdmin;
import com.example.vido_manager_library.Interface.ApiCategoryAdmin;
import com.example.vido_manager_library.Interface.ApiPositionAdmin;
import com.example.vido_manager_library.Interface.ApiPublishingHouseAdmin;
import com.example.vido_manager_library.Interface.ApiService;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.Models.Categorys;
import com.example.vido_manager_library.Models.PC;
import com.example.vido_manager_library.Models.Positions;
import com.example.vido_manager_library.Models.SearchBooks;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * fragment for admin as home page, book list
 * code by Yuna
 */

public class AdminBookFragment extends Fragment {
    /**khởi tạo arraylist*/
    List<SearchBooks> mListBooksAdmin;
    List<Authors> mListAuthor;
    List<Categorys> mListCategory;
    List<PC> mListPublisher;
    List<Positions> mListPosition;
    ImageView btnAddBook;
    EditText listAuthor, listCategory, listPublisher, listPosition;
    SearchView searchView;
    /** để tạm string*/
    ArrayList<String> arrayListAuthor, arrayListCategory, arrayListPublisher, arrayListPosition;
    private static String searchBook = "";
    private static String getIdAuthor = "";
    private static String getIdCategory = "";
    private static String getIdPublisher = "";
    private static String getIdPosition = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_books, container, false);
        // gọi array list
        mListBooksAdmin = new ArrayList<>();
        mListAuthor = new ArrayList<>();
        mListCategory = new ArrayList<>();
        mListPublisher = new ArrayList<>();
        mListPosition = new ArrayList<>();
        //set button add book
        btnAddBook = view.findViewById(R.id.addBook);
        searchView = view.findViewById(R.id.search_inputbook);

        btnAddBook.setOnClickListener(view1 -> showDialog());

        RecyclerView listBookScreen = view.findViewById(R.id.listview_book);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        listBookScreen.setLayoutManager(gridLayoutManager);
        //** Gọi method và truyền PARAMETER RecyclerView*/
        getListJS(listBookScreen);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override public boolean onQueryTextChange(String newText) {
                searchBook = newText;
                getListJS(listBookScreen, searchBook);
                return true;
            }
        });
        return view;
    }

    /**Lấy dữ liệu từ api*/
    private void getListJS(RecyclerView listBookScreen, String search) {
        //Gọi interface api trùng với api cần
        ApiBookAdmin.apiBookAdmin.covertBookAdmin(search).enqueue(new Callback<List<SearchBooks>>() {
            @Override
            public void onResponse(Call<List<SearchBooks>> call, Response<List<SearchBooks>> response) {
                mListBooksAdmin = response.body();
                SearchBooksAdapter searchBooksAdapter = new SearchBooksAdapter(getActivity(), mListBooksAdmin, this::onClickGoToDetail);
                listBookScreen.setAdapter(searchBooksAdapter);
            }
            private void onClickGoToDetail(SearchBooks searchBooks) {
                Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("book_information", searchBooks);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<List<SearchBooks>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getListJS(RecyclerView listBookScreen) {
        //Gọi interface api trùng với api cần
        ApiBookAdmin.apiBookAdmin.covertBookAdmin("").enqueue(new Callback<List<SearchBooks>>() {
            @Override
            public void onResponse(Call<List<SearchBooks>> call, Response<List<SearchBooks>> response) {
                mListBooksAdmin = response.body();
                SearchBooksAdapter searchBooksAdapter = new SearchBooksAdapter(getActivity(), mListBooksAdmin, this::onClickGoToDetail);
                listBookScreen.setAdapter(searchBooksAdapter);
            }
            private void onClickGoToDetail(SearchBooks books) {
                Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("book_information", books);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<List<SearchBooks>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });

    }
    //dialog add book
    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));

        LayoutInflater inflater = getLayoutInflater();
        View viewDf = inflater.inflate(R.layout.dialog_add_book, null);

        final EditText edCodeBook = viewDf.findViewById(R.id.df_add_code_book);
        final EditText edNameBook = viewDf.findViewById(R.id.df_add_book_name);
        listAuthor = viewDf.findViewById(R.id.df_list_book_idAuthor);
        listCategory = viewDf.findViewById(R.id.df_add_book_idCategory);
        final EditText edYear = viewDf.findViewById(R.id.df_add_book_year);
        listPublisher = viewDf.findViewById(R.id.df_add_book_idPC);
        final EditText edAmount = viewDf.findViewById(R.id.df_add_book_amount);
        listPosition = viewDf.findViewById(R.id.df_add_book_position);

        //set selection author
        listAuthor.setOnClickListener(view -> {

            ListView selectAuthor = viewDf.findViewById(R.id.lv_author);
            arrayListAuthor = new ArrayList<>();
            getSelectListAuthorFormApi(selectAuthor);
        });

        listCategory.setOnClickListener(view -> {

            ListView selectCategory = viewDf.findViewById(R.id.lv_category);
            arrayListCategory = new ArrayList<>();
            getSelectListCategoryFormApi(selectCategory);
        });

        listPublisher.setOnClickListener(view -> {

            ListView selectPublisher = viewDf.findViewById(R.id.lv_publisher);
            arrayListPublisher = new ArrayList<>();
            getSelectListPublisherFormApi(selectPublisher);
        });

        listPosition.setOnClickListener(view -> {
            ListView selectPosition = viewDf.findViewById(R.id.lv_position);
            arrayListPosition = new ArrayList<>();
            getSelectListPositionFormApi(selectPosition);
        });

        builder.setView(viewDf);

        builder.setTitle("Thêm Sách Mới").setPositiveButton("Save", (dialogInterface, i) -> {
            String codeBook = edCodeBook.getText().toString();
            String nameBook = edNameBook.getText().toString();
            int idAuthor = ((int) GetIDAuthor());
            String year = edYear.getText().toString();
            int idCategory = ((int) GetIDCategory());
            int idPublisher = ((int) GetIDPublisher());
            int amount;
            if(!edAmount.getText().toString().equals("")){
                amount = Integer.parseInt(edAmount.getText().toString());
            }else{
                amount = 0;
            }
            int idPosition = ((int) GetIDPosition());

            if (!nameBook.equals("") || !year.equals("") || idPublisher != 0 || idAuthor != 0 || idCategory != 0 || idPosition != 0) {
                Books books = new Books(codeBook,nameBook, idAuthor, idCategory, idPublisher, year, amount, idPosition);

                ApiBookAdmin.apiBookAdmin.insertDataBookAdmin(books).enqueue(new Callback<Books>() {
                    @Override
                    public void onResponse(Call<Books> call, Response<Books> response) {
                        Toast.makeText(getActivity(), "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<Books> call, Throwable t) {
                        Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                    }
                });
            }else {
                Toast.makeText(getActivity(), "Thiếu Tên Tác Giả Hoặc Ngày Sinh", Toast.LENGTH_SHORT).show();
            }

        }).setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss());
        builder.show();
    }
    //lay du lieu author tu api vao select
    public void getSelectListAuthorFormApi(ListView listView){
        ApiAuthorAdmin.apiauthoradmin.covertAuthorAdmin().enqueue(new Callback<List<Authors>>() {
            @Override
            public void onResponse(Call<List<Authors>> call, Response<List<Authors>> response) {
                mListAuthor = response.body();
                for(Authors authors: mListAuthor){
                    arrayListAuthor.add(authors.getTentacgia());
                }
                //khởi tạo array adapter
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayListAuthor);
                listView.setAdapter(adapter);

                listAuthor.addTextChangedListener(new TextWatcher() {
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
                    listAuthor.setText(adapter.getItem(i));
                    getIdAuthor = adapter.getItem(i);
                    listView.setAdapter(null);
                });
            }

            @Override
            public void onFailure(Call<List<Authors>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //lay du lieu category tu api vao select
    public void getSelectListCategoryFormApi(ListView listView2){
        ApiCategoryAdmin.apicategoryadmin.covertCategoryAdmin().enqueue(new Callback<List<Categorys>>() {
            @Override
            public void onResponse(Call<List<Categorys>> call, Response<List<Categorys>> response) {
                mListCategory = response.body();
                for(Categorys categorys: mListCategory){
                    arrayListCategory.add(categorys.getTentheloai());
                }
                //khởi tạo array adapter
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayListCategory);
                listView2.setAdapter(adapter2);

                listCategory.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int j, int j1, int j2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int j, int j1, int j2) {
                        //filter array list
                        adapter2.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listView2.setOnItemClickListener((adapterView, view2, j, l) -> {
                    listCategory.setText(adapter2.getItem(j));
                    getIdCategory = adapter2.getItem(j);
                    listView2.setAdapter(null);
                });
            }

            @Override
            public void onFailure(Call<List<Categorys>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //lay du lieu publisher tu api vao select
    public void getSelectListPublisherFormApi(ListView listView){
        ApiPublishingHouseAdmin.apiPublishingHouseAdmin.covertPublishingHouseAdmin().enqueue(new Callback<List<PC>>() {
            @Override
            public void onResponse(Call<List<PC>> call, Response<List<PC>> response) {
                mListPublisher = response.body();
                for(PC publisher: mListPublisher){
                    arrayListPublisher.add(publisher.getTenxuatban());
                }
                //khởi tạo array adapter
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayListPublisher);
                listView.setAdapter(adapter);

                listPublisher.addTextChangedListener(new TextWatcher() {
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
                    listPublisher.setText(adapter.getItem(i));
                    getIdPublisher = adapter.getItem(i);
                    listView.setAdapter(null);
                });
            }

            @Override
            public void onFailure(Call<List<PC>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //lay du lieu position tu api vao select
    public void getSelectListPositionFormApi(ListView listView){
        ApiPositionAdmin.apiPositionAdmin.covertPositionAdmin().enqueue(new Callback<List<Positions>>() {
            @Override
            public void onResponse(Call<List<Positions>> call, Response<List<Positions>> response) {
                mListPosition = response.body();
                for(Positions positions: mListPosition){
                    arrayListPosition.add(positions.getTenhang());
                }
                //khởi tạo array adapter
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayListPosition);
                listView.setAdapter(adapter);

                listPosition.addTextChangedListener(new TextWatcher() {
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
                    listPosition.setText(adapter.getItem(i));
                    getIdPosition = adapter.getItem(i);
                    listView.setAdapter(null);
                });
            }

            @Override
            public void onFailure(Call<List<Positions>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
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

    public int GetIDCategory(){
        int IDCategory = 0;
        if(mListCategory != null){
            for(Categorys getcategory: mListCategory){
                if(getcategory.getTentheloai().equals(getIdCategory)){
                    IDCategory = getcategory.getTheloaiID();
                    break;
                }
            }
        }
        return IDCategory;
    }

    public int GetIDPublisher(){
        int IDPublisher = 0;
        if(mListPublisher != null){
            for(PC getpc: mListPublisher){
                if(getpc.getTenxuatban().equals(getIdPublisher)){
                    IDPublisher = getpc.getNhaxbID();
                    break;
                }
            }
        }
        return IDPublisher;
    }

    public int GetIDPosition(){
        int IDPosition = 0;
        if(mListAuthor != null){
            for(Positions getposition: mListPosition){
                if(getposition.getTenhang().equals(getIdPosition)){
                    IDPosition = getposition.getVitriId();
                    break;
                }
            }
        }
        return IDPosition;
    }
}