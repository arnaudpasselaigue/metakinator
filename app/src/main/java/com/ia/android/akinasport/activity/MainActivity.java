package com.ia.android.akinasport.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ia.android.akinasport.R;
import com.ia.android.akinasport.models.Sport;
import com.ia.android.akinasport.utils.GlobalVariables;
import com.ia.android.akinasport.utils.ModelsManager;

import java.util.ArrayList;

public class MainActivity extends ParentActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List
        Sport sport = GlobalVariables.getsInstance().getModelManager().getSport(1);
        int test = sport.getId();
    }
}
