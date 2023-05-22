package ru.skypro.skypro_exercises_course4_hw4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.skypro_exercises_course4_hw4.entity.Employee;
import ru.skypro.skypro_exercises_course4_hw4.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PostMapping("/list")
    public void addEmployees(@RequestBody Employee[] employees) {
        employeeService.addEmployees(employees);
    }

    @PutMapping("/{id}")
    public void putEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        employeeService.putEmployee(id, employee);
    }

    /*    @PutMapping
        public void putEmployee(@RequestParam Map<String, String> params) {
            employeeService.putEmployee(params);
        }*/
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }


    @DeleteMapping("/{id}")
    public void delEmployee(@PathVariable Integer id) {
        employeeService.delEmployee(id);
    }

    @GetMapping("/salaryHigherThan/{salary}")
    public List<Employee> getEmployeeWithSalaryHigherThan(@PathVariable Integer salary) {
        return employeeService.getEmployeeWithSalaryHigherThan(salary);
    }

    @GetMapping("/size")
    public int getSize() {
        return employeeService.getSize();
    }
}
