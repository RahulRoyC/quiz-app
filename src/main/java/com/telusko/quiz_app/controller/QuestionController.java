package com.telusko.quiz_app.controller;

import com.telusko.quiz_app.model.Question;
import com.telusko.quiz_app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("allques")
    public ResponseEntity<List<Question>> getallquestions(){
        return questionService.getallQues();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getallbyCategory(@PathVariable String category){
        return questionService.getQuesnByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity <String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }


}