package com.ia.android.akinasport.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.ia.android.akinasport.R;
import com.ia.android.akinasport.customlisteners.OnQuestionsListener;
import com.ia.android.akinasport.customviews.AkinasportTextView;
import com.ia.android.akinasport.models.Sport;
import com.ia.android.akinasport.services.PsQuestions;
import com.ia.android.akinasport.utils.Daneel;
import com.ia.android.akinasport.utils.GlobalVariables;

import java.util.HashMap;
import java.util.Map;

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
        setCustomActionBar();

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
                GlobalVariables.getsInstance().setFirstConnexion(false);

                questionTextView.setVisibility(View.INVISIBLE);
                questionTextView.setText(GlobalVariables.getsInstance().getModelManager().getQuestions().get(id).getTitle() + " ?");
                questionTextView.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.DropOut).duration(1000).playOn(findViewById(R.id.textViewQuestion));
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
                questionTextView.setVisibility(View.INVISIBLE);
                questionTextView.setText(GlobalVariables.getsInstance().getModelManager().getQuestions().get(id).getTitle() + " ?");
                questionTextView.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.DropOut).duration(1000).playOn(findViewById(R.id.textViewQuestion));

                actualWinner();
            }
        });
    }

    public void actualWinner()
    {
        HashMap<Integer, Sport> m_sports = GlobalVariables.getsInstance().getModelManager().getSports();

        for (Map.Entry<Integer, Sport> sport : m_sports.entrySet())
        {
            if (sport.getValue().getScore() > 15)
            {
                Intent final_activity = new Intent(getApplicationContext(), FinalActivity.class);
                final_activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                final_activity.putExtra("WinnerEntity", sport.getValue().getName());
                finish();
                startActivity(final_activity);
                break;
            }
        }
    }
}
