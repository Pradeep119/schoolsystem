package com.atse.core_service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDto {
    private int id;
    private String name;
    private String address;
}
