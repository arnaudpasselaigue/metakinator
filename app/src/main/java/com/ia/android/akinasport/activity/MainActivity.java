package com.ia.android.akinasport.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.telephony.gsm.GsmCellLocation;
import android.view.View;
import android.widget.Button;

import com.ia.android.akinasport.R;
import com.ia.android.akinasport.customlisteners.OnQuestionsListener;
import com.ia.android.akinasport.customviews.AkinasportTextView;
import com.ia.android.akinasport.services.PsQuestions;
import com.ia.android.akinasport.utils.Daneel;
import com.ia.android.akinasport.utils.GlobalVariables;
import com.ia.android.akinasport.utils.ModelsManager;

public class MainActivity extends ParentActivity
{
    private AkinasportTextView questionTextView;

    private Daneel daneel;

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

        daneel = new Daneel();

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
                GlobalVariables.getsInstance().setActualQuestion(id);
                questionTextView.setText(GlobalVariables.getsInstance().getModelManager().getQuestions().get(id).getTitle() + " ?");
                GlobalVariables.getsInstance().setFirstConnexion(false);
            }
        });
    }

    public View.OnClickListener yesBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (GlobalVariables.getsInstance().isFirstConnexion())
                daneel.applyScore(GlobalVariables.getsInstance().getFirstQuestion(), ANSWER_YES);
            else
                daneel.applyScore(GlobalVariables.getsInstance().getActualQuestion(), ANSWER_YES);

            getNextQuestion();
        }
    };

    public View.OnClickListener probablyYesBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (GlobalVariables.getsInstance().isFirstConnexion())
                daneel.applyScore(GlobalVariables.getsInstance().getFirstQuestion(), ANSWER_PROBABLY_YES);
            else
                daneel.applyScore(GlobalVariables.getsInstance().getActualQuestion(), ANSWER_PROBABLY_YES);

            getNextQuestion();
        }
    };

    public View.OnClickListener dontKnowBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (GlobalVariables.getsInstance().isFirstConnexion())
                daneel.applyScore(GlobalVariables.getsInstance().getFirstQuestion(), ANSWER_DONT_KNOW);
            else
                daneel.applyScore(GlobalVariables.getsInstance().getActualQuestion(), ANSWER_DONT_KNOW);

            getNextQuestion();
        }
    };

    public View.OnClickListener probablyNoBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (GlobalVariables.getsInstance().isFirstConnexion())
                daneel.applyScore(GlobalVariables.getsInstance().getFirstQuestion(), ANSWER_PROBABLY_NO);
            else
                daneel.applyScore(GlobalVariables.getsInstance().getActualQuestion(), ANSWER_PROBABLY_NO);

            getNextQuestion();
        }
    };

    public View.OnClickListener noBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (GlobalVariables.getsInstance().isFirstConnexion())
                daneel.applyScore(GlobalVariables.getsInstance().getFirstQuestion(), ANSWER_NO);
            else
                daneel.applyScore(GlobalVariables.getsInstance().getActualQuestion(), ANSWER_NO);

            getNextQuestion();
        }
    };

    public void getNextQuestion()
    {
        PsQuestions psQuestions = new PsQuestions();
        psQuestions.getNextQuestion(daneel.getQuestionsAlreadyAsked(), new OnQuestionsListener() {
            @Override
            public void OnResponse(int id) {
                GlobalVariables.getsInstance().setActualQuestion(id);
                questionTextView.setText(GlobalVariables.getsInstance().getModelManager().getQuestions().get(id).getTitle() + " ?");
            }
        });
    }
}
