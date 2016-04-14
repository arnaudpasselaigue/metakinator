package com.ia.android.akinasport.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ia.android.akinasport.R;
import com.ia.android.akinasport.customlisteners.OnQuestionsListener;
import com.ia.android.akinasport.customviews.AkinasportTextView;
import com.ia.android.akinasport.services.PsQuestions;
import com.ia.android.akinasport.utils.GlobalVariables;

public class MainActivity extends ParentActivity
{
    private AkinasportTextView questionTextView;

    private Button yesBtn;
    private Button probablyYesBtn;
    private Button dontKnowBtn;
    private Button probablyNoBtn;
    private Button noBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = (AkinasportTextView)findViewById(R.id.textViewQuestion);
        yesBtn = (Button)findViewById(R.id.buttonYes);
        probablyYesBtn = (Button)findViewById(R.id.buttonProbablyYes);
        dontKnowBtn = (Button)findViewById(R.id.buttonDontKnow);
        probablyNoBtn = (Button)findViewById(R.id.buttonProbablyNo);
        noBtn = (Button)findViewById(R.id.buttonNo);

        yesBtn.setOnClickListener(yesBtnListener);
        probablyYesBtn.setOnClickListener(probablyYesBtnListener);
        dontKnowBtn.setOnClickListener(dontKnowBtnListener);
        probablyNoBtn.setOnClickListener(probablyNoBtnListener);
        noBtn.setOnClickListener(noBtnListener);

        //GET FIRST QUESTION
        PsQuestions psQuestions = new PsQuestions();
        psQuestions.getFirstQuestion(new OnQuestionsListener() {
            @Override
            public void OnResponse(int id) {
                GlobalVariables.getsInstance().setFirstQuestion(id);

            }
        });

    }

    public View.OnClickListener yesBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public View.OnClickListener probablyYesBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public View.OnClickListener dontKnowBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public View.OnClickListener probablyNoBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public View.OnClickListener noBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
