// Generated by view binder compiler. Do not edit!
package com.example.vido_manager_library.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.vido_manager_library.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAdminPositionsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ListView listviewPosition;

  @NonNull
  public final EditText searchInputposition;

  @NonNull
  public final ImageView searchOutputposition;

  private FragmentAdminPositionsBinding(@NonNull LinearLayout rootView,
      @NonNull ListView listviewPosition, @NonNull EditText searchInputposition,
      @NonNull ImageView searchOutputposition) {
    this.rootView = rootView;
    this.listviewPosition = listviewPosition;
    this.searchInputposition = searchInputposition;
    this.searchOutputposition = searchOutputposition;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAdminPositionsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAdminPositionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_admin_positions, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAdminPositionsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.listview_position;
      ListView listviewPosition = ViewBindings.findChildViewById(rootView, id);
      if (listviewPosition == null) {
        break missingId;
      }

      id = R.id.search_inputposition;
      EditText searchInputposition = ViewBindings.findChildViewById(rootView, id);
      if (searchInputposition == null) {
        break missingId;
      }

      id = R.id.search_outputposition;
      ImageView searchOutputposition = ViewBindings.findChildViewById(rootView, id);
      if (searchOutputposition == null) {
        break missingId;
      }

      return new FragmentAdminPositionsBinding((LinearLayout) rootView, listviewPosition,
          searchInputposition, searchOutputposition);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}