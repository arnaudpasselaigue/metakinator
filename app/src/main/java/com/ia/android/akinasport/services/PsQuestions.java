package com.ia.android.akinasport.services;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ia.android.akinasport.customlisteners.OnQuestionsListener;
import com.ia.android.akinasport.models.Question;
import com.ia.android.akinasport.servicesinterfaces.iQuestions;
import com.ia.android.akinasport.utils.GlobalVariables;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Arnaud on 31/03/2016.
 */
public class PsQuestions extends PsAuthentification implements iQuestions
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
                    questionsFromJSON(response);
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

    public void getFirstQuestion(final OnQuestionsListener listener)
    {
        String uri = this.getUri() + "/questions/first_question";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, uri, null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    listener.OnResponse(response.getInt("best_question"));
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

    public void getNextQuestion(int[] id_questions, final OnQuestionsListener listener)
    {
        String uri = this.getUri() + "/questions/best_question";
        JSONObject jsonBody = new JSONObject();

        try {
            jsonBody.put("questions_id", id_questions);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, uri, jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    listener.OnResponse(response.getInt("best_question"));
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        GlobalVariables.getsInstance().getRequestQueue().add(request);
    }

    public void questionsFromJSON(JSONArray response) throws JSONException
    {
        ArrayList<Question> listQuestions = new ArrayList<>();

        for (int i = 0; i < response.length(); i++)
        {
            JSONObject o = response.getJSONObject(i);
            Question question = new Question();
            question.setId(o.getInt("id"));
            question.setTitle(o.getString("title"));

            GlobalVariables.getsInstance().getModelManager().putQuestion(question);
        }
    }
}
