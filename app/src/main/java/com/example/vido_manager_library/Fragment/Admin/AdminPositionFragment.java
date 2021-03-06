package com.example.vido_manager_library.Fragment.Admin;

import static com.example.vido_manager_library.Const.ConstUTF8.KEY_POSITION_DETAIL;
import static com.example.vido_manager_library.Const.ConstUTF8.NOTIFY_SYSTEM_FALSE;

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
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Activities.Admin.PositionDetailActivity;
import com.example.vido_manager_library.Adapters.PositionAdapter;
import com.example.vido_manager_library.Interface.ApiPositionAdmin;
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
    SearchView searchViewPosition;

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

        searchViewPosition = view.findViewById(R.id.search_inputposition);
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
                Intent intent = new Intent(getActivity(), PositionDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(KEY_POSITION_DETAIL, positions);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<List<Positions>> call, Throwable t) {
                Toast.makeText(getActivity(), NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
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
        builder.setTitle("Th??m V??? Tr?? M???i").setPositiveButton("L??u", ((dialogInterface, i) -> {
            String nameRow = edNameRow.getText().toString().trim();
            String bookSelfPosition = edBookSelfPosition.getText().toString().trim();

            if(!nameRow.equals("") && !bookSelfPosition.equals("")){
                Positions positions = new Positions(nameRow, bookSelfPosition);

                ApiPositionAdmin.apiPositionAdmin.insertDataPositionAdmin(positions).enqueue(new Callback<Positions>() {
                    @Override
                    public void onResponse(Call<Positions> call, Response<Positions> response) {
                        Toast.makeText(getActivity(), "L??u Th??nh C??ng", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Positions> call, Throwable t) {
                        Toast.makeText(getActivity(), NOTIFY_SYSTEM_FALSE, Toast.LENGTH_SHORT).show();
                    }
                });
            }else {
                Toast.makeText(getActivity(), "Thi???u H??ng Ho???c S??? K???", Toast.LENGTH_SHORT).show();
            }
        })).setNegativeButton("H???y", ((dialogInterface, i) -> dialogInterface.dismiss()));
        builder.show();
    }
}