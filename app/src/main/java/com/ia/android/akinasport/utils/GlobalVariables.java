package com.ia.android.akinasport.utils;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ia.android.akinasport.models.Answer;
import com.ia.android.akinasport.models.Question;
import com.ia.android.akinasport.models.Sport;

import java.util.ArrayList;

/**
 * Created by Arnaud on 31/03/2016.
 */
public class GlobalVariables extends Application
{
    private RequestQueue requestQueue;

    private boolean isFirstConnexion = false;
    private boolean inDevMode = true;

    private int firstQuestion;

    private ModelsManager modelManager = new ModelsManager();

    private static GlobalVariables sInstance;

    @Override
    public void onCreate()
    {
        super.onCreate();

        init();
    }

    public void init()
    {
        GlobalVariables.setsInstance(this);
    }

    public RequestQueue getRequestQueue()
    {
        if (requestQueue == null)
            this.requestQueue = Volley.newRequestQueue(getApplicationContext());
        return requestQueue;
    }
    public void setRequestQueue(RequestQueue requestQueue) {this.requestQueue = requestQueue;}

    public boolean isFirstConnexion() {return isFirstConnexion;}
    public void setIsFirstConnexion(boolean isFirstConnexion) {this.isFirstConnexion = isFirstConnexion;}

    public boolean isInDevMode() {return inDevMode;}
    public void setInDevMode(boolean inDevMode) {this.inDevMode = inDevMode;}

    public static GlobalVariables getsInstance()
    {
        if (sInstance == null)
            sInstance = new GlobalVariables();
        return sInstance;
    }
    public static void setsInstance(GlobalVariables sInstance) {GlobalVariables.sInstance = sInstance;}

    public ModelsManager getModelManager() {return modelManager;}

    public void setFirstConnexion(boolean firstConnexion) {isFirstConnexion = firstConnexion;}

    public int getFirstQuestion() {return firstQuestion;}
    public void setFirstQuestion(int firstQuestion) {this.firstQuestion = firstQuestion;}
}

