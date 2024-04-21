package com.project.Questionnaire.portal.mapper;

import com.project.Questionnaire.portal.dto.SignupDto;
import com.project.Questionnaire.portal.entity.User;
import org.springframework.stereotype.Component;

@Component
public class SignUpMapper {
    public User toUser(SignupDto signupDto) {
        User user = new User();
        user.setEmail(signupDto.getEmail());
        user.setPassword(signupDto.getPassword());
        user.setFirstName(signupDto.getFirstName());
        user.setLastName(signupDto.getLastName());
        user.setPhoneNumber(signupDto.getPhoneNumber());

        return user;
    }
}
