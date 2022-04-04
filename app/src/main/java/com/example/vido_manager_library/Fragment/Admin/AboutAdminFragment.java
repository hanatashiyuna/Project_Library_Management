package com.example.vido_manager_library.Fragment.Admin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vido_manager_library.BuildConfig;
import com.example.vido_manager_library.Emtity.AccountAdminModify;
import com.example.vido_manager_library.Emtity.AccountModify;
import com.example.vido_manager_library.LogSign.StudentLoginActivity;
import com.example.vido_manager_library.Models.UserLectuters;
import com.example.vido_manager_library.Models.UserStu;
import com.example.vido_manager_library.R;

import java.util.ArrayList;
import java.util.List;

public class AboutAdminFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_about_admin, container, false);
        TextView version = view.findViewById(R.id.version);
        version.setText(String.format("Beta version %s", BuildConfig.VERSION_NAME));
        List<UserLectuters> mlistAccount = new ArrayList<UserLectuters>();
        UserLectuters infor_sidnup;
        infor_sidnup = getDatabase(mlistAccount);
        /*Log.e("Looix", infor_sidnup.getHoten());*/
        TextView logOut = view.findViewById(R.id.logOut);
        logOut.setOnClickListener(view -> switchActivity(infor_sidnup));
        return view;
    }

    public void switchActivity(UserLectuters infor_sidnup){

        AccountAdminModify.delete(infor_sidnup.getThuthuId());
        Intent intent = new Intent(getActivity(), StudentLoginActivity.class);
        startActivity(intent);

    }

    public UserLectuters getDatabase(List<UserLectuters> mlistAccount) {
        UserLectuters infor_sidnup = null;
        Cursor cursor = AccountAdminModify.findTheFirstAdmin();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int thuthuId = cursor.getInt(0);

            String hoten = cursor.getString(1);
            String ngaysinh = cursor.getString(2);
            String diachi = cursor.getString(3);
            String sdt = cursor.getString(4);
            String email = cursor.getString(5);
            String username = cursor.getString(6);

            mlistAccount.add(new UserLectuters(thuthuId, hoten, ngaysinh, sdt, diachi, email, username));
            cursor.moveToNext();
        }
        cursor.close();

        for (UserLectuters userLectuters: mlistAccount) {
            infor_sidnup = userLectuters;
        }

        return infor_sidnup;
    }

}