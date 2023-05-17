package ru.skypro.skypro_exercises_course4_hw3.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.skypro.skypro_exercises_course4_hw3.pojo.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Getter
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final List<Employee> employeeList = List.of(
            new Employee(1,"Катя", 90_000),
            new Employee(2,"Дима", 102_000),
            new Employee(3,"Олег", 80_000),
            new Employee(4,"Вика", 165_000));

    @Override

    public int getEmployeeCount() {
        return employeeList.size();
    }

    @Override
    public int getEmployeeSalarySum() {
        return employeeList.stream()
                .mapToInt((s) -> s.getSalary())
                .sum();
    }

    @Override
    public Employee getEmployeeSalaryMin() {
        return employeeList.stream().
                min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Employee getEmployeeSalaryMax() {
        return employeeList.stream().
                max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Employee> getEmployeesWithSalaryMoreThen() {
        double average = employeeList.stream().
                mapToDouble(Employee::getSalary).
                average().
                getAsDouble();
        return employeeList.stream().filter((s) -> s.getSalary() > average).collect(Collectors.toList());
    }
}
