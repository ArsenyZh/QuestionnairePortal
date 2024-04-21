package com.project.Questionnaire.portal.controller;

import com.project.Questionnaire.portal.dto.LoginDto;
import com.project.Questionnaire.portal.dto.SignupDto;
import com.project.Questionnaire.portal.dto.UserDto;
import com.project.Questionnaire.portal.entity.User;
import com.project.Questionnaire.portal.mapper.SignUpMapper;
import com.project.Questionnaire.portal.mapper.UserMapper;
import com.project.Questionnaire.portal.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthentificationController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SignUpMapper signUpMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("user/log_in")
    public UserDto logInUser(@RequestBody LoginDto loginDto) {
        User user = userService.findByEmail(loginDto.getEmail());

        if (user != null && bCryptPasswordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return userMapper.toUserDto(user);
        } else {
            return null;
        }
    }

    @PostMapping("/user/sign_up")
    public UserDto signUpUser(@RequestBody SignupDto signupDto) {
        if (signupDto.getPassword() == signupDto.getConfPassword()) {
            User user = userService.registrateUser(signUpMapper.toUser(signupDto));

            return userMapper.toUserDto(user);
        } else {
            return null;
        }
    }
}
