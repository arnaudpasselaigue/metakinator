package com.ia.android.akinasport.utils;

import com.ia.android.akinasport.models.Answer;
import com.ia.android.akinasport.models.Entity;
import com.ia.android.akinasport.models.Question;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aschen on 31/03/2016.
 */
public class ModelsManager
{
    private HashMap<Integer, Answer> m_answers = new HashMap<>();
    private HashMap<Integer, Question> m_questions = new HashMap<>();
    private HashMap<Integer, Entity> m_entities = new HashMap<>();

    public ModelsManager()
    {

    }

    public Answer getAnswersFromQuestionAndEntity(int id_question, int id_sport)
    {
        for (Map.Entry<Integer, Answer> answer : m_answers.entrySet())
        {
            if (answer.getValue().getEntity_id() == id_sport && answer.getValue().getQuestions_id() == id_question)
                return answer.getValue();
        }

        return null;
    }

    public void setAnswers(HashMap<Integer, Answer> answers) {m_answers = answers;}
    public HashMap<Integer, Answer> getAnswers() {return m_answers;}
    public Answer getAnswer(Integer id) {return m_answers.get(id);}
    public void putAnswer(Answer answer) {m_answers.put(answer.getId(), answer);}

    public void setQuestions(HashMap<Integer, Question> questions) {m_questions = questions;}
    public HashMap<Integer, Question> getQuestions() {return m_questions;}

    public Question getQuestion(Integer id) {return m_questions.get(id);}
    public void putQuestion(Question question) {m_questions.put(question.getId(), question);}

    public HashMap<Integer, Entity> getSports() {return m_entities;}
    public void putSport(Entity entity)
    {
        m_entities.put(entity.getId(), entity);
    }
}
