package com.ia.android.akinasport.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.ia.android.akinasport.R;
import com.ia.android.akinasport.customviews.AkinasportTextView;
import com.ia.android.akinasport.customviews.AkinasportTextViewBig;
import com.ia.android.akinasport.models.Sport;
import com.ia.android.akinasport.services.PsAnswers;
import com.ia.android.akinasport.services.PsQuestions;
import com.ia.android.akinasport.services.PsSports;
import com.ia.android.akinasport.utils.GlobalVariables;

import java.util.ArrayList;

/**
 * Created by Arnaud on 17/03/2016.
 */
public class LoaderActivity extends ParentActivity
{
    private AkinasportTextViewBig textViewLoader;
    private ImageView imageViewLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        imageViewLoader = (ImageView) findViewById(R.id.imageViewIconLoader);
        YoYo.with(Techniques.ZoomIn).duration(1500).playOn(imageViewLoader);

        textViewLoader = (AkinasportTextViewBig) findViewById(R.id.textViewNameLoader);
        YoYo.with(Techniques.ZoomIn).duration(1500).playOn(textViewLoader);

        DataDownloadTask dlTask = new DataDownloadTask();
        dlTask.execute();
    }

    class DataDownloadTask extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params)
        {
            //Loading Sports
            PsSports psSports = new PsSports();
            psSports.getAllEntities();

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

            Intent main = new Intent(getApplicationContext(), MainActivity.class);
            main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
            startActivity(main);

            return true;
        }
    }
}
