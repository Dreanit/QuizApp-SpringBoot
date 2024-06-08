package com.dreanit.quizapp.controller;

import com.dreanit.quizapp.model.Question;
import com.dreanit.quizapp.model.QuestionWrapper;
import com.dreanit.quizapp.model.Response;
import com.dreanit.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses) {
        return quizService.calculateResult(id,responses);
    }
}
