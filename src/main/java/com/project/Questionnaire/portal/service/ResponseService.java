package com.project.Questionnaire.portal.service;

import com.project.Questionnaire.portal.entity.Answer;
import com.project.Questionnaire.portal.entity.Response;
import com.project.Questionnaire.portal.repository.ResponseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResponseService {
    @Autowired
    private ResponseRepository responseRepository;
    @Autowired
    private AnswerService answerService;

    public Response addResponse(Response response) {
        Response createdResponse = responseRepository.save(response);

        return createdResponse;
    }

    public Response findResponse(Long id) {
        Response findedResponse = responseRepository.findById(id).orElse(null);

        return findedResponse;
    }

    public List<Response> findAllResponses() {
        List<Response> responseList = responseRepository.findAll();

        return responseList;
    }
}
