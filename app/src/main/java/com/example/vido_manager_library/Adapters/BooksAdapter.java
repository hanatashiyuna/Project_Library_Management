package com.example.vido_manager_library.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vido_manager_library.Interface.IClickItemBooks;
import com.example.vido_manager_library.Models.Books;
import com.example.vido_manager_library.R;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder>{
    //Context context;
    Activity activity;
    Fragment fragment;
    List<Books> list;
    private IClickItemBooks iClickItemBooks;

    //Context to Activity
    public BooksAdapter(Activity activity, List<Books> list) {
        this.activity = activity;
        this.list = list;
    }

    public BooksAdapter(Fragment fragment, List<Books> list) {
        this.fragment = fragment;
        this.list = list;
    }

    @NonNull
    @Override
    public BooksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BooksAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Books books = list.get(position);
        holder.name_item.setText(list.get(position).getTensach());
        holder.category_item.setText(list.get(position).getTheloaiID());
        //holder.items.setOnClickListener(view -> iClickItemBooks.onClickItemBooks(books));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name_item;
        TextView category_item;
        //LinearLayout items;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_item = itemView.findViewById(R.id.name_item);
            category_item = itemView.findViewById(R.id.category_item);
            //items = itemView.findViewById(R.id.itemSum);
        }
    }
}
