package com.atse.core_service.service;

import com.atse.core_service.dto.StudentDto;
import com.atse.core_service.model.ClassRoomEntity;
import com.atse.core_service.model.StudentEntity;
import com.atse.core_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentEntity saveStudent(StudentDto studentDto){

        StudentEntity student = new StudentEntity();
        student.setStudentName(studentDto.getName());
        student.setStudentAddress(studentDto.getAddress());

        studentRepository.save(student);
        return student;
    }

    public Optional<StudentEntity> getStudent(String studentId){
        return studentRepository.findById(Integer.valueOf(studentId));
    }

    public List<StudentEntity> getAllStudents(){
        return studentRepository.findAll();
    }

    public List<StudentEntity> getStudentsBySubjectAndClassroom(Integer subjectId, Integer classroomId) {
        return studentRepository.findStudentsBySubjectAndClassroom(subjectId, classroomId);
//        return new ArrayList<>();
    }
}
