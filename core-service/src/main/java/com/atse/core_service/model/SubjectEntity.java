package com.atse.core_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(
        name = "subject",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"subject_id", "classroom_id", "teacher_id"})
        }
)
public class SubjectEntity {

    @Id
    @Column(name = "subject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;

    @Column(name = "name")
    private String subjectName;

    @ManyToMany(mappedBy = "studentSubject")
    Set<StudentEntity> students;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id", nullable = false)
    private TeacherEntity teacher;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private ClassRoomEntity classroom;
}
