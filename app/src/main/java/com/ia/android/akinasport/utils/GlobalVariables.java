package com.ia.android.akinasport.utils;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
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

    private ArrayList<Sport> listSports = new ArrayList<>();

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
        this.requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public RequestQueue getRequestQueue() {return requestQueue;}
    public void setRequestQueue(RequestQueue requestQueue) {this.requestQueue = requestQueue;}

    public boolean isFirstConnexion() {return isFirstConnexion;}
    public void setIsFirstConnexion(boolean isFirstConnexion) {this.isFirstConnexion = isFirstConnexion;}

    public boolean isInDevMode() {return inDevMode;}
    public void setInDevMode(boolean inDevMode) {this.inDevMode = inDevMode;}

    public ArrayList<Sport> getListSports() {return listSports;}
    public void setListSports(ArrayList<Sport> listSports) {this.listSports = listSports;}

    public static GlobalVariables getsInstance() {return sInstance;}
    public static void setsInstance(GlobalVariables sInstance) {GlobalVariables.sInstance = sInstance;}
}
