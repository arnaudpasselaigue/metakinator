package com.ia.android.akinasport.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.RequestQueue;
import com.ia.android.akinasport.R;
import com.ia.android.akinasport.utils.GlobalVariables;

/**
 * Created by Arnaud on 17/03/2016.
 */
public class ParentActivity extends AppCompatActivity
{
    protected int ANSWER_YES = 1;
    protected int ANSWER_PROBABLY_YES = 2;
    protected int ANSWER_DONT_KNOW = 3;
    protected int ANSWER_PROBABLY_NO = 4;
    protected int ANSWER_NO = 5;

    public void setCustomActionBar()
    {
        ActionBar bar = getSupportActionBar();

        if (bar != null) {
            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            bar.setDisplayShowHomeEnabled(false);
            bar.setDisplayShowCustomEnabled(true);
            bar.setDisplayShowTitleEnabled(false);
            bar.setElevation(0);
            bar.setCustomView(R.layout.akinasport_custom_actionbar);
            View v = bar.getCustomView();

            v.findViewById(R.id.imageViewActionBar).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent choice_activity = new Intent(getApplicationContext(), ChoiceActivity.class);
                    choice_activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    finish();
                    startActivity(choice_activity);
                }
            });

            Toolbar parent = (Toolbar) v.getParent();
            parent.setContentInsetsAbsolute(0, 0);
        }
    }
}
