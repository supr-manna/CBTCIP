package com.supriya.quizapp.network.model.questionList;

import com.google.firebase.firestore.DocumentId;

public class QuestionModel {
    @DocumentId
    private String questionId;
    private String answer,question,option_a, option_b, option_c, option_d;
    private long timer;

    public QuestionModel() {}

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOption_a() {
        return option_a;
    }

    public void setOption_a(String option_a) {
        this.option_a = option_a;
    }

    public String getOption_b() {
        return option_b;
    }

    public void setOption_b(String option_b) {
        this.option_b = option_b;
    }

    public String getOption_c() {
        return option_c;
    }

    public void setOption_c(String option_c) {
        this.option_c = option_c;
    }

    public String getOption_d() {
        return option_d;
    }

    public void setOption_d(String option_d) {
        this.option_d = option_d;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "questionId='" + questionId + '\'' +
                ", answer='" + answer + '\'' +
                ", option_a='" + option_a + '\'' +
                ", option_b='" + option_b + '\'' +
                ", option_c='" + option_c + '\'' +
                ", option_d='" + option_d + '\'' +
                ", timer=" + timer +
                '}';
    }
}
