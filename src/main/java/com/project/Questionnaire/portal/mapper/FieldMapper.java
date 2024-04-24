package com.project.Questionnaire.portal.mapper;

import com.project.Questionnaire.portal.dto.FieldDto;
import com.project.Questionnaire.portal.entity.Field;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FieldMapper {
    public Field toField(FieldDto fieldDto) {
        Field field = new Field();
        field.setLabel(fieldDto.getLabel());
        field.setActive(fieldDto.isActive());
        field.setRequired(fieldDto.isRequired());
        field.setType(fieldDto.getType());

        return field;
    }

    public FieldDto toFieldDto(Field field) {
        FieldDto fieldDto = new FieldDto();
        fieldDto.setLabel(field.getLabel());
        fieldDto.setActive(field.isActive());
        fieldDto.setRequired(field.isRequired());
        fieldDto.setType(field.getType());

        return fieldDto;
    }

    public List<FieldDto> toFieldDto(List<Field> fieldList) {
        List<FieldDto> fieldDtoList = new ArrayList<>();
        for (Field field : fieldList) {
            FieldDto fieldDto = new FieldDto();
            fieldDto.setLabel(field.getLabel());
            fieldDto.setActive(field.isActive());
            fieldDto.setRequired(field.isRequired());
            fieldDto.setType(field.getType());
            fieldDtoList.add(fieldDto);
        }

        return fieldDtoList;
    }
}
