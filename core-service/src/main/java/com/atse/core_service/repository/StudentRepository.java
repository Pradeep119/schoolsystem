package com.atse.core_service.repository;

import com.atse.core_service.model.StudentEntity;
import com.atse.core_service.model.SubjectEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

//    @Query("SELECT s FROM StudentEntity s JOIN s.studentSubject ss JOIN ss.SubjectEntity subj WHERE ss.SubjectEntity.subject_id = :subjectId AND subj.classroom.id = :classroomId")
//    @Query("SELECT s FROM StudentEntity s JOIN s.classroom c JOIN s.subjects subj WHERE subj.subjectId = :subjectId AND c.id = :classroomId")
//    @Query("SELECT s FROM StudentEntity s JOIN s.subjects ss JOIN ss.subject subj WHERE subj.subjectId = 1 AND subj.classroom.classroomId = 2")





    @Query(value = "SELECT s.student_id, s.name, s.address, subj.classroom_id " +
            "FROM  student s " +
            "JOIN  student_subject ss ON ss.student_id = s.student_id " +
            "JOIN subject subj ON ss.subject_id = subj.subject_id " +
            "WHERE ss.subject_id = :subjectId AND subj.classroom_id = :classroomId;", nativeQuery = true)

    List<StudentEntity> findStudentsBySubjectAndClassroom(@Param("subjectId") Integer subjectId, @Param("classroomId") Integer classroomId);

    @Override
    List<StudentEntity> findAll();
}
