package ru.skypro.skypro_exercises_course5_hw2.repository;

import jakarta.validation.constraints.AssertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import ru.skypro.skypro_exercises_course5_hw2.entity.Employee;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

/*    void getAllEmployeeByIdTest() {
        Optional<Employee> employee = employeeRepository.findById(1);
        assertTrue(employee.isEmpty());
        List<Employee> employeeListForSave = getEmployeeListForSave(expectedCounnt, targetName);

        int expectedId = 1;
        employee = employeeRepository.findById(1);
        assertEquals(expectedId, employee.orElseThrow());
        getEmployeeWithSalaryHigherThan
    }*/
}