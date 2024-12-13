package com.telusko.quiz_app.service;

import com.telusko.quiz_app.model.Question;
import com.telusko.quiz_app.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getallQues() {
       try{
           return new ResponseEntity<> (questionRepository.findAll(), HttpStatus.OK);
    }catch (Exception e){
           e.printStackTrace();
       }
        return new ResponseEntity<> (new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity <List<Question>> getQuesnByCategory(String category) {
       try {
           return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
       }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity <String> addQuestion(Question question) {
            try {
                questionRepository.save(question);
                return new ResponseEntity<>( "success",HttpStatus.CREATED);
            }catch (Exception e){
                e.printStackTrace();
            }
            return new ResponseEntity<>("Question Adding Failed", HttpStatus.BAD_REQUEST);
    }
}

