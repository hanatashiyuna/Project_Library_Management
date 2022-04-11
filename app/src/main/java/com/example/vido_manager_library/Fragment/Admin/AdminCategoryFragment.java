package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.BookAdminDetailActivity;
import com.example.vido_manager_library.Adapters.AuthorAdapter;
import com.example.vido_manager_library.Adapters.CategoryAdapter;
import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.Interface.ApiCategoryAdmin;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.Categorys;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminCategoryFragment extends Fragment {
    List<Categorys> mListCategoryAdmin;
    ImageView btn_add;
    SearchView searchViewCategory;
    //private static String searchCategory = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_categories, container, false);
        mListCategoryAdmin = new ArrayList<>();
        //set button add category
        btn_add = view.findViewById(R.id.addCategory);
        btn_add.setOnClickListener(view1 -> showDialog());

        RecyclerView listCategoryScreen = view.findViewById(R.id.listview_category);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);

        listCategoryScreen.setLayoutManager(new LinearLayoutManager(getActivity()));
        listCategoryScreen.addItemDecoration(itemDecoration);
        getListJS(listCategoryScreen);

        searchViewCategory = view.findViewById(R.id.search_inputcategory);
        /*searchViewCategory.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //searchCategory = new Text;
                return true;
            }
        });*/

        return view;
    }

    private void getListJS(RecyclerView listCategoryScreen) {
        ApiCategoryAdmin.apicategoryadmin.covertCategoryAdmin().enqueue(new Callback<List<Categorys>>() {
            @Override
            public void onResponse(Call<List<Categorys>> call, Response<List<Categorys>> response) {
                mListCategoryAdmin = response.body();
                CategoryAdapter categoryAdapter = new CategoryAdapter(AdminCategoryFragment.this, mListCategoryAdmin, this::onClickGoToDetail);
                listCategoryScreen.setAdapter(categoryAdapter);
            }
            private void onClickGoToDetail(Categorys categorys) {
                Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("books_category", categorys);
                intent.putExtras(bundle);
                startActivity(intent);

            }
            @Override
            public void onFailure(Call<List<Categorys>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));

        LayoutInflater inflater = getLayoutInflater();
        View viewDf = inflater.inflate(R.layout.dialog_add_category, null);

        final EditText edCategory = viewDf.findViewById(R.id.df_add_category);

        builder.setView(viewDf);
        builder.setTitle("Thêm Thể Loại").setPositiveButton("Lưu", (dialogInterface, i) -> {
            String mCategory = edCategory.getText().toString().trim();

            if (!mCategory.equals("")) {
                Categorys categorys = new Categorys(mCategory);

                ApiCategoryAdmin.apicategoryadmin.insertDataCategoryAdmin(categorys).enqueue(new Callback<Categorys>() {
                    @Override
                    public void onResponse(Call<Categorys> call, Response<Categorys> response) {
                        Toast.makeText(getActivity(), "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<Categorys> call, Throwable t) {
                        Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                    }
                });

            }else {
                Toast.makeText(getActivity(), "Thiếu Tên Tác Giả Hoặc Ngày Sinh", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Hủy", (dialogInterface, i) -> dialogInterface.dismiss());
        builder.show();
    }
}
