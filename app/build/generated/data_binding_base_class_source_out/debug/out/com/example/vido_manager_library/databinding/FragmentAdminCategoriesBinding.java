// Generated by view binder compiler. Do not edit!
package com.example.vido_manager_library.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.vido_manager_library.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAdminCategoriesBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView addCategory;

  @NonNull
  public final RecyclerView listviewCategory;

  @NonNull
  public final EditText searchInputcategory;

  @NonNull
  public final ImageView searchOutputcategory;

  private FragmentAdminCategoriesBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView addCategory, @NonNull RecyclerView listviewCategory,
      @NonNull EditText searchInputcategory, @NonNull ImageView searchOutputcategory) {
    this.rootView = rootView;
    this.addCategory = addCategory;
    this.listviewCategory = listviewCategory;
    this.searchInputcategory = searchInputcategory;
    this.searchOutputcategory = searchOutputcategory;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAdminCategoriesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAdminCategoriesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_admin_categories, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAdminCategoriesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addCategory;
      ImageView addCategory = ViewBindings.findChildViewById(rootView, id);
      if (addCategory == null) {
        break missingId;
      }

      id = R.id.listview_category;
      RecyclerView listviewCategory = ViewBindings.findChildViewById(rootView, id);
      if (listviewCategory == null) {
        break missingId;
      }

      id = R.id.search_inputcategory;
      EditText searchInputcategory = ViewBindings.findChildViewById(rootView, id);
      if (searchInputcategory == null) {
        break missingId;
      }

      id = R.id.search_outputcategory;
      ImageView searchOutputcategory = ViewBindings.findChildViewById(rootView, id);
      if (searchOutputcategory == null) {
        break missingId;
      }

      return new FragmentAdminCategoriesBinding((LinearLayout) rootView, addCategory,
          listviewCategory, searchInputcategory, searchOutputcategory);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
