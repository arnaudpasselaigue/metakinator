package com.ia.android.akinasport.utils;

import android.graphics.AvoidXfermode;
import android.util.Pair;

import com.ia.android.akinasport.customlisteners.OnQuestionsListener;
import com.ia.android.akinasport.models.Answer;
import com.ia.android.akinasport.models.Question;
import com.ia.android.akinasport.models.Sport;
import com.ia.android.akinasport.services.PsQuestions;

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
        HashMap<Integer, Sport> sports = GlobalVariables.getsInstance().getModelManager().getSports();
        Question question = GlobalVariables.getsInstance().getModelManager().getQuestion(questionId);

        for (Map.Entry<Integer, Sport> sport : sports.entrySet())
        {
            Answer correctAnswer = GlobalVariables.getsInstance().getModelManager().getAnswersFromQuestionAndSport(questionId, sport.getValue().getId());

            int correctAns = correctAnswer.getResponse() - 1;
            int score = scoreMatrice[correctAns][userAnswer - 1];
            sport.getValue().setScore(sport.getValue().getScore() + score);
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
