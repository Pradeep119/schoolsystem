package com.atse.core_service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherDto {
    private int id;
    private String name;
    private String address;
}
