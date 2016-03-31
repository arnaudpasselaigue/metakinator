package com.ia.android.akinasport.services;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ia.android.akinasport.models.Question;
import com.ia.android.akinasport.utils.GlobalVariables;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Arnaud on 31/03/2016.
 */
public class PsQuestions extends PsAuthentification
{
    public void getAllQuestions()
    {
        final String requestUri = this.getUri() + "/questions.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(requestUri, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response)
            {
                Log.d("getAllQuestions()", response.toString());
                try
                {
                    GlobalVariables.getsInstance().setListQuestions(questionsFromJSON(response));
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

    public ArrayList<Question> questionsFromJSON(JSONArray response) throws JSONException
    {
        ArrayList<Question> listQuestions = new ArrayList<>();

        for (int i = 0; i < response.length(); i++)
        {
            JSONObject o = response.getJSONObject(i);
            Question question = new Question();
            question.setId(o.getInt("id"));
            question.setTitle(o.getString("title"));

            listQuestions.add(question);
        }

        return listQuestions;
    }
}
