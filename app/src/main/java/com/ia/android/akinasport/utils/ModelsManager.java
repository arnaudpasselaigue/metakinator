package com.ia.android.akinasport.utils;

import com.ia.android.akinasport.models.Answer;
import com.ia.android.akinasport.models.Question;
import com.ia.android.akinasport.models.Sport;

import java.util.HashMap;

/**
 * Created by Aschen on 31/03/2016.
 */
public class ModelsManager
{
    private HashMap<Integer, Answer> m_answers = new HashMap<>();
    private HashMap<Integer, Question> m_questions = new HashMap<>();
    private HashMap<Integer, Sport> m_sports = new HashMap<>();

    public ModelsManager()
    {

    }

    public void setAnswers(HashMap<Integer, Answer> answers) {m_answers = answers;}
    public HashMap<Integer, Answer> getAnswers() {return m_answers;}
    public Answer getAnswer(Integer id) {return m_answers.get(id);}
    public void putAnswer(Answer answer) {m_answers.put(answer.getId(), answer);}

    public void setQuestions(HashMap<Integer, Question> questions) {m_questions = questions;}
    public HashMap<Integer, Question> getQuestions() {return m_questions;}
    public Question getQuestion(Integer id) {return m_questions.get(id);}
    public void putQuestion(Question question) {m_questions.put(question.getId(), question);}

    public void setSports(HashMap<Integer, Sport> sports) {m_sports = sports;}
    public HashMap<Integer, Sport> getSports() {return m_sports;}
    public Sport getSport(Integer id) {return m_sports.get(id);}
    public void putSport(Sport sport) {m_sports.put(sport.getId(), sport);}
}
