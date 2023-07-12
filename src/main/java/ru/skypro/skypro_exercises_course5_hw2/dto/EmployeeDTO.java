package ru.skypro.skypro_exercises_course5_hw2.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.skypro.skypro_exercises_course5_hw2.entity.Employee;
import ru.skypro.skypro_exercises_course5_hw2.entity.Position;

import java.util.Optional;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Integer salary;
    private String position;
}
