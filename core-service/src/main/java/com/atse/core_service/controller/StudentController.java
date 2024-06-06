package com.atse.core_service.controller;

import com.atse.core_service.dto.StudentDto;
import com.atse.core_service.model.StudentEntity;
import com.atse.core_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto saveStudent(@RequestBody StudentDto studentDto){
        StudentEntity studentEntity =  studentService.saveStudent(studentDto);

        return StudentDto.builder()
                .id(studentEntity.getStudentId())
                .name(studentEntity.getStudentName())
                .address(studentEntity.getStudentAddress())
                .build();
    }

    @GetMapping("/{studentId}")
    @CrossOrigin(origins = "*") // Allow all origins
    @ResponseStatus(HttpStatus.OK)
    public StudentDto getStudent(@PathVariable String studentId){
        Boolean bool = studentService.getStudent(studentId).isPresent();
        if(bool){
            StudentEntity studentEntity = studentService.getStudent(studentId).get();
            return StudentDto.builder()
                    .id(studentEntity.getStudentId())
                    .address(studentEntity.getStudentAddress())
                    .name(studentEntity.getStudentName())
                    .build();
        }else{
            return new StudentDto();
        }

    }

    @GetMapping("/get")
    public List<StudentDto> getStudents(@RequestParam Integer subjectId, @RequestParam Integer classroomId) {
        List<StudentEntity> studentEntityList =  studentService.getStudentsBySubjectAndClassroom(subjectId, classroomId);

        return studentEntityList.stream()
                .map(studentEntity -> new StudentDto(
                        studentEntity.getStudentId(),
                        studentEntity.getStudentName(),
                        studentEntity.getStudentAddress()
                        ))
                .collect(Collectors.toList());
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<StudentEntity> getAllStudents(){
        return studentService.getAllStudents();
    }

}
