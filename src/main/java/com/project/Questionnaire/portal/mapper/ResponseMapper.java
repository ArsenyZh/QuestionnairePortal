package com.project.Questionnaire.portal.mapper;

import com.project.Questionnaire.portal.dto.AnswerDto;
import com.project.Questionnaire.portal.dto.ResponseDto;
import com.project.Questionnaire.portal.entity.Answer;
import com.project.Questionnaire.portal.entity.Response;
import com.project.Questionnaire.portal.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResponseMapper {
    @Autowired
    private AnswerRepository answerRepository;

    public Response toResponse(ResponseDto responseDto) {
        Response response = new Response();
        List<Answer> answerList = new ArrayList<>();
        for (AnswerDto answerDto : responseDto.getAnswerList()) {
            Answer answer = answerRepository.findById(answerDto.getId()).orElseThrow();
            answer.setAnswer(answerDto.getAnswer());
            answerRepository.save(answer);
            answerList.add(answer);
        }
        response.setAnswerList(answerList);

        return response;
    }

    public ResponseDto toResponseDto(Response response) {
        ResponseDto responseDto = new ResponseDto();
        List<AnswerDto> answerDtoList = new ArrayList<>();
        for (Answer answer : response.getAnswerList()) {
            AnswerDto answerDto = new AnswerDto();
            answerDto.setId(answer.getId());
            answerDto.setAnswer(answer.getAnswer());
            answerDtoList.add(answerDto);
        }
        responseDto.setAnswerList(answerDtoList);

        return responseDto;
    }
}