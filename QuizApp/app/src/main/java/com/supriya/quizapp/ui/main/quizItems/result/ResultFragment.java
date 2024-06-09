package com.supriya.quizapp.ui.main.quizItems.result;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.supriya.quizapp.R;
import com.supriya.quizapp.databinding.FragmentResultBinding;
import com.supriya.quizapp.ui.main.quizItems.quiz.QuestionViewModel;

import java.util.HashMap;

public class ResultFragment extends Fragment {
    private NavController navController;
    private QuestionViewModel viewModel;
    private String quizId = "";
    private MaterialButton btnReset;
    private ImageView btnLogout;
    private TextView tvCorrect, tvWrong, tvMissed, tvPercent;
    private ProgressBar scoreProgressbar;
    Long correct, wrong, noAnswer, total, percent;
    private FirebaseAuth mAuth;

    public ResultFragment() {
        // Required empty public constructor
    }

    public static ResultFragment newInstance(String param1, String param2) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quizId = getArguments().getString("quizId");

        viewModel = new ViewModelProvider(this , ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(QuestionViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        navController = Navigation.findNavController(view);
        btnReset = view.findViewById(R.id.btnHome);
        tvCorrect = view.findViewById(R.id.tvCorrect);
        tvWrong = view.findViewById(R.id.tvWrong);
        tvMissed = view.findViewById(R.id.tvNoAnswer);
        tvPercent = view.findViewById(R.id.tvResultCount);
        scoreProgressbar = view.findViewById(R.id.resultProgress);
        btnLogout = view.findViewById(R.id.tvLogout);


        viewModel.setQuizId(quizId);
        viewModel.getResults();

        initListener();
        initObserver();
    }

    private void initListener() {
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.popBackStack();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             mAuth.signOut();
             navController.navigate(R.id.action_result_signIn);
            }
        });
    }

    private void initObserver() {
        viewModel.getResultMutableLiveData().observe(getViewLifecycleOwner(), new Observer<HashMap<String, Long>>() {
            @Override
            public void onChanged(HashMap<String, Long> resultMap) {
                updateUI(resultMap);
            }
        });
    }

    private void updateUI(HashMap<String, Long> resultData) {
        correct = resultData.get("correct");
        wrong = resultData.get("wrong");
        noAnswer = resultData.get("notAnswered");

        total = correct + wrong + noAnswer;
        percent = (correct*100)/total;

        tvPercent.setText(String.valueOf(percent));
        scoreProgressbar.setProgress(percent.intValue());
        tvCorrect.setText(String.valueOf(correct));
        tvWrong.setText(String.valueOf(wrong));
        tvMissed.setText(String.valueOf(noAnswer));
    }
}