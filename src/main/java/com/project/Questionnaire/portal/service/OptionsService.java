package com.project.Questionnaire.portal.service;

import com.project.Questionnaire.portal.entity.Answer;
import com.project.Questionnaire.portal.entity.Options;
import com.project.Questionnaire.portal.repository.AnswerRepository;
import com.project.Questionnaire.portal.repository.OptionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OptionsService {
    @Autowired
    private OptionsRepository optionsRepository;

    public Options save(Options options) {
        Options createdOptions = optionsRepository.save(options);

        return createdOptions;
    }

    public void update(List<Options> options, List<Options> updatedOptions) {
        for (int i = 0; i < updatedOptions.size(); i++) {
            options.set(i, updatedOptions.get(i));
            if (options.size() >= i) {
                options.add(updatedOptions.get(i));
            }
        }
    }
}
