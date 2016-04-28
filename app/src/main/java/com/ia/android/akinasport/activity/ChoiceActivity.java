package com.ia.android.akinasport.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.ia.android.akinasport.R;
import com.ia.android.akinasport.services.PsAnswers;
import com.ia.android.akinasport.services.PsEntities;
import com.ia.android.akinasport.services.PsQuestions;
import com.ia.android.akinasport.utils.GlobalVariables;

/**
 * Created by Arnaud on 28/04/2016.
 */
public class ChoiceActivity extends ParentActivity
{
    private RelativeLayout relativeLayoutSport;
    private RelativeLayout relativeLayoutSouthpark;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        setCustomActionBar();

        relativeLayoutSport = (RelativeLayout) findViewById(R.id.relativeLayoutSport);
        relativeLayoutSport.setOnClickListener(sportsListener);
        relativeLayoutSouthpark = (RelativeLayout) findViewById(R.id.relativeLayoutSouthPark);
        relativeLayoutSouthpark.setOnClickListener(southparkListener);
    }

    public View.OnClickListener sportsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            GlobalVariables.getsInstance().setKlassName("Sport");

            DataDownloadTask dlTask = new DataDownloadTask();
            dlTask.execute();
        }
    };

    public View.OnClickListener southparkListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            GlobalVariables.getsInstance().setKlassName("Southpark");

            DataDownloadTask dlTask = new DataDownloadTask();
            dlTask.execute();
        }
    };

    class DataDownloadTask extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params)
        {
            //Loading Sports
            PsEntities psEntities = new PsEntities();
            psEntities.getAllEntities();

            //Loading Questions
            PsQuestions psQuestions = new PsQuestions();
            psQuestions.getAllQuestions();

            //Loading Answers
            PsAnswers psAnswers = new PsAnswers();
            psAnswers.getAllAnswers();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
            startActivity(intent);

            return true;
        }
    }
}
