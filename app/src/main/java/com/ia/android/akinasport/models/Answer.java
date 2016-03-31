package com.ia.android.akinasport.models;

/**
 * Created by Arnaud on 31/03/2016.
 */
public class Answer
{
    private int id;
    private int answerCode;
    private int id_question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnswerCode() {
        return answerCode;
    }

    public void setAnswerCode(int answerCode) {
        this.answerCode = answerCode;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }
}
