package com.ia.android.akinasport.servicesinterfaces;

import com.ia.android.akinasport.customlisteners.OnQuestionsListener;

/**
 * Created by Arnaud on 14/04/2016.
 */
public interface iQuestions
{
    void getFirstQuestion(OnQuestionsListener listener);
    void getNextQuestion(int[] id_questions, OnQuestionsListener listener);
}
