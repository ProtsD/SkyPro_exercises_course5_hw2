package ru.skypro.skypro_exercises_course4_hw3.service;

import ru.skypro.skypro_exercises_course4_hw3.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    void addEmployees(Employee[] employee);

    void putEmployee(Integer id, Employee employee);
    //    void putEmployee(Map<String, String> params);
    Employee getEmployee(Integer id);

    void delEmployee(Integer id);

    List<Employee> getEmployeeWithSalaryHigherThan(int salary);

    int getSize();

}
