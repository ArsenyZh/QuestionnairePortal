package com.project.Questionnaire.portal.mapper;

import com.project.Questionnaire.portal.dto.EditInfoDto;
import com.project.Questionnaire.portal.dto.SignupDto;
import com.project.Questionnaire.portal.entity.User;
import org.springframework.stereotype.Component;

@Component
public class EditInfoMapper {
    public User toUser(EditInfoDto editInfoDto) {
        User user = new User();
        user.setEmail(editInfoDto.getEmail());
        user.setPassword(null);
        user.setFirstName(editInfoDto.getFirstName());
        user.setLastName(editInfoDto.getLastName());
        user.setPhoneNumber(editInfoDto.getPhoneNumber());

        return user;
    }
}
