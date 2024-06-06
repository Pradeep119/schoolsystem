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
@Table(name = "classroom")
@Entity
@Builder
public class ClassRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String grade;

    @OneToMany(mappedBy = "classroom")
    private Set<StudentEntity> students = new HashSet<>();

    @OneToMany(mappedBy = "classroom")
    private Set<SubjectEntity> subjects = new HashSet<>();
}
