package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.example.vido_manager_library.Adapters.PositionAdapter;
import com.example.vido_manager_library.Interface.ApiAuthorAdmin;
import com.example.vido_manager_library.Interface.ApiPositionAdmin;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.Models.Positions;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * fragment for admin as home, position bookSelf
 * code by yuna
 * */
public class AdminPositionFragment extends Fragment {
    List<Positions> mListPositionsAdmin;
    ImageView btn_add;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_positions, container, false);
        mListPositionsAdmin = new ArrayList<>();
        //set button add position
        btn_add = view.findViewById(R.id.addPosition);
        btn_add.setOnClickListener(view1 -> showDialog());

        RecyclerView listPositionsScreen = view.findViewById(R.id.listview_positions);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL);

        listPositionsScreen.setLayoutManager(new LinearLayoutManager(getActivity()));
        listPositionsScreen.addItemDecoration(itemDecoration);
        getListJS(listPositionsScreen);
        return view;
    }

    private void getListJS(RecyclerView listPositionsScreen) {
        ApiPositionAdmin.apiPositionAdmin.covertPositionAdmin().enqueue(new Callback<List<Positions>>() {
            @Override
            public void onResponse(Call<List<Positions>> call, Response<List<Positions>> response) {
                mListPositionsAdmin = response.body();
                PositionAdapter positionAdapter = new PositionAdapter(AdminPositionFragment.this, mListPositionsAdmin, this::onClickGoToDetail);
                listPositionsScreen.setAdapter(positionAdapter);
            }
            private void onClickGoToDetail(Positions positions) {
                Intent intent = new Intent(getActivity(), BookAdminDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("books_self", positions);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<List<Positions>> call, Throwable t) {
                Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));

        LayoutInflater inflater = getLayoutInflater();
        View viewDf = inflater.inflate(R.layout.dialog_add_position, null);

        final EditText edNameRow = viewDf.findViewById(R.id.df_add_nameRowPosition);
        final EditText edBookSelfPosition = viewDf.findViewById(R.id.df_add_selfBookPosition);

        builder.setView(viewDf);
        builder.setTitle("Thêm Vị Trí Mới").setPositiveButton("Lưu", ((dialogInterface, i) -> {
            String nameRow = edNameRow.getText().toString().trim();
            String bookSelfPosition = edBookSelfPosition.getText().toString().trim();

            if(!nameRow.equals("") && !bookSelfPosition.equals("")){
                Positions positions = new Positions(nameRow, bookSelfPosition);

                ApiPositionAdmin.apiPositionAdmin.insertDataPositionAdmin(positions).enqueue(new Callback<Positions>() {
                    @Override
                    public void onResponse(Call<Positions> call, Response<Positions> response) {
                        Toast.makeText(getActivity(), "Lưu Thành Công", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Positions> call, Throwable t) {
                        Toast.makeText(getActivity(), "Hệ Thông Đang Xử Lí Vui Lòng Trở Lại Sau Vài Giây", Toast.LENGTH_SHORT).show();
                    }
                });
            }else {
                Toast.makeText(getActivity(), "Thiếu Hàng Hoặc Số Kệ", Toast.LENGTH_SHORT).show();
            }
        })).setNegativeButton("Hủy", ((dialogInterface, i) -> dialogInterface.dismiss()));
        builder.show();
    }
}