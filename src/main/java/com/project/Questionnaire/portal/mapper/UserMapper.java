package com.project.Questionnaire.portal.mapper;

import com.project.Questionnaire.portal.dto.UserDto;
import com.project.Questionnaire.portal.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser (UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());

        return user;
    }

    public UserDto toUserDto (User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhoneNumber(user.getPhoneNumber());

        return userDto;
    }
}
