package com.project.Questionnaire.portal.service;

import com.project.Questionnaire.portal.entity.Answer;
import com.project.Questionnaire.portal.repository.AnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@AllArgsConstructor
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public Answer addAnswer(Answer answer) {
        Answer createdAnswer = answerRepository.save(answer);

        return createdAnswer;
    }

    public Long getAnswerById(Long answerId) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new NotFoundException("Answer not found with ID: " + answerId));
        return answer.getId(); // Assuming the ID is of type Long
    }
}
