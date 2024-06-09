package com.supriya.quizapp.ui.main.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.supriya.quizapp.R;
import com.supriya.quizapp.network.model.quizList.QuizListModel;
import com.supriya.quizapp.ui.main.quizItems.QuizViewModel;

import java.util.List;

public class DetailFragment extends Fragment {
    private TextView title , difficulty , totalQuestions;
    private Button btnStartQuiz;
    private NavController navController;
    private int position;
    private QuizViewModel viewModel;
    private ImageView ivDetailImage;
     private String quizId, QTitle;
     private int totalQueCount;


    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("Position");

        viewModel = new ViewModelProvider(this , ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(QuizViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = view.findViewById(R.id.tvDetailTitle);
        difficulty = view.findViewById(R.id.tvDifficulty);
        ivDetailImage = view.findViewById(R.id.ivDetailImage);
        totalQuestions = view.findViewById(R.id.tvQuestionCount);
        btnStartQuiz = view.findViewById(R.id.btnStartQuiz);
        navController = Navigation.findNavController(view);

        viewModel.getQuizListLiveData().observe(getViewLifecycleOwner(), new Observer<List<QuizListModel>>() {
            @Override
            public void onChanged(List<QuizListModel> quizListModels) {
            QuizListModel quiz = quizListModels.get(position);
            difficulty.setText(quiz.getDifficulty());
            title.setText(quiz.getTitle());
            QTitle =  quiz.getTitle();
            totalQuestions.setText(String.valueOf(quiz.getQuestions()));
            Glide.with(view).load(quiz.getImage()).into(ivDetailImage);
            // Progress GONE
            totalQueCount = quiz.getQuestions();
            quizId = quiz.getQuizId();
            }
        });

        btnStartQuiz.setOnClickListener( v -> {
            Bundle bundle = new Bundle();
            bundle.putString("quizId", quizId);
            bundle.putString("title", QTitle);
            bundle.putInt("totalCount", totalQueCount);
            navController.navigate(R.id.action_detailFragment_to_quizFragment, bundle);
        });
    }
}