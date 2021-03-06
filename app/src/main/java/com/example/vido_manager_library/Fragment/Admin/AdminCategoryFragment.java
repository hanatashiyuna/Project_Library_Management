package com.example.vido_manager_library.Fragment.Admin;

import static com.example.vido_manager_library.Const.ConstUTF8.KEY_CATEGORY_DETAIL;
import static com.example.vido_manager_library.Const.ConstUTF8.NOTIFY_SYSTEM_FALSE;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.CategoryDetailActivity;
import com.example.vido_manager_library.Adapters.CategoryAdapter;
import com.example.vido_manager_library.Interface.ApiCategoryAdmin;
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
                Intent intent = new Intent(getActivity(), CategoryDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(KEY_CATEGORY_DETAIL, categorys);
                intent.putExtras(bundle);
                startActivity(intent);

            }
            @Override
            public void onFailure(Call<List<Categorys>> call, Throwable t) {
                Toast.makeText(getActivity(), NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));

        LayoutInflater inflater = getLayoutInflater();
        View viewDf = inflater.inflate(R.layout.dialog_add_category, null);

        final EditText edCategory = viewDf.findViewById(R.id.df_add_category);

        builder.setView(viewDf);
        builder.setTitle("Th??m Th??? Lo???i").setPositiveButton("L??u", (dialogInterface, i) -> {
            String mCategory = edCategory.getText().toString().trim();

            if (!mCategory.equals("")) {
                Categorys categorys = new Categorys(mCategory);

                ApiCategoryAdmin.apicategoryadmin.insertDataCategoryAdmin(categorys).enqueue(new Callback<Categorys>() {
                    @Override
                    public void onResponse(Call<Categorys> call, Response<Categorys> response) {
                        Toast.makeText(getActivity(), "L??u Th??nh C??ng", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<Categorys> call, Throwable t) {
                        Toast.makeText(getActivity(), NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
                    }
                });

            }else {
                Toast.makeText(getActivity(), "Thi???u T??n T??c Gi??? Ho???c Ng??y Sinh", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("H???y", (dialogInterface, i) -> dialogInterface.dismiss());
        builder.show();
    }
}
