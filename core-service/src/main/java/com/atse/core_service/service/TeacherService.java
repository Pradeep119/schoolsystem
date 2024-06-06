package com.atse.core_service.service;

import com.atse.core_service.dto.StudentDto;
import com.atse.core_service.dto.TeacherDto;
import com.atse.core_service.model.StudentEntity;
import com.atse.core_service.model.TeacherEntity;
import com.atse.core_service.repository.StudentRepository;
import com.atse.core_service.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public TeacherEntity saveTeacher(TeacherDto teacherDto){

        TeacherEntity teacher = new TeacherEntity();
        teacher.setTeacherName(teacherDto.getName());
        teacher.setTeacherAddress(teacherDto.getAddress());

        teacherRepository.save(teacher);
        return teacher;
    }

    public Optional<TeacherEntity> getTeacher(String teacherId){
        return teacherRepository.findById(Integer.valueOf(teacherId));
    }
}
