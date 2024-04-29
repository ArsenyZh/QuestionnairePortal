package com.project.Questionnaire.portal.service;

import com.project.Questionnaire.portal.entity.Field;
import com.project.Questionnaire.portal.repository.FieldRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FieldService {
    @Autowired
    private FieldRepository fieldRepository;
    @Autowired
    private UserService userService;

    public Field createField(Field field) {
        Field createdField = fieldRepository.save(field);

        return createdField;
    }

    public Field updateField(Field field, Field updatedField) {
        field.setType(updatedField.getType());
        field.setLabel(updatedField.getLabel());
        field.setActive(updatedField.isActive());
        field.setRequired(updatedField.isActive());
        fieldRepository.save(field);

        return field;
    }

    public void deleteField(Long fieldId) {
        Field field = fieldRepository.findById(fieldId).orElse(null);

        if (field != null) {
            fieldRepository.delete(field);
        }
    }

    public List<Field> findAllFields() {
        List<Field> fieldList = fieldRepository.findAll();

        return fieldList;
    }

    public Field findById(Long id) {
        Field field = fieldRepository.findById(id).orElse(null);

        return field;
    }
}
