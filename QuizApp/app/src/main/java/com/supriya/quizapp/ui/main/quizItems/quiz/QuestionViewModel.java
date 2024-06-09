package com.supriya.quizapp.ui.main.quizItems.quiz;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.supriya.quizapp.network.model.questionList.QuestionModel;
import com.supriya.quizapp.network.repository.QuestionRepository;

import java.util.HashMap;
import java.util.List;

public class QuestionViewModel extends ViewModel implements QuestionRepository.OnQuestionLoad, QuestionRepository.OnResultAdded, QuestionRepository.OnResultLoad {
    private QuestionRepository repository;
    private MutableLiveData<List<QuestionModel>> questionMutableLiveData;
    private MutableLiveData<Boolean> resultAdded;
    private MutableLiveData<HashMap<String , Long>> resultMutableLiveData;
    public MutableLiveData<HashMap<String, Long>> getResultMutableLiveData() {
        return resultMutableLiveData;
    }

    public void addResults(HashMap<String , Object> resultMap){
        repository.addResults(resultMap);
    }

    public void getResults(){
        repository.getResults();
    }

    public QuestionViewModel(){
        questionMutableLiveData = new MutableLiveData<>();
        resultMutableLiveData = new MutableLiveData<>();
        resultAdded = new MutableLiveData<>();
        repository = new QuestionRepository(this, this, this);
    }

    public MutableLiveData<List<QuestionModel>> getQuestionMutableLiveData() {
        return questionMutableLiveData;
    }

    public MutableLiveData<Boolean> resultAdded() {
        return resultAdded;
    }

    public void setQuizId(String quizId) {
        repository.setQuizId(quizId);
    }

    public void getQuestions(){
        repository.getQuestions();
    }

    @Override
    public void onLoad(List<QuestionModel> questionModels) {
        questionMutableLiveData.setValue(questionModels);
    }

    @Override
    public void onResultLoad(HashMap<String, Long> resultMap) {
        resultMutableLiveData.setValue(resultMap);
    }

    @Override
    public void onSubmit() {
        resultAdded.setValue(true);
    }

    @Override
    public void onError(Exception e) {
        Log.d("QuizError","onError:" + e.getMessage());
    }
}
