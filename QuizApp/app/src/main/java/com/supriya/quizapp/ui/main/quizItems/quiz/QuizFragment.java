package com.supriya.quizapp.ui.main.quizItems.quiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.supriya.quizapp.R;
import com.supriya.quizapp.databinding.FragmentQuizBinding;
import com.supriya.quizapp.util.MyProgress;
import com.supriya.quizapp.util.TimeOutDialog;

import java.util.HashMap;

public class QuizFragment extends Fragment implements View.OnClickListener {
    private QuestionViewModel viewModel;
    private NavController navController;
    private CountDownTimer countDownTimer;
    private MaterialButton option1Btn , option2Btn , option3Btn , option4Btn, nextQueBtn;
    private TextView questionTv , ansFeedBackTv , questionNumberTv , timerCountTv;
    private MaterialToolbar toolbar;
    private LinearProgressIndicator progressBar;
    private TimeOutDialog timeOutDialog;
    private long totalQueCount = 5, timer;
    private String quizId, correctAns, title;
    private int currentQueNo = 0, missedAnsCount = 0, correctAnsCount = 0, wrongAnsCount = 0, totalQuestion = 5;
    private boolean isAnswer = false;

    public QuizFragment() {}

    public static QuizFragment newInstance(String param1, String param2) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        quizId = getArguments().getString("quizId");
        totalQuestion = getArguments().getInt("totalCount");
        title = getArguments().getString("title");

        viewModel = new ViewModelProvider(this , ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(QuestionViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        option1Btn = view.findViewById(R.id.btnOption1);
        option2Btn = view.findViewById(R.id.btnOption2);
        option3Btn = view.findViewById(R.id.btnOption3);
        option4Btn = view.findViewById(R.id.btnOption4);
        nextQueBtn = view.findViewById(R.id.btnNextQuiz);
        ansFeedBackTv = view.findViewById(R.id.tvCorrectAns);
        questionTv = view.findViewById(R.id.tvQuestion);
        timerCountTv = view.findViewById(R.id.tvTimer);
        questionNumberTv = view.findViewById(R.id.tvInfo);
        progressBar = view.findViewById(R.id.quizProgress);
        toolbar = view.findViewById(R.id.toolbar);

        viewModel.setQuizId(quizId);
        viewModel.getQuestions();

        initListener();
        fetchQuizList(1);
        enableOptions();
    }

    private void initListener() {
        option1Btn.setOnClickListener(this);
        option2Btn.setOnClickListener(this);
        option3Btn.setOnClickListener(this);
        option4Btn.setOnClickListener(this);
        nextQueBtn.setOnClickListener(this);

        toolbar.setNavigationOnClickListener(v -> navController.popBackStack());
        toolbar.setTitle(title);
    }

    private void fetchQuizList(int position) {
        currentQueNo = position;
        viewModel.getQuestionMutableLiveData().observe(getViewLifecycleOwner(), questionModels -> {
            if (!questionModels.isEmpty()) {
                questionTv.setText(questionModels.get(position - 1).getQuestion());
                option1Btn.setText(questionModels.get(position -1).getOption_a());
                option2Btn.setText(questionModels.get(position -1).getOption_b());
                option3Btn.setText(questionModels.get(position -1).getOption_c());
                option4Btn.setText(questionModels.get(position -1).getOption_d());
                timer = questionModels.get(position - 1).getTimer();
                correctAns = questionModels.get(position - 1).getAnswer();
                questionNumberTv.setText(totalQuestion+"/"+ currentQueNo);
                progressBar.setProgress((currentQueNo*100)/totalQuestion);
                startTimer();
            }
        });
        isAnswer = true;
    }

    private void startTimer() {
        timerCountTv.setText(String.valueOf(timer));
        countDownTimer = new CountDownTimer(timer*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerCountTv.setText(millisUntilFinished/1000 + "");
            }

            @Override
            public void onFinish() {
                showTimeOut(true);
            }
        }.start();
    }

