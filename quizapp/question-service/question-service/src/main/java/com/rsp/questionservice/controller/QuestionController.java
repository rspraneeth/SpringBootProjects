package com.rsp.questionservice.controller;
import com.rsp.questionservice.model.Answer;
import com.rsp.questionservice.model.Question;
import com.rsp.questionservice.model.QuestionWrapper;
import com.rsp.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable Integer id, @RequestBody Question question){
        return questionService.updateQuestion(id, question);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsFromQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions){
        return questionService.getQuestionsFromQuiz(categoryName, numQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Answer> answers){
        return questionService.getScore(answers);
    }
}
