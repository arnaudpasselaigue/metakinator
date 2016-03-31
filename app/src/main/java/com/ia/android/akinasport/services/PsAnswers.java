package com.ia.android.akinasport.services;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ia.android.akinasport.models.Answer;
import com.ia.android.akinasport.utils.GlobalVariables;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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
                try
                {
                    GlobalVariables.getsInstance().setListAnswers(answersFromJSON(response));
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

    public ArrayList<Answer> answersFromJSON(JSONArray array) throws JSONException
    {
        ArrayList<Answer> answers = new ArrayList<>();

        for (int i = 0; i < array.length(); i++)
        {
            JSONObject o = array.getJSONObject(i);
            Answer answer = new Answer();

            answer.setId(o.getInt("id"));
            answer.setSport_id(o.getInt("sport_id"));
            answer.setQuestions_id(o.getInt("question_id"));

            if (o.getString("answer").equals("yes"))
                answer.setResponse(true);
            else
                answer.setResponse(false);

            answers.add(answer);
        }
        return answers;
    }
}
