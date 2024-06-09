package com.supriya.quizapp.network.model.quizList;

import com.google.firebase.firestore.DocumentId;

public class QuizListModel {

 @DocumentId
   private String quizId;
   private String title,image,difficulty;
   private int questions;

   public QuizListModel(){}
   public QuizListModel(String quizId, String title, String image, String difficulty, int questions){
       this.quizId = quizId;
       this.title = title;
       this.image = image;
       this.questions = questions;
       this.difficulty = difficulty;
   }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getQuestions() {
        return questions;
    }

    public void setQuestions(int questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "quizId='" + quizId + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", questions=" + questions +
                '}';
    }
}
