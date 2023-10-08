package com.rsp.questionservice.service;

import com.rsp.questionservice.dao.QuestionDao;
import com.rsp.questionservice.model.Answer;
import com.rsp.questionservice.model.Question;
import com.rsp.questionservice.model.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("Success. Added a new question.", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Cannot add incomplete Question", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestion(Integer id, Question question) {
        try {
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
            return new ResponseEntity<>("Updated "+id, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Cant update "+id, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        if (questionDao.findQuestionById(id) != null) {
            try {
                questionDao.deleteById(id);
                return new ResponseEntity<>("Deleted "+id, HttpStatus.OK);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return new ResponseEntity<>("Cant delete "+id, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Integer>> getQuestionsFromQuiz(String categoryName, Integer numQuestions) {
        List<Integer> questions = questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        for (Integer id: questionIds){
            questions.add(questionDao.findById(id).get());
        }

        for (Question q: questions){
            QuestionWrapper qw = new QuestionWrapper
                    (q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            wrappers.add(qw);

        }
        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Answer> answers) {
        int right = 0;
        for (Answer ans: answers){
            Question question = questionDao.findById(ans.getId()).get();
            if (ans.getResponse().equals(question.getCorrectAnswer())) right++;
        }

        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
