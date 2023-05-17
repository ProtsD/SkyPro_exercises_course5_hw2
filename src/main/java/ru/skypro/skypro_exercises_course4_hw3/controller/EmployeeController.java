package ru.skypro.skypro_exercises_course4_hw3.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.skypro.skypro_exercises_course4_hw3.pojo.Employee;
import ru.skypro.skypro_exercises_course4_hw3.service.EmployeeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


}
