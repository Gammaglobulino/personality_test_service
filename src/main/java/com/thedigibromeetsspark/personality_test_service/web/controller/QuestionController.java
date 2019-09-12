package com.thedigibromeetsspark.personality_test_service.web.controller;

import com.thedigibromeetsspark.personality_test_service.mapper.QuestionMapper;
import com.thedigibromeetsspark.personality_test_service.repositories.QuestionRepository;
import com.thedigibromeetsspark.personality_test_service.web.model.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/question")
@RestController
public class QuestionController {
    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable("questionId") UUID questionId){
        return new ResponseEntity<>(questionMapper.questionToQuestionDto(questionRepository.findById(questionId).get()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody QuestionDto questionDto){
        questionRepository.save(questionMapper.questionDtoToQuestion(questionDto));
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
