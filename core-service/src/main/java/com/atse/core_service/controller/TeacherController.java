package com.atse.core_service.controller;

import com.atse.core_service.dto.SubjectDto;
import com.atse.core_service.dto.TeacherDto;
import com.atse.core_service.model.SubjectEntity;
import com.atse.core_service.model.TeacherEntity;
import com.atse.core_service.service.SubjectService;
import com.atse.core_service.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherEntity saveTeacher(@RequestBody TeacherDto teacherDto) {
        return  teacherService.saveTeacher(teacherDto);
    }

    @GetMapping("/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherEntity getTeacher(@PathVariable String teacherId) {
        return teacherService.getTeacher(teacherId).get();
    }
}