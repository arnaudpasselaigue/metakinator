package com.ia.android.akinasport.utils;

import android.util.Log;
import android.util.Pair;

import com.ia.android.akinasport.models.Answer;
import com.ia.android.akinasport.models.Question;
import com.ia.android.akinasport.models.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arnaud on 14/04/2016.
 */
public class Daneel
{
    private ArrayList<Pair<Question, Integer>> questionsAnswers = new ArrayList<>();
    private ArrayList<Integer> questionsAlreadyAsked = new ArrayList<>();

    private int[][] scoreMatrice =
            {
              {  3,  1, -1, -2, -3 },
              {  1,  3,  1, -1, -2 },
              { -1,  1,  3,  1,  1 },
              { -2, -1,  1,  3,  1 },
              { -3, -2, -1,  1,  3 },
            };

    public Daneel()
    {

    }

    public void applyScore(int questionId, int userAnswer)
    {
        HashMap<Integer, Entity> entities = GlobalVariables.getsInstance().getModelManager().getSports();
        Question question = GlobalVariables.getsInstance().getModelManager().getQuestion(questionId);

        for (Map.Entry<Integer, Entity> entity : entities.entrySet())
        {
            Answer correctAnswer = GlobalVariables.getsInstance().getModelManager().getAnswersFromQuestionAndEntity(questionId, entity.getValue().getId());

            int correctAns = correctAnswer.getResponse() - 1;
            int score = scoreMatrice[correctAns][userAnswer - 1];
            if (entity.getValue().getName().equals("Basketball"))
            {
                Log.i("CorrectAnswer", String.valueOf(correctAns));
                Log.i("UserAnswer", String.valueOf(userAnswer));
            }
            entity.getValue().setScore(entity.getValue().getScore() + score);
        }

        questionsAnswers.add(new Pair<>(question, userAnswer));
        questionsAlreadyAsked.add(questionId);
    }

    public int[][] getScoreMatrice() {return scoreMatrice;}
    public void setScoreMatrice(int[][] scoreMatrice) {this.scoreMatrice = scoreMatrice;}

    public ArrayList<Pair<Question, Integer>> getQuestionsAnswers() {return questionsAnswers;}
    public void setQuestionsAnswers(ArrayList<Pair<Question, Integer>> questionsAnswers) {this.questionsAnswers = questionsAnswers;}

    public ArrayList<Integer> getQuestionsAlreadyAsked() {return questionsAlreadyAsked;}
    public void setQuestionsAlreadyAsked(ArrayList<Integer> questionsAlreadyAsked) {this.questionsAlreadyAsked = questionsAlreadyAsked;}
}
