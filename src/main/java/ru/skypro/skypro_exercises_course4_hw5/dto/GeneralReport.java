package ru.skypro.skypro_exercises_course4_hw5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralReport {

    private String position;
    private Long numberOfEmployees;
    private Integer maxSalary;
    private Integer minSalary;
    private Double avgSalary;
}
