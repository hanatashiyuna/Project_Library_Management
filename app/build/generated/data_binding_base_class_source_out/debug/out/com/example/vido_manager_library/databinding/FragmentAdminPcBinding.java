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

public final class FragmentAdminPcBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView addPushingCompany;

  @NonNull
  public final RecyclerView listviewPc;

  @NonNull
  public final SearchView searchInputpc;

  private FragmentAdminPcBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView addPushingCompany, @NonNull RecyclerView listviewPc,
      @NonNull SearchView searchInputpc) {
    this.rootView = rootView;
    this.addPushingCompany = addPushingCompany;
    this.listviewPc = listviewPc;
    this.searchInputpc = searchInputpc;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAdminPcBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAdminPcBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_admin_pc, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAdminPcBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addPushingCompany;
      ImageView addPushingCompany = ViewBindings.findChildViewById(rootView, id);
      if (addPushingCompany == null) {
        break missingId;
      }

      id = R.id.listview_pc;
      RecyclerView listviewPc = ViewBindings.findChildViewById(rootView, id);
      if (listviewPc == null) {
        break missingId;
      }

      id = R.id.search_inputpc;
      SearchView searchInputpc = ViewBindings.findChildViewById(rootView, id);
      if (searchInputpc == null) {
        break missingId;
      }

      return new FragmentAdminPcBinding((LinearLayout) rootView, addPushingCompany, listviewPc,
          searchInputpc);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
