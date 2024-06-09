package com.supriya.quizapp.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.supriya.quizapp.R;
import com.supriya.quizapp.databinding.TimeOutDialogBinding;

public class TimeOutDialog extends Dialog {
    TimeOutDialogBinding binding;
    private OnCancelClickListener listener;
    public TimeOutDialog(Context mContext) {
        super(mContext, R.style.RoundedCornersDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TimeOutDialogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setCancelable(false);

        binding.btnCancel.setOnClickListener(v -> {
            dismiss();
            if (listener != null) {
                listener.onCancelClick();
            }
        });
    }

    public void setOnCancelListener(OnCancelClickListener listener) {
        this.listener = listener;
    }
    public interface OnCancelClickListener {
        void onCancelClick();
    }
}
