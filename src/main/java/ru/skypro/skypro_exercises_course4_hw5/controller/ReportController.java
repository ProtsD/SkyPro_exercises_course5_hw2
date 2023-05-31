package ru.skypro.skypro_exercises_course4_hw5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.skypro_exercises_course4_hw5.dto.EmployeeDTO;
import ru.skypro.skypro_exercises_course4_hw5.service.ReportService;

@RestController
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @PostMapping("/employees/upload")
    public void putReport(@RequestBody EmployeeDTO[] employeesDTO) {
        reportService.putReport(employeesDTO);
    }

    @PostMapping("/report")
    public int putGeneralReport() {
        return reportService.putGeneralReport();
    }

    @GetMapping("/report/{id}")
    public String getJson(@PathVariable(name = "id") int id) {
        return reportService.getJson(id);
    }
}
