package com.thedigibromeetsspark.personality_test_service.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thedigibromeetsspark.personality_test_service.domain.Question;
import com.thedigibromeetsspark.personality_test_service.repositories.QuestionRepository;
import com.thedigibromeetsspark.personality_test_service.web.model.CategoryEnum;
import com.thedigibromeetsspark.personality_test_service.web.model.QuestionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuestionController.class)
@ComponentScan(basePackages = "com.thedigibromeetsspark.personality_test_service.mapper")

class QuestionControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    QuestionRepository questionRepository;

    @Test
    void getBeerById() throws Exception {
        given(questionRepository.findById(any())).willReturn(Optional.of(Question.builder().build()));
        mockMvc.perform(get("/api/v1/question/{questionId}",UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    @Test
    void saveNewBeer() throws Exception {
        QuestionDto beerDto = getValidQuestionDto();
        String questionDtoJson = objectMapper.writeValueAsString(QuestionDto.class);
        //ConstrainedFields fields = new ConstrainedFields(QuestionDto.class);
        mockMvc.perform(post("/api/v1/question/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(questionDtoJson))
                .andExpect(status().isCreated());
    }
    QuestionDto getValidQuestionDto(){
        return QuestionDto.builder().
                question("What is your gender?")
                .category(CategoryEnum.hard_fact)
                .type("Single_Choiche")
                .options("Male").build();
    }


}





