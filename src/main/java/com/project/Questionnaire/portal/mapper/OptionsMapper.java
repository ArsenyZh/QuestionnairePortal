package com.project.Questionnaire.portal.mapper;

import com.project.Questionnaire.portal.dto.AnswerDto;
import com.project.Questionnaire.portal.dto.OptionsDto;
import com.project.Questionnaire.portal.entity.Answer;
import com.project.Questionnaire.portal.entity.Options;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OptionsMapper {
    public List<OptionsDto> toOptionsDto(List<Options> optionsList) {
        List<OptionsDto> optionsDtoList = new ArrayList<>();

        for (Options options : optionsList) {
            OptionsDto optionsDto = new OptionsDto();
            optionsDto.setOption(options.getOption());
            optionsDtoList.add(optionsDto);
        }

        return optionsDtoList;
    }
}
