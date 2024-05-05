package com.project.Questionnaire.portal.controller;

import com.project.Questionnaire.portal.dto.FieldDto;
import com.project.Questionnaire.portal.entity.Field;
import com.project.Questionnaire.portal.mapper.FieldMapper;
import com.project.Questionnaire.portal.service.FieldService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@AllArgsConstructor
public class FieldController {
    @Autowired
    private FieldService fieldService;
    @Autowired
    private FieldMapper fieldMapper;

    @GetMapping("/fields")
    public List<FieldDto> getFields() {
        List<Field> fieldList = fieldService.findAllFields();
        List<FieldDto> fieldDtoList = fieldMapper.toFieldDto(fieldList);

        return fieldDtoList;
    }

    @PostMapping("/fields/create")
    public FieldDto createField(@RequestBody FieldDto fieldDto) {
        Field field = fieldService.createField(fieldMapper.toField(fieldDto));

        return fieldMapper.toFieldDto(field);
    }

    @PutMapping("/fields/update/{id}")
    public FieldDto updateField(@RequestBody FieldDto fieldDto, @PathVariable("id") Long fieldId) {
        Field field = fieldService.findById(fieldId);


        if (field != null) {
            fieldService.updateField(field, fieldMapper.toField(fieldDto));
            return fieldMapper.toFieldDto(field);
        } else {
            return null;
        }
    }

    @DeleteMapping("/fields/delete/{id}")
    public void deleteField(@PathVariable("id") Long fieldId) {
        fieldService.deleteField(fieldId);
    }
}
