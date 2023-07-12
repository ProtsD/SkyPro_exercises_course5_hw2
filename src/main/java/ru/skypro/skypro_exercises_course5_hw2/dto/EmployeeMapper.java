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
public class EmployeeMapper {
    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());

        if (Optional.ofNullable(employee.getPosition()).isPresent()) {
            employeeDTO.setPosition(employee.getPosition().getName());
        }

        return employeeDTO;
    }

    public Employee toEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setPosition(new Position().setName(employeeDTO.getPosition()));
        return employee;
    }
}
