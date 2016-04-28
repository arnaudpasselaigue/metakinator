package com.ia.android.akinasport.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ia.android.akinasport.R;
import com.ia.android.akinasport.customviews.AkinasportTextView;
import com.ia.android.akinasport.customviews.AkinasportTextViewBig;

/**
 * Created by Arnaud on 28/04/2016.
 */
public class FinalActivity extends ParentActivity
{
    private Button replayButton;
    private AkinasportTextView questionsWinnerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        setCustomActionBar();

        replayButton = (Button) findViewById(R.id.buttonReplay);
        replayButton.setOnClickListener(replayListener);

        questionsWinnerTextView = (AkinasportTextView) findViewById(R.id.textViewWinnerQuestion);

        String winner;
        Bundle extras = getIntent().getExtras();

        if (extras != null)
            winner = "Vous pensez à " +  extras.getString("WinnerEntity") + ".";
        else
            winner = "Un problème est survenue.";

        questionsWinnerTextView.setText(winner);
    }

    public View.OnClickListener replayListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            Intent main = new Intent(getApplicationContext(), MainActivity.class);
            main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
            startActivity(main);
        }
    };
}
