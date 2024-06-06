package com.atse.attendance_service.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(
        name = "attendance",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"student_id", "date"})
        }
)
public class AttendanceEntity {

    @Id
    @Column(name = "attendance_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "date")
    private String date;
}
