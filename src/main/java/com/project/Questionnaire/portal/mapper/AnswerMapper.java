package com.project.Questionnaire.portal.mapper;

import com.project.Questionnaire.portal.dto.AnswerDto;
import com.project.Questionnaire.portal.entity.Answer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnswerMapper {

    public List<AnswerDto> toAnswerDto(List<Answer> answerList) {
        List<AnswerDto> answerDtoList = new ArrayList<>();

        for (Answer answer : answerList) {
            AnswerDto answerDto = new AnswerDto();
            answerDto.setAnswer(answer.getAnswer());
            answerDto.setFieldId(answer.getField().getId());
            answerDtoList.add(answerDto);
        }

        return answerDtoList;
    }
}
