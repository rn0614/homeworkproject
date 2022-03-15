// Generated by view binder compiler. Do not edit!
package com.example.homeworkproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.homeworkproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogEditBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnOk;

  @NonNull
  public final EditText etContent;

  @NonNull
  public final EditText etTitle;

  @NonNull
  public final TextView tvDesContent;

  @NonNull
  public final TextView tvDesTitle;

  private DialogEditBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnOk,
      @NonNull EditText etContent, @NonNull EditText etTitle, @NonNull TextView tvDesContent,
      @NonNull TextView tvDesTitle) {
    this.rootView = rootView;
    this.btnOk = btnOk;
    this.etContent = etContent;
    this.etTitle = etTitle;
    this.tvDesContent = tvDesContent;
    this.tvDesTitle = tvDesTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogEditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_edit, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogEditBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_ok;
      Button btnOk = ViewBindings.findChildViewById(rootView, id);
      if (btnOk == null) {
        break missingId;
      }

      id = R.id.et_content;
      EditText etContent = ViewBindings.findChildViewById(rootView, id);
      if (etContent == null) {
        break missingId;
      }

      id = R.id.et_title;
      EditText etTitle = ViewBindings.findChildViewById(rootView, id);
      if (etTitle == null) {
        break missingId;
      }

      id = R.id.tv_des_content;
      TextView tvDesContent = ViewBindings.findChildViewById(rootView, id);
      if (tvDesContent == null) {
        break missingId;
      }

      id = R.id.tv_des_title;
      TextView tvDesTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvDesTitle == null) {
        break missingId;
      }

      return new DialogEditBinding((ConstraintLayout) rootView, btnOk, etContent, etTitle,
          tvDesContent, tvDesTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}