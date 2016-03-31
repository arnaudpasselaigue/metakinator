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
import org.json.JSONException;
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
            public void onResponse(JSONArray response)
            {
                Log.d("getAllEntities()", response.toString());
                try
                {
                    GlobalVariables.getsInstance().setListSports(sportsFromJSON(response));
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        GlobalVariables.getsInstance().getRequestQueue().add(jsonArrayRequest);
    }

    public ArrayList<Sport> sportsFromJSON(JSONArray response) throws JSONException
    {
        ArrayList<Sport> listSport = new ArrayList<>();

        for (int i = 0; response.getJSONObject(i) != null; i++)
        {
            JSONObject o = response.getJSONObject(i);
            Sport sport = new Sport();
            sport.setId(o.getInt("id"));
            sport.setName(o.getString("name"));
            JSONArray array = o.getJSONArray("answers");
            sport.setAnswers(answersFromJSON(array));
        }
        return listSport;
    }

    public ArrayList<Integer> answersFromJSON(JSONArray array) throws JSONException
    {
        ArrayList<Integer> answers = new ArrayList<>();

        for (int i = 0; array.get(i) != null; i++)
        {
            answers.add(array.getInt(i));
        }
        return answers;
    }
}
