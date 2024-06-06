package com.atse.core_service.controller;

import com.atse.core_service.dto.SubjectDto;
import com.atse.core_service.model.SubjectEntity;
import com.atse.core_service.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectEntity saveStudent(@RequestBody SubjectDto subjectDto) {
        return  subjectService.saveSubject(subjectDto);
    }

    @GetMapping("/{subjectId}")
    @ResponseStatus(HttpStatus.OK)
    public SubjectEntity getSubject(@PathVariable String subjectId) {
        return subjectService.getSubject(subjectId).get();
    }
}
