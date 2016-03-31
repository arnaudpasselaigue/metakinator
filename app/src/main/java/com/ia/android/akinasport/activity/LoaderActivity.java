package com.ia.android.akinasport.activity;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ia.android.akinasport.R;
import com.ia.android.akinasport.services.PsSports;
import com.ia.android.akinasport.utils.GlobalVariables;

/**
 * Created by Arnaud on 17/03/2016.
 */
public class LoaderActivity extends ParentActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        init();
    }

    public void init()
    {
        PsSports psSports = new PsSports();

        psSports.getAllEntities();
    }
}
