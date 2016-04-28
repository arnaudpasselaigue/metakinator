package com.ia.android.akinasport.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Arnaud on 17/03/2016.
 */
public class Entity
{
    private int id;
    private int score;
    private String name;
    private String klass;
    private ArrayList<Integer> answers;

    public int getId() {
        return id;
    }
    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getAnswers() {return answers;}
    public void setAnswers(ArrayList<Integer> answers) {this.answers = answers;}

    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}

    public String getKlass() {return klass;}
    public void setKlass(String klass) {this.klass = klass;}
}
