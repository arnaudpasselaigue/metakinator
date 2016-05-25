package com.ia.android.akinasport.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.ia.android.akinasport.R;
import com.ia.android.akinasport.customviews.AkinasportTextViewBig;
import com.ia.android.akinasport.services.PsAnswers;
import com.ia.android.akinasport.services.PsQuestions;
import com.ia.android.akinasport.services.PsEntities;

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
        YoYo.with(Techniques.FadeInDown).duration(1500).playOn(imageViewLoader);

        textViewLoader = (AkinasportTextViewBig) findViewById(R.id.textViewNameLoader);
        YoYo.with(Techniques.FadeInDown).duration(1500).playOn(textViewLoader);

        WaitingTask dlTask = new WaitingTask();
        dlTask.execute();
    }

    class WaitingTask extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params)
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(getApplicationContext(), ChoiceActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
            startActivity(intent);
            return true;
        }
    }
}
