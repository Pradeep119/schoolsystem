package com.atse.core_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StudentSubjectId {

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "subject_id")
    private Long subjectId;
}
