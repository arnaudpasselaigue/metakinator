package com.ia.android.akinasport.models;

/**
 * Created by Arnaud on 31/03/2016.
 */
public class Answer
{
    private int id;
    private int entity_id;
    private int questions_id;
    private int response;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getEntity_id() {return entity_id;}
    public void setEntity_id(int entity_id) {this.entity_id = entity_id;}

    public int getQuestions_id() {return questions_id;}
    public void setQuestions_id(int questions_id) {this.questions_id = questions_id;}

    public int getResponse() {return response;}
    public void setResponse(int response) {this.response = response;}
}
