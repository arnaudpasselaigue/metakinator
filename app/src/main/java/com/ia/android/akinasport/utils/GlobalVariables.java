package com.ia.android.akinasport.utils;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Arnaud on 31/03/2016.
 */
public class GlobalVariables extends Application
{
    private RequestQueue requestQueue;

    private String klassName;

    private boolean isFirstConnexion = true;
    private boolean inDevMode = true;

    private int firstQuestion;
    private int actualQuestion;

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

    public int getActualQuestion() {return actualQuestion;}
    public void setActualQuestion(int actualQuestion) {this.actualQuestion = actualQuestion;}

    public String getKlassName() {return klassName;}
    public void setKlassName(String klassName) {this.klassName = klassName;}
}

