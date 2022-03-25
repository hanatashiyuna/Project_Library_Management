package com.example.vido_manager_library.Admin.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Adapters.BooksAdapters;
import com.example.vido_manager_library.Admin.Model.Authors;
import com.example.vido_manager_library.Models.HomeHorModels;
import com.example.vido_manager_library.R;

import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.ViewHolder>{
    //Context context;
    Activity activity;
    Fragment fragment;
    List<Authors> list;

    //Context to Activity
    public AuthorAdapter(Activity activity, List<Authors> list) {
        this.activity = activity;
        this.list = list;
    }

    public AuthorAdapter(Fragment fragment, List<Authors> list) {
        this.fragment = fragment;
        this.list = list;
    }

    @NonNull
    @Override
    public AuthorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AuthorAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name_item.setText(list.get(position).getTentacgia());
        holder.category_item.setText(list.get(position).getNgaysinh());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name_item;
        TextView category_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_item = itemView.findViewById(R.id.name_item);
            category_item = itemView.findViewById(R.id.category_item);
        }
    }
}
