package com.atse.core_service.model;


import jakarta.persistence.*;

@Entity
@Table(name = "student_subject")
public class StudentSubject {

//    @EmbeddedId
//    private StudentSubjectId id;
//
    @Id
    @Column(name = "student_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Id
    @Column(name = "subject_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    private SubjectEntity subject;
}
