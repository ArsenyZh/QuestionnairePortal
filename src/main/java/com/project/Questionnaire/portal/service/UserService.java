package com.project.Questionnaire.portal.service;

import com.project.Questionnaire.portal.entity.User;
import com.project.Questionnaire.portal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User registrateUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User registeredUser = userRepository.save(user);

        return registeredUser;
    }

    public User editUserInfo(User user, User updatedUser) {
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        userRepository.save(user);

        return user;
    }

    public User changeUserPassword(User user, String newPassword) {
        user.setPassword(newPassword);
        userRepository.save(user);

        return user;
    }

    public User findByEmail(String email) {
        User foundUser = userRepository.findUserByEmail(email);

        return foundUser;
    }
}
