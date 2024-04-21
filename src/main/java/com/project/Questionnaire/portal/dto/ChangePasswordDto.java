package com.project.Questionnaire.portal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangePasswordDto {
    private String password;
    private String newPassword;
    private String confNewPassword;
}
