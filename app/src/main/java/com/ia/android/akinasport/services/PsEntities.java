package com.ia.android.akinasport.services;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ia.android.akinasport.customlisteners.OnEntitiesListener;
import com.ia.android.akinasport.models.Entity;
import com.ia.android.akinasport.utils.Daneel;
import com.ia.android.akinasport.utils.GlobalVariables;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Arnaud on 31/03/2016.
 */
public class PsEntities extends PsAuthentification
{
    public void getAllEntities()
    {
        final String requestUri = uri + "/entities.json" + entity_class + GlobalVariables.getsInstance().getKlassName();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(requestUri, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response)
            {
                Log.d("getAllEntities()", response.toString());
                try
                {
                    entitiesFromJSON(response);
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

    public void entitiesFromJSON(JSONArray response) throws JSONException
    {
        for (int i = 0; i < response.length(); i++)
        {
            JSONObject o = response.getJSONObject(i);
            Entity entity = new Entity();
            entity.setId(o.getInt("id"));
            entity.setName(o.getString("name"));
            entity.setKlass(o.getString("klass"));
            JSONArray array = o.getJSONArray("answers");
            entity.setAnswers(answersFromJSON(array));

            GlobalVariables.getsInstance().getModelManager().putSport(entity);
        }
    }

    public ArrayList<Integer> answersFromJSON(JSONArray array) throws JSONException
    {
        ArrayList<Integer> answers = new ArrayList<>();

        for (int i = 0; i < array.length(); i++)
        {
            answers.add(array.getInt(i));
        }

        return answers;
    }

    public void getIfEntityAlreadyExist(String entity, final OnEntitiesListener listener)
    {
        final String requestUri = uri + "/entities/fuzzy_match.json" + entity_class + GlobalVariables.getsInstance().getKlassName();

        JSONObject jsonBody = new JSONObject();

        try {
            jsonBody.put("name", entity);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, requestUri, jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.has("best_match"))
                        listener.OnResponse(response.getString("best_match"));
                    else
                        listener.OnResponse(null);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        GlobalVariables.getsInstance().getRequestQueue().add(request);
    }

    public void sendEntity(Daneel daneel, String entity, final OnEntitiesListener listener)
    {
        final String requestUri = uri + "/entities/add_entity.json" + entity_class + GlobalVariables.getsInstance().getKlassName();

        JSONObject jsonBody = new JSONObject();

        try {
            jsonBody.put("entity_name", entity);
            jsonBody.put("questions", new JSONArray(daneel.getQuestionsAnswers()));
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, requestUri, jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                    listener.OnResponse(true);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        GlobalVariables.getsInstance().getRequestQueue().add(request);


    }
}
