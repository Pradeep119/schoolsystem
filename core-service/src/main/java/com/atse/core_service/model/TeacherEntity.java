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
@Table(name = "teacher")
@Entity
@Builder
public class TeacherEntity {

    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    @Column(name = "name")
    private String teacherName;

    @Column(name = "address")
    private String teacherAddress;

    @OneToMany(mappedBy = "teacher")
    private Set<SubjectEntity> subjects = new HashSet<>();
}
