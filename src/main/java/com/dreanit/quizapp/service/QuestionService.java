package com.dreanit.quizapp.service;

import com.dreanit.quizapp.QuestionDao;
import com.dreanit.quizapp.model.Question;
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
        return  questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        if (question.getDifficultyLevel() == null) {
            throw new IllegalArgumentException("Difficulty level must not be null");
        }
         questionDao.save(question);
        return  "success";
    }
}
