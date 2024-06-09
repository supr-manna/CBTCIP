package com.supriya.quizapp.ui.main.quizItems;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.supriya.quizapp.network.model.quizList.QuizListModel;
import com.supriya.quizapp.network.repository.QuizRepository;

import java.util.List;

public class QuizViewModel extends ViewModel implements QuizRepository.onFirestoreTaskComplete {

    private MutableLiveData<List<QuizListModel>> quizListLiveData = new MutableLiveData<>();
    private QuizRepository repository = new QuizRepository(this);

    public MutableLiveData<List<QuizListModel>> getQuizListLiveData(){
        return quizListLiveData;
    }
    public QuizViewModel(){
        repository.getQuizData();
    }
    @Override
    public void quizDataLoader(List<QuizListModel> quizListModels) {
        quizListLiveData.setValue(quizListModels);
    }

    @Override
    public void onError(Exception e) {
        Log.d("QuizERROR","onError:" + e.getMessage());
    }
}
