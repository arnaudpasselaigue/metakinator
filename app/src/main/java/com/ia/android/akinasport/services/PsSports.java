package com.ia.android.akinasport.services;

import android.app.DownloadManager;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.ia.android.akinasport.models.Sport;
import com.ia.android.akinasport.utils.GlobalVariables;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Arnaud on 31/03/2016.
 */
public class PsSports extends PsAuthentification
{
    public void getAllEntities()
    {
        final String requestUri = this.getUri() + "/sports.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(requestUri, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                    Log.d("getAllEntities()", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        GlobalVariables.getsInstance().getRequestQueue().add(jsonArrayRequest);
    }

    public ArrayList<Sport> jsonToSport(JSONArray response)
    {
        ArrayList<Sport> listSport = new ArrayList<>();

        
        return listSport;
    }
}
