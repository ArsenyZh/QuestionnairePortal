package com.project.Questionnaire.portal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionsDto {
    private String option;
    private Long fieldId;

    public OptionsDto() {
    }

    public OptionsDto(String option) {
        this.option = option;
    }
}
