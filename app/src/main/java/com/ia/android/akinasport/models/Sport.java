package com.ia.android.akinasport.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Arnaud on 17/03/2016.
 */
public class Sport
{
    private int id;
    private String name;
    private ArrayList<Answer> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Answer> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Answer> questions) {
        this.questions = questions;
    }
}
