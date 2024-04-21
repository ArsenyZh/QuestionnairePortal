package com.project.Questionnaire.portal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EditInfoDto {
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
