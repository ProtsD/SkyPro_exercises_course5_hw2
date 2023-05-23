package ru.skypro.skypro_exercises_course4_hw4.service;

import org.springframework.web.bind.annotation.RequestParam;
import ru.skypro.skypro_exercises_course4_hw4.dto.EmployeeDTO;
import ru.skypro.skypro_exercises_course4_hw4.dto.EmployeeFullInfo;

import java.util.List;

public interface EmployeeService {

    void addEmployee(EmployeeDTO employeeDTO);

    void addEmployees(EmployeeDTO[] employeeDTO);

    void putEmployee(Integer id, EmployeeDTO employeeDTO);

    EmployeeDTO getEmployee(Integer id);

    void delEmployee(Integer id);

    List<EmployeeDTO> getEmployeeWithSalaryHigherThan(int salary);

    List<EmployeeDTO> getEmployeesWithHighestSalary();

    List<EmployeeDTO> getEmployeesOnPosition(Integer position);

    EmployeeFullInfo getEmployeeFullInfo(Integer id);
    List<EmployeeFullInfo> getEmployeePage(Integer page);
}
