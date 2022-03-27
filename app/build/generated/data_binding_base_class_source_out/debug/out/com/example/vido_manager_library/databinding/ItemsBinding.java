// Generated by view binder compiler. Do not edit!
package com.example.vido_manager_library.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.vido_manager_library.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView categoryItem;

  @NonNull
  public final TextView idItem;

  @NonNull
  public final ImageView igItem;

  @NonNull
  public final LinearLayout itemSum;

  @NonNull
  public final TextView nameItem;

  private ItemsBinding(@NonNull LinearLayout rootView, @NonNull TextView categoryItem,
      @NonNull TextView idItem, @NonNull ImageView igItem, @NonNull LinearLayout itemSum,
      @NonNull TextView nameItem) {
    this.rootView = rootView;
    this.categoryItem = categoryItem;
    this.idItem = idItem;
    this.igItem = igItem;
    this.itemSum = itemSum;
    this.nameItem = nameItem;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.items, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.category_item;
      TextView categoryItem = ViewBindings.findChildViewById(rootView, id);
      if (categoryItem == null) {
        break missingId;
      }

      id = R.id.id_item;
      TextView idItem = ViewBindings.findChildViewById(rootView, id);
      if (idItem == null) {
        break missingId;
      }

      id = R.id.ig_item;
      ImageView igItem = ViewBindings.findChildViewById(rootView, id);
      if (igItem == null) {
        break missingId;
      }

      LinearLayout itemSum = (LinearLayout) rootView;

      id = R.id.name_item;
      TextView nameItem = ViewBindings.findChildViewById(rootView, id);
      if (nameItem == null) {
        break missingId;
      }

      return new ItemsBinding((LinearLayout) rootView, categoryItem, idItem, igItem, itemSum,
          nameItem);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
