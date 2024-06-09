// Generated by view binder compiler. Do not edit!
package com.supriya.quizapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.supriya.quizapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSignUpBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton btnSignUp;

  @NonNull
  public final EditText etEmail;

  @NonNull
  public final EditText etName;

  @NonNull
  public final EditText etPassword;

  @NonNull
  public final ImageView ivFirstImage;

  @NonNull
  public final TextInputLayout tillEmail;

  @NonNull
  public final TextInputLayout tillName;

  @NonNull
  public final TextInputLayout tillPassword;

  @NonNull
  public final TextView tvFirstTitle;

  @NonNull
  public final TextView tvGotoSIgnIn;

  @NonNull
  public final TextView tvTerms;

  private FragmentSignUpBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton btnSignUp, @NonNull EditText etEmail, @NonNull EditText etName,
      @NonNull EditText etPassword, @NonNull ImageView ivFirstImage,
      @NonNull TextInputLayout tillEmail, @NonNull TextInputLayout tillName,
      @NonNull TextInputLayout tillPassword, @NonNull TextView tvFirstTitle,
      @NonNull TextView tvGotoSIgnIn, @NonNull TextView tvTerms) {
    this.rootView = rootView;
    this.btnSignUp = btnSignUp;
    this.etEmail = etEmail;
    this.etName = etName;
    this.etPassword = etPassword;
    this.ivFirstImage = ivFirstImage;
    this.tillEmail = tillEmail;
    this.tillName = tillName;
    this.tillPassword = tillPassword;
    this.tvFirstTitle = tvFirstTitle;
    this.tvGotoSIgnIn = tvGotoSIgnIn;
    this.tvTerms = tvTerms;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_sign_up, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSignUpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnSignUp;
      MaterialButton btnSignUp = ViewBindings.findChildViewById(rootView, id);
      if (btnSignUp == null) {
        break missingId;
      }

      id = R.id.etEmail;
      EditText etEmail = ViewBindings.findChildViewById(rootView, id);
      if (etEmail == null) {
        break missingId;
      }

      id = R.id.etName;
      EditText etName = ViewBindings.findChildViewById(rootView, id);
      if (etName == null) {
        break missingId;
      }

      id = R.id.etPassword;
      EditText etPassword = ViewBindings.findChildViewById(rootView, id);
      if (etPassword == null) {
        break missingId;
      }

      id = R.id.ivFirstImage;
      ImageView ivFirstImage = ViewBindings.findChildViewById(rootView, id);
      if (ivFirstImage == null) {
        break missingId;
      }

      id = R.id.tillEmail;
      TextInputLayout tillEmail = ViewBindings.findChildViewById(rootView, id);
      if (tillEmail == null) {
        break missingId;
      }

      id = R.id.tillName;
      TextInputLayout tillName = ViewBindings.findChildViewById(rootView, id);
      if (tillName == null) {
        break missingId;
      }

      id = R.id.tillPassword;
      TextInputLayout tillPassword = ViewBindings.findChildViewById(rootView, id);
      if (tillPassword == null) {
        break missingId;
      }

      id = R.id.tvFirstTitle;
      TextView tvFirstTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvFirstTitle == null) {
        break missingId;
      }

      id = R.id.tvGotoSIgnIn;
      TextView tvGotoSIgnIn = ViewBindings.findChildViewById(rootView, id);
      if (tvGotoSIgnIn == null) {
        break missingId;
      }

      id = R.id.tvTerms;
      TextView tvTerms = ViewBindings.findChildViewById(rootView, id);
      if (tvTerms == null) {
        break missingId;
      }

      return new FragmentSignUpBinding((ConstraintLayout) rootView, btnSignUp, etEmail, etName,
          etPassword, ivFirstImage, tillEmail, tillName, tillPassword, tvFirstTitle, tvGotoSIgnIn,
          tvTerms);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}