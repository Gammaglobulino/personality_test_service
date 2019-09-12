package com.thedigibromeetsspark.personality_test_service.mapper;

import com.thedigibromeetsspark.personality_test_service.domain.Question;
import com.thedigibromeetsspark.personality_test_service.web.model.QuestionDto;
import org.mapstruct.Mapper;

@Mapper
public interface QuestionMapper {
    QuestionDto questionToQuestionDto(Question question);
    Question questionDtoToQuestion(QuestionDto questionDto);
}
