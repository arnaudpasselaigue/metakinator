package com.ia.android.akinasport.activity;

import android.os.Bundle;

import com.ia.android.akinasport.R;
import com.ia.android.akinasport.customlisteners.OnQuestionsListener;
import com.ia.android.akinasport.services.PsQuestions;
import com.ia.android.akinasport.utils.GlobalVariables;

public class MainActivity extends ParentActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GET FIRST QUESTION
        PsQuestions psQuestions = new PsQuestions();
        psQuestions.getFirstQuestion(new OnQuestionsListener() {
            @Override
            public void OnResponse(int id) {
                GlobalVariables.getsInstance().setFirstQuestion(id);
            }
        });


    }
}
