package com.quizzood2.etiennemaxime.quizzood2.Model;

public class Question {
    private String Question, Answer1, Answer2 ,Answer3 ,Answer4 ,CorrectAnswer, CategoryId;

    public void setQuestion(String question) {
        Question = question;
    }

    public void setAnswer1(String answer1) {
        Answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        Answer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        Answer3 = answer3;
    }

    public void setAnswer4(String answer4) {
        Answer4 = answer4;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getQuestion() {

        return Question;
    }

    public String getAnswer1() {
        return Answer1;
    }

    public String getAnswer2() {
        return Answer2;
    }

    public String getAnswer3() {
        return Answer3;
    }

    public String getAnswer4() {
        return Answer4;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public Question() {

    }

    public Question(String question, String answer1, String answer2, String answer3, String answer4, String correctAnswer, String categoryId) {

        Question = question;
        Answer1 = answer1;
        Answer2 = answer2;
        Answer3 = answer3;
        Answer4 = answer4;
        CorrectAnswer = correctAnswer;
        CategoryId = categoryId;
    }
}
