package com.atse.core_service.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "student")
@Entity
@Builder
public class StudentEntity {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "name")
    private String studentName;

    @Column(name = "address")
    private String studentAddress;

    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "subject_id"}))
    private List<SubjectEntity> studentSubject;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private ClassRoomEntity classroom;
}
