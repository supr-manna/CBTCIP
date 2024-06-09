package com.supriya.quizapp.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.supriya.quizapp.R;

public class MyProgress extends Dialog {

    public MyProgress(Context mContext) {
        super(mContext, R.style.RoundedCornersDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_my_progress);
        setCancelable(false);
    }
}
