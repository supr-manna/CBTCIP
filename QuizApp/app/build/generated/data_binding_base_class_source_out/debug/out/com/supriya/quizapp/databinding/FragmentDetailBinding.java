// Generated by view binder compiler. Do not edit!
package com.supriya.quizapp.databinding;

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
import com.google.android.material.button.MaterialButton;
import com.supriya.quizapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDetailBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton btnStartQuiz;

  @NonNull
  public final ImageView ivDetailImage;

  @NonNull
  public final TextView tvDetailTitle;

  @NonNull
  public final TextView tvDifficulty;

  @NonNull
  public final TextView tvQuestionCount;

  @NonNull
  public final TextView tvQuizLevel;

  @NonNull
  public final TextView tvTotalQuestion;

  private FragmentDetailBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton btnStartQuiz, @NonNull ImageView ivDetailImage,
      @NonNull TextView tvDetailTitle, @NonNull TextView tvDifficulty,
      @NonNull TextView tvQuestionCount, @NonNull TextView tvQuizLevel,
      @NonNull TextView tvTotalQuestion) {
    this.rootView = rootView;
    this.btnStartQuiz = btnStartQuiz;
    this.ivDetailImage = ivDetailImage;
    this.tvDetailTitle = tvDetailTitle;
    this.tvDifficulty = tvDifficulty;
    this.tvQuestionCount = tvQuestionCount;
    this.tvQuizLevel = tvQuizLevel;
    this.tvTotalQuestion = tvTotalQuestion;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnStartQuiz;
      MaterialButton btnStartQuiz = ViewBindings.findChildViewById(rootView, id);
      if (btnStartQuiz == null) {
        break missingId;
      }

      id = R.id.ivDetailImage;
      ImageView ivDetailImage = ViewBindings.findChildViewById(rootView, id);
      if (ivDetailImage == null) {
        break missingId;
      }

      id = R.id.tvDetailTitle;
      TextView tvDetailTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailTitle == null) {
        break missingId;
      }

      id = R.id.tvDifficulty;
      TextView tvDifficulty = ViewBindings.findChildViewById(rootView, id);
      if (tvDifficulty == null) {
        break missingId;
      }

      id = R.id.tvQuestionCount;
      TextView tvQuestionCount = ViewBindings.findChildViewById(rootView, id);
      if (tvQuestionCount == null) {
        break missingId;
      }

      id = R.id.tvQuizLevel;
      TextView tvQuizLevel = ViewBindings.findChildViewById(rootView, id);
      if (tvQuizLevel == null) {
        break missingId;
      }

      id = R.id.tvTotalQuestion;
      TextView tvTotalQuestion = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalQuestion == null) {
        break missingId;
      }

      return new FragmentDetailBinding((ConstraintLayout) rootView, btnStartQuiz, ivDetailImage,
          tvDetailTitle, tvDifficulty, tvQuestionCount, tvQuizLevel, tvTotalQuestion);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
