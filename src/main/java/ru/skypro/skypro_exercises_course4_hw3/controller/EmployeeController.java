package ru.skypro.skypro_exercises_course4_hw3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.skypro_exercises_course4_hw3.pojo.Employee;
import ru.skypro.skypro_exercises_course4_hw3.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee[] employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("/put")
    public void putEmployee(@RequestParam Map<String, String> params) {
        employeeService.putEmployee(params);
    }

    @GetMapping("get/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("del/{id}")
    public void delEmployee(@PathVariable Integer id) {
        employeeService.delEmployee(id);
    }

    @GetMapping("salaryHigherThan/{salary}")
    public List<Employee> getEmployeeWithSalaryHigherThan(@PathVariable Integer salary) {
        return employeeService.getEmployeeWithSalaryHigherThan(salary);
    }

    @GetMapping("/size")
    public int getSize() {
        return employeeService.getSize();
    }
}
