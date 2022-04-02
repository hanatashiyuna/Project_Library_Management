package com.example.vido_manager_library.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Interface.IClickItemAuthor;
import com.example.vido_manager_library.Models.Authors;
import com.example.vido_manager_library.R;

import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.ViewHolder>{

    Context context;
    Activity activity;
    Fragment fragment;
    List<Authors> list;
    private IClickItemAuthor iClickItemAuthor;

    //Context to Activity
    public AuthorAdapter(Activity activity, List<Authors> list) {
        this.activity = activity;
        this.list = list;
    }

    public AuthorAdapter(Context context, List<Authors> list) {
        this.context = context;
        this.list = list;
    }

    public AuthorAdapter(Fragment fragment, List<Authors> list, IClickItemAuthor iClickItemAuthor) {
        this.fragment = fragment;
        this.list = list;
        this.iClickItemAuthor = iClickItemAuthor;
    }

    @NonNull
    @Override
    public AuthorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Authors author = list.get(position);
        holder.idItem.setText(String.valueOf(list.get(position).getTacgiaId()));
        holder.name_item.setText(list.get(position).getTentacgia());
        holder.category_item.setText(list.get(position).getNgaysinh());
        holder.itemSum.setOnClickListener(view -> iClickItemAuthor.onClickItemAdmin(author));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name_item, category_item, idItem;
        LinearLayout itemSum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_item = itemView.findViewById(R.id.name_item);
            category_item = itemView.findViewById(R.id.category_item);
            itemSum = itemView.findViewById(R.id.itemSum);
            idItem = itemView.findViewById(R.id.id_item);
        }
    }
}
