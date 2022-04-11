// Generated by view binder compiler. Do not edit!
package com.example.vido_manager_library.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.vido_manager_library.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAdminBooksBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView addBook;

  @NonNull
  public final RecyclerView listviewBook;

  @NonNull
  public final SearchView searchInputbook;

  private FragmentAdminBooksBinding(@NonNull LinearLayout rootView, @NonNull ImageView addBook,
      @NonNull RecyclerView listviewBook, @NonNull SearchView searchInputbook) {
    this.rootView = rootView;
    this.addBook = addBook;
    this.listviewBook = listviewBook;
    this.searchInputbook = searchInputbook;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAdminBooksBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAdminBooksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_admin_books, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAdminBooksBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addBook;
      ImageView addBook = ViewBindings.findChildViewById(rootView, id);
      if (addBook == null) {
        break missingId;
      }

      id = R.id.listview_book;
      RecyclerView listviewBook = ViewBindings.findChildViewById(rootView, id);
      if (listviewBook == null) {
        break missingId;
      }

      id = R.id.search_inputbook;
      SearchView searchInputbook = ViewBindings.findChildViewById(rootView, id);
      if (searchInputbook == null) {
        break missingId;
      }

      return new FragmentAdminBooksBinding((LinearLayout) rootView, addBook, listviewBook,
          searchInputbook);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
