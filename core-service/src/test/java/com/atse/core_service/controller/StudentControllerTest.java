package com.atse.core_service.controller;

import com.atse.core_service.dto.StudentDto;
import com.atse.core_service.model.StudentEntity;
import com.atse.core_service.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void testGetStudentFound() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(123);
        studentEntity.setStudentAddress("123 Main St");
        studentEntity.setStudentName("John Doe");

        when(studentService.getStudent(anyString())).thenReturn(Optional.of(studentEntity));

        StudentDto result = studentController.getStudent("123");

        assertEquals(123, result.getId());
        assertEquals("123 Main St", result.getAddress());
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testGetStudentNotFound() {
        when(studentService.getStudent(anyString())).thenReturn(Optional.empty());

        StudentDto result = studentController.getStudent("123");

        assertEquals(0, result.getId());
        assertEquals(null, result.getAddress());
        assertEquals(null, result.getName());
    }

    @Test
    public void testGetAllStudents() {
        StudentEntity student1 = new StudentEntity();
        student1.setStudentId(1);
        student1.setStudentAddress("Address 1");
        student1.setStudentName("Student 1");

        StudentEntity student2 = new StudentEntity();
        student2.setStudentId(2);
        student2.setStudentAddress("Address 2");
        student2.setStudentName("Student 2");

        List<StudentEntity> studentList = Arrays.asList(student1, student2);

        when(studentService.getAllStudents()).thenReturn(studentList);

        List<StudentEntity> result = studentController.getAllStudents();

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getStudentId());
        assertEquals("Address 1", result.get(0).getStudentAddress());
        assertEquals("Student 1", result.get(0).getStudentName());
        assertEquals(2, result.get(1).getStudentId());
        assertEquals("Address 2", result.get(1).getStudentAddress());
        assertEquals("Student 2", result.get(1).getStudentName());
    }
}
