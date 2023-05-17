package ru.skypro.skypro_exercises_course4_hw3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.skypro_exercises_course4_hw3.pojo.Employee;
import ru.skypro.skypro_exercises_course4_hw3.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
//    @Profile("test-y")
    public int getEmployeeCount() {
        return employeeRepository.getEmployeeCount();
    }

    @Override
    public int getEmployeeSalarySum() {
        return employeeRepository.getEmployeeSalarySum();
    }

    @Override
    public Employee getEmployeeSalaryMin() {
        return employeeRepository.getEmployeeSalaryMin();
    }

    @Override
    public Employee getEmployeeSalaryMax() {
        return employeeRepository.getEmployeeSalaryMax();
    }

    @Override
    public List<Employee> getEmployeesWithSalaryMoreThen() {
        return employeeRepository.getEmployeesWithSalaryMoreThen();
    }
}
