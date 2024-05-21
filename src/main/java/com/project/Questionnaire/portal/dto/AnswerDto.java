package com.project.Questionnaire.portal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerDto {
    private String answer;
    private Long fieldId;
    private Long responseId;
}
