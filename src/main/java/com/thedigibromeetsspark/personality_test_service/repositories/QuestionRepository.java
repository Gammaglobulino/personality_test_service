package com.thedigibromeetsspark.personality_test_service.repositories;

import com.thedigibromeetsspark.personality_test_service.domain.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.UUID;

public interface QuestionRepository extends PagingAndSortingRepository <Question,UUID> {
}
