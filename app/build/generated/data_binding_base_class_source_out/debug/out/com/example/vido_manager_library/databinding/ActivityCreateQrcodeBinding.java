// Generated by view binder compiler. Do not edit!
package com.example.vido_manager_library.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.vido_manager_library.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCreateQrcodeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView avt;

  @NonNull
  public final ImageView back;

  @NonNull
  public final TextView classStudent;

  @NonNull
  public final TextView codeStudent;

  @NonNull
  public final ImageView imageQRCode;

  @NonNull
  public final TextView nameStudent;

  @NonNull
  public final TextView textView10;

  private ActivityCreateQrcodeBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView avt,
      @NonNull ImageView back, @NonNull TextView classStudent, @NonNull TextView codeStudent,
      @NonNull ImageView imageQRCode, @NonNull TextView nameStudent, @NonNull TextView textView10) {
    this.rootView = rootView;
    this.avt = avt;
    this.back = back;
    this.classStudent = classStudent;
    this.codeStudent = codeStudent;
    this.imageQRCode = imageQRCode;
    this.nameStudent = nameStudent;
    this.textView10 = textView10;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCreateQrcodeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCreateQrcodeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_create_qrcode, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCreateQrcodeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.avt;
      ImageView avt = ViewBindings.findChildViewById(rootView, id);
      if (avt == null) {
        break missingId;
      }

      id = R.id.back;
      ImageView back = ViewBindings.findChildViewById(rootView, id);
      if (back == null) {
        break missingId;
      }

      id = R.id.class_student;
      TextView classStudent = ViewBindings.findChildViewById(rootView, id);
      if (classStudent == null) {
        break missingId;
      }

      id = R.id.code_student;
      TextView codeStudent = ViewBindings.findChildViewById(rootView, id);
      if (codeStudent == null) {
        break missingId;
      }

      id = R.id.imageQRCode;
      ImageView imageQRCode = ViewBindings.findChildViewById(rootView, id);
      if (imageQRCode == null) {
        break missingId;
      }

      id = R.id.name_student;
      TextView nameStudent = ViewBindings.findChildViewById(rootView, id);
      if (nameStudent == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      return new ActivityCreateQrcodeBinding((ConstraintLayout) rootView, avt, back, classStudent,
          codeStudent, imageQRCode, nameStudent, textView10);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
