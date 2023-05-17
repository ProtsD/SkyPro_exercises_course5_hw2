package ru.skypro.skypro_exercises_course4_hw3.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private final Integer id;
    private final String name;
    private final int salary;
}
