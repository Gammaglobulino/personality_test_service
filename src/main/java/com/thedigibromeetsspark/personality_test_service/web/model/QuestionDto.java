package com.thedigibromeetsspark.personality_test_service.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDto {
    private UUID uuid;
    private String question;
    private CategoryEnum category;
    private String type;
    private String options;

}
