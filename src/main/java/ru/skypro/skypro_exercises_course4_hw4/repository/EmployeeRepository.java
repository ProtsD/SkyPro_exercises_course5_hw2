package ru.skypro.skypro_exercises_course4_hw4.repository;

import ru.skypro.skypro_exercises_course4_hw4.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    void addEmployee(Employee employee);

    void addEmployees(Employee[] employee);

    void putEmployee(Integer id, Employee employee);
    //    void putEmployee(Map<String, String> params);
    Employee getEmployee(Integer id);

    void delEmployee(Integer id);

    List<Employee> getsalaryHigherThan(int salary);

    int getSize();

}
