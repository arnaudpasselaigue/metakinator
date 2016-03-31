package com.ia.android.akinasport.services;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ia.android.akinasport.utils.GlobalVariables;

import org.json.JSONArray;

/**
 * Created by Arnaud on 31/03/2016.
 */
public class PsAnswers extends PsAuthentification
{
    public void getAllAnswers()
    {
        final String requestUri = this.getUri() + "/answers.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(requestUri, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response)
            {
                Log.d("getAllAnswers()", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        GlobalVariables.getsInstance().getRequestQueue().add(jsonArrayRequest);
    }
}
