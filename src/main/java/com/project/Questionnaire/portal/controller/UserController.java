package com.project.Questionnaire.portal.controller;

import com.project.Questionnaire.portal.dto.ChangePasswordDto;
import com.project.Questionnaire.portal.dto.EditInfoDto;
import com.project.Questionnaire.portal.dto.UserDto;
import com.project.Questionnaire.portal.entity.User;
import com.project.Questionnaire.portal.mapper.EditInfoMapper;
import com.project.Questionnaire.portal.mapper.UserMapper;
import com.project.Questionnaire.portal.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EditInfoMapper editInfoMapper;

    @PutMapping("user/edit_info/{id}")
    public UserDto editInfo(@RequestBody EditInfoDto editInfoDto, @PathVariable("id") User user) {
        userService.editUserInfo(user, editInfoMapper.toUser(editInfoDto));

        return userMapper.toUserDto(user);
    }

    @PutMapping("user/change_pas/{id}")
    public UserDto changePassword(@RequestBody ChangePasswordDto changePasswordDto, @PathVariable("id") User user) {
        if (bCryptPasswordEncoder.matches(changePasswordDto.getPassword(), user.getPassword()) &&
                changePasswordDto.getNewPassword() == changePasswordDto.getConfNewPassword()) {
            userService.changeUserPassword(user, changePasswordDto.getNewPassword());

            return userMapper.toUserDto(user);
        } else {
            return null;
        }
    }
}
