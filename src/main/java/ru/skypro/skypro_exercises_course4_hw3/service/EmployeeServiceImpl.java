package ru.skypro.skypro_exercises_course4_hw3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.skypro_exercises_course4_hw3.pojo.Employee;
import ru.skypro.skypro_exercises_course4_hw3.repository.EmployeeRepository;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee[] employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void putEmployee(Map<String, String> params) {
//        int id = Integer.parseInt(params.get("id"));
        employeeRepository.putEmployee(params);
    }

    public Employee getEmployee(Integer id) {
        return employeeRepository.getEmployee(id);
    }

    public void delEmployee(Integer id) {
        employeeRepository.delEmployee(id);
    }

    public List<Employee> getEmployeeWithSalaryHigherThan(int salary) {
        return employeeRepository.getsalaryHigherThan(salary);
    }

    public int getSize() {
        return employeeRepository.getSize();
    }
}
