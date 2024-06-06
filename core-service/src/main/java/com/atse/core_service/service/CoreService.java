package com.atse.core_service.service;

import com.atse.core_service.model.ClassRoomEntity;
import com.atse.core_service.model.StudentEntity;
import com.atse.core_service.model.SubjectEntity;
import com.atse.core_service.model.TeacherEntity;
import com.atse.core_service.repository.ClassRoomRepository;
import com.atse.core_service.repository.StudentRepository;
import com.atse.core_service.repository.SubjectRepository;
import com.atse.core_service.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class CoreService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Transactional
    public void initializeData() {

        // Create Teachers
        TeacherEntity mathTeacher = TeacherEntity.builder()
                .teacherName("Math Teacher")
                .teacherAddress("Colombo")
                .build();

        TeacherEntity scienceTeacher = TeacherEntity.builder()
                .teacherName("Science Teacher")
                .teacherAddress("Kandy")
                .build();

        TeacherEntity englishTeacher = TeacherEntity.builder()
                .teacherName("English Teacher")
                .teacherAddress("Kurunegala")
                .build();

        teacherRepository.saveAll(Arrays.asList(mathTeacher, scienceTeacher, englishTeacher));


        // Create Classrooms
        ClassRoomEntity grade8 = ClassRoomEntity.builder().grade("grade 8").build();
        ClassRoomEntity grade9 = ClassRoomEntity.builder().grade("grade 9").build();
        classRoomRepository.saveAll(Arrays.asList(grade8, grade9));

        // Create Subjects for Grade 8
        SubjectEntity math8 = SubjectEntity.builder()
                .subjectName("Math")
                .teacher(mathTeacher)
                .classroom(grade8)
                .build();

        SubjectEntity science8 = SubjectEntity.builder()
                .subjectName("Science")
                .teacher(scienceTeacher)
                .classroom(grade8)
                .build();

        SubjectEntity english8 = SubjectEntity.builder()
                .subjectName("English")
                .teacher(englishTeacher)
                .classroom(grade8)
                .build();

        subjectRepository.saveAll(Arrays.asList(math8, science8, english8));

        // Create Subjects for Grade 9
        SubjectEntity math9 = SubjectEntity.builder()
                .subjectName("Math")
                .teacher(mathTeacher)
                .classroom(grade9)
                .build();

        SubjectEntity science9 = SubjectEntity.builder()
                .subjectName("Science")
                .teacher(scienceTeacher)
                .classroom(grade9)
                .build();

        SubjectEntity english9 = SubjectEntity.builder()
                .subjectName("English")
                .teacher(englishTeacher)
                .classroom(grade9)
                .build();

        subjectRepository.saveAll(Arrays.asList(math9, science9, english9));




        // Create Students for Grade 8
        for (int i = 1; i <= 20; i++) {
            StudentEntity student = StudentEntity.builder().studentName("Grade 8 Student " + i)
                    .studentAddress("Address "+i)
                    .classroom(grade8)
                    .studentSubject(Arrays.asList(math8, science8, english8))
                    .build();
            studentRepository.save(student);
        }

        // Create Students for Grade 9
        for (int i = 1; i <= 30; i++) {
            StudentEntity student = StudentEntity.builder().studentName("Grade 9 Student " + i)
                    .studentAddress("Address "+i)
                    .classroom(grade9)
                    .studentSubject(Arrays.asList(math9, science9, english9))
                    .build();
            studentRepository.save(student);
        }
    }
}