    private void showNextBtn() {
        if (currentQueNo == totalQueCount) {
            nextQueBtn.setText("Submit");
        }
        nextQueBtn.setVisibility(View.VISIBLE);
        nextQueBtn.setEnabled(true);
    }

    private void enableOptions(){
        option1Btn.setVisibility(View.VISIBLE);
        option2Btn.setVisibility(View.VISIBLE);
        option3Btn.setVisibility(View.VISIBLE);
        option4Btn.setVisibility(View.VISIBLE);

        option1Btn.setEnabled(true);
        option2Btn.setEnabled(true);
        option3Btn.setEnabled(true);
        option4Btn.setEnabled(true);

        nextQueBtn.setVisibility(View.INVISIBLE);
        ansFeedBackTv.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnOption1) {
            verifyAnswer(option1Btn);
        } else if (v.getId() == R.id.btnOption2) {
            verifyAnswer(option2Btn);
        } else if (v.getId() == R.id.btnOption3) {
            verifyAnswer(option3Btn);
        } else if (v.getId() == R.id.btnOption4) {
            verifyAnswer(option4Btn);
        } else if (v.getId() == R.id.btnNextQuiz){
            if (currentQueNo == totalQueCount) {
                submitAns();
            } else {
                currentQueNo++;
                fetchQuizList(currentQueNo);
                resetOpt();
            }
        }
    }

    private void resetOpt() {
        nextQueBtn.setVisibility(View.INVISIBLE);
        ansFeedBackTv.setVisibility(View.GONE);
        nextQueBtn.setEnabled(false);
        option1Btn.setBackgroundTintList(ContextCompat.getColorStateList(requireContext() , R.color.white));
        option2Btn.setBackgroundTintList(ContextCompat.getColorStateList(requireContext() , R.color.white));
        option3Btn.setBackgroundTintList(ContextCompat.getColorStateList(requireContext() , R.color.white));
        option4Btn.setBackgroundTintList(ContextCompat.getColorStateList(requireContext() , R.color.white));
    }

    private void submitAns() {
        HashMap<String , Object> resultMap = new HashMap<>();
        resultMap.put("correct" , correctAnsCount);
        resultMap.put("wrong" , wrongAnsCount);
        resultMap.put("notAnswered" , missedAnsCount);
        viewModel.addResults(resultMap);

        Bundle bundle = new Bundle();
        bundle.putString("quizId", quizId);
        navController.navigate(R.id.action_fragmentQuiz_to_fragmentResult, bundle);
    }

    private void verifyAnswer(MaterialButton btn) {
        ansFeedBackTv.setVisibility(View.VISIBLE);
        if (isAnswer) {
            if (correctAns.equals(btn.getText())) {
                ansFeedBackTv.setText("Correct Answer");
                btn.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.green));
                ansFeedBackTv.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.green));
                ansFeedBackTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
                correctAnsCount++;
            } else {
                btn.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.red));
                ansFeedBackTv.setText("Wrong Answer. Correct answer is -"+correctAns);
                ansFeedBackTv.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.red));
                ansFeedBackTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.white));
                wrongAnsCount++;
            }
        }
        isAnswer = false;
        countDownTimer.cancel();
        showNextBtn();
    }

    private void showTimeOut(Boolean status) {
        try {
            if (timeOutDialog == null) {
                timeOutDialog = new TimeOutDialog(requireContext());
                timeOutDialog.setOnCancelListener(() -> {
                    isAnswer = false;
                    missedAnsCount ++;
                    if (currentQueNo == totalQueCount) {
                        submitAns();
                    } else {
                        currentQueNo++;
                        fetchQuizList(currentQueNo);
                        resetOpt();
                    }
                });
            }
            if (status) {
                timeOutDialog.show();
            } else {
                timeOutDialog.dismiss();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (timeOutDialog != null) {
            timeOutDialog.dismiss();
        }
    }
}