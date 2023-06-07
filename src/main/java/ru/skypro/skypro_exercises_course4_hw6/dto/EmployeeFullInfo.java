package ru.skypro.skypro_exercises_course4_hw6.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeFullInfo {
    private String name;
    private Integer salary;
    private String positionName;

    public EmployeeFullInfo(String name, Integer salary, String positionName) {
        this.name = name;
        this.salary = salary;
        this.positionName = positionName;
    }
}
