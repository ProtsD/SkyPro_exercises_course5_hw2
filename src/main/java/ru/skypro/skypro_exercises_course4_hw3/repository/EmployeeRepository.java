package ru.skypro.skypro_exercises_course4_hw3.repository;

import ru.skypro.skypro_exercises_course4_hw3.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    void addEmployee(Employee[] employee);

    void putEmployee(Map<String, String> params);

    Employee getEmployee(Integer id);

    void delEmployee(Integer id);

    List<Employee> getsalaryHigherThan(int salary);

    int getSize();

}
