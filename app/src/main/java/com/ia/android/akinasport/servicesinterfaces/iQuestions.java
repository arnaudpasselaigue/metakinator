package com.ia.android.akinasport.servicesinterfaces;

import com.ia.android.akinasport.customlisteners.OnQuestionsListener;

import java.util.ArrayList;

/**
 * Created by Arnaud on 14/04/2016.
 */
public interface iQuestions
{
    void getFirstQuestion(OnQuestionsListener listener);
    void getNextQuestion(ArrayList<Integer> id_questions, OnQuestionsListener listener);
}
