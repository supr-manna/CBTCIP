// Generated by view binder compiler. Do not edit!
package com.supriya.quizapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.supriya.quizapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentResultBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton btnHome;

  @NonNull
  public final ProgressBar resultProgress;

  @NonNull
  public final TextView tvCorrect;

  @NonNull
  public final TextView tvCorrectAns;

  @NonNull
  public final ImageView tvLogout;

  @NonNull
  public final TextView tvNoAnswer;

  @NonNull
  public final TextView tvNotAns;

  @NonNull
  public final TextView tvResult;

  @NonNull
  public final TextView tvResultCount;

  @NonNull
  public final TextView tvWrong;

  @NonNull
  public final TextView tvWrongAns;

  private FragmentResultBinding(@NonNull ConstraintLayout rootView, @NonNull MaterialButton btnHome,
      @NonNull ProgressBar resultProgress, @NonNull TextView tvCorrect,
      @NonNull TextView tvCorrectAns, @NonNull ImageView tvLogout, @NonNull TextView tvNoAnswer,
      @NonNull TextView tvNotAns, @NonNull TextView tvResult, @NonNull TextView tvResultCount,
      @NonNull TextView tvWrong, @NonNull TextView tvWrongAns) {
    this.rootView = rootView;
    this.btnHome = btnHome;
    this.resultProgress = resultProgress;
    this.tvCorrect = tvCorrect;
    this.tvCorrectAns = tvCorrectAns;
    this.tvLogout = tvLogout;
    this.tvNoAnswer = tvNoAnswer;
    this.tvNotAns = tvNotAns;
    this.tvResult = tvResult;
    this.tvResultCount = tvResultCount;
    this.tvWrong = tvWrong;
    this.tvWrongAns = tvWrongAns;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentResultBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentResultBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_result, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentResultBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnHome;
      MaterialButton btnHome = ViewBindings.findChildViewById(rootView, id);
      if (btnHome == null) {
        break missingId;
      }

      id = R.id.resultProgress;
      ProgressBar resultProgress = ViewBindings.findChildViewById(rootView, id);
      if (resultProgress == null) {
        break missingId;
      }

      id = R.id.tvCorrect;
      TextView tvCorrect = ViewBindings.findChildViewById(rootView, id);
      if (tvCorrect == null) {
        break missingId;
      }

      id = R.id.tvCorrectAns;
      TextView tvCorrectAns = ViewBindings.findChildViewById(rootView, id);
      if (tvCorrectAns == null) {
        break missingId;
      }

      id = R.id.tvLogout;
      ImageView tvLogout = ViewBindings.findChildViewById(rootView, id);
      if (tvLogout == null) {
        break missingId;
      }

      id = R.id.tvNoAnswer;
      TextView tvNoAnswer = ViewBindings.findChildViewById(rootView, id);
      if (tvNoAnswer == null) {
        break missingId;
      }

      id = R.id.tvNotAns;
      TextView tvNotAns = ViewBindings.findChildViewById(rootView, id);
      if (tvNotAns == null) {
        break missingId;
      }

      id = R.id.tvResult;
      TextView tvResult = ViewBindings.findChildViewById(rootView, id);
      if (tvResult == null) {
        break missingId;
      }

      id = R.id.tvResultCount;
      TextView tvResultCount = ViewBindings.findChildViewById(rootView, id);
      if (tvResultCount == null) {
        break missingId;
      }

      id = R.id.tvWrong;
      TextView tvWrong = ViewBindings.findChildViewById(rootView, id);
      if (tvWrong == null) {
        break missingId;
      }

      id = R.id.tvWrongAns;
      TextView tvWrongAns = ViewBindings.findChildViewById(rootView, id);
      if (tvWrongAns == null) {
        break missingId;
      }

      return new FragmentResultBinding((ConstraintLayout) rootView, btnHome, resultProgress,
          tvCorrect, tvCorrectAns, tvLogout, tvNoAnswer, tvNotAns, tvResult, tvResultCount, tvWrong,
          tvWrongAns);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
