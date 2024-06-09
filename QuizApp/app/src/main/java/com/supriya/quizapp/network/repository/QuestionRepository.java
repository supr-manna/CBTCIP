package com.supriya.quizapp.network.repository;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.supriya.quizapp.network.model.questionList.QuestionModel;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class QuestionRepository {
    private FirebaseFirestore firebaseFirestore;
    private  String quizId, currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
    private HashMap<String , Long> resultMap= new HashMap<>();
    private OnQuestionLoad onQuestionLoad;
    private OnResultAdded onResultAdded;
    private OnResultLoad onResultLoad;

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public QuestionRepository(OnQuestionLoad onQuestionLoad,OnResultAdded onResultAdded , OnResultLoad onResultLoad){
        firebaseFirestore = FirebaseFirestore.getInstance();
        this.onQuestionLoad = onQuestionLoad;
        this.onResultAdded = onResultAdded;
        this.onResultLoad = onResultLoad;
    }

    public void getResults(){
        firebaseFirestore.collection("Quiz").document(quizId)
                .collection("results").document(currentUserId)
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()){
                            resultMap.put("correct" , task.getResult().getLong("correct"));
                            resultMap.put("wrong" , task.getResult().getLong("wrong"));
                            resultMap.put("notAnswered" , task.getResult().getLong("notAnswered"));
                            onResultLoad.onResultLoad(resultMap);
                        }else{
                            onResultLoad.onError(task.getException());
                        }
                    }
                });
    }

    public void getQuestions(){
        firebaseFirestore.collection("Quiz").document(quizId)
                .collection("questions").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                       if(task.isSuccessful()){
                           onQuestionLoad.onLoad(task.getResult().toObjects(QuestionModel.class));
                       }else{
                           onQuestionLoad.onError(task.getException());

                       }
                    }
                });
    }

    public void addResults(HashMap<String , Object> resultMap){
        firebaseFirestore.collection("Quiz").document(quizId)
                .collection("results").document(currentUserId)
                .set(resultMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            onResultAdded.onSubmit();
                        }else{
                            onResultAdded.onError(task.getException());
                        }
                    }
                });
    }

    public interface OnQuestionLoad{
        void onLoad(List<QuestionModel> questionModels);
        void onError(Exception e);
    }

    public interface OnResultLoad{
        void onResultLoad(HashMap<String , Long> resultMap);
        void onError(Exception e);
    }

    public interface OnResultAdded{
        void onSubmit();
        void onError(Exception e);
    }
}
