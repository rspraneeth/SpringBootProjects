package com.rsp.quizservice.service;

import com.rsp.quizservice.dao.QuizDao;
import com.rsp.quizservice.feign.QuizInterface;
import com.rsp.quizservice.model.Answer;
import com.rsp.quizservice.model.QuestionWrapper;
import com.rsp.quizservice.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        try {
            // call the 'generate' url of question service - RestTemplate http://localhost:8080/question/generate
            List<Integer> questions = quizInterface.getQuestionsFromQuiz(category, numQ).getBody();
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestionsIds(questions);
            quiz.setCategory(category);
            quizDao.save(quiz);

            return new ResponseEntity<>("Quiz created", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>("Quiz not created", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        try {
            Quiz quiz = quizDao.findById(id).get();
            List<Integer> questionIds = quiz.getQuestionsIds();
            ResponseEntity<List<QuestionWrapper>> questions =  quizInterface.getQuestionsFromId(questionIds);

            return questions;
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Answer> answers) {
        try {
            ResponseEntity<Integer> score = quizInterface.getScore(answers);
            return score;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
