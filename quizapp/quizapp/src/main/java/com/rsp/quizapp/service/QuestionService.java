package com.rsp.quizapp.service;

import com.rsp.quizapp.Question;
import com.rsp.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Success. Added a new question.";
    }

    public String updateQuestion(Integer id, Question question) {
        Question q = questionDao.findQuestionById(id);
        q.setCategory(question.getCategory());
        q.setDifficultyLevel(question.getDifficultyLevel());
        q.setOption1(question.getOption1());
        q.setOption2(question.getOption2());
        q.setOption3(question.getOption3());
        q.setOption4(question.getOption4());
        q.setQuestionTitle(question.getQuestionTitle());
        q.setCorrectAnswer(question.getCorrectAnswer());
        questionDao.save(q);
        return "Updated "+id;
    }

    public String deleteQuestion(Integer id) {
        questionDao.deleteById(id);
        return "Deleted "+id;
    }
}
