package com.project.Questionnaire.portal.controller;

import com.project.Questionnaire.portal.dto.ResponseDto;
import com.project.Questionnaire.portal.entity.Response;
import com.project.Questionnaire.portal.mapper.ResponseMapper;
import com.project.Questionnaire.portal.service.ResponseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class ResponseController {
    @Autowired
    private ResponseService responseService;
    @Autowired
    private ResponseMapper responseMapper;

    @PostMapping("/questionnaires/add")
    public ResponseDto addResponse(@RequestBody ResponseDto responseDto) {
        Response response = responseService.addResponse(responseMapper.toResponse(responseDto));

        return responseMapper.toResponseDto(response);
    }

    @GetMapping("/questionnaires/get")
    public ResponseDto getAllResponse() {
        ResponseDto responseDto = responseMapper.toResponseDto(responseService.findAllResponses());

        return responseDto;
    }

    @GetMapping("/questionnaires/get/{id}")
    public ResponseDto getAllResponse(@PathVariable("id") Long responseId) {
        ResponseDto responseDto = responseMapper.toResponseDto(responseService.findResponse(responseId));

        return responseDto;
    }
}
