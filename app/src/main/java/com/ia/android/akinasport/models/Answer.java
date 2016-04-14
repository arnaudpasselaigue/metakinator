package com.ia.android.akinasport.models;

/**
 * Created by Arnaud on 31/03/2016.
 */
public class Answer
{
    private int id;
    private int sport_id;
    private int questions_id;
    private int response;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getSport_id() {return sport_id;}
    public void setSport_id(int sport_id) {this.sport_id = sport_id;}

    public int getQuestions_id() {return questions_id;}
    public void setQuestions_id(int questions_id) {this.questions_id = questions_id;}

    public int getResponse() {return response;}
    public void setResponse(int response) {this.response = response;}
}
