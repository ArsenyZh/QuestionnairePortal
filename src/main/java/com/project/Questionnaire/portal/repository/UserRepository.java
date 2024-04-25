package com.project.Questionnaire.portal.repository;

import com.project.Questionnaire.portal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE email = :login")
    User getUserByLogin(String login);
}
