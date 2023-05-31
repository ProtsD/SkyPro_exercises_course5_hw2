package ru.skypro.skypro_exercises_course4_hw5.service;

import ru.skypro.skypro_exercises_course4_hw5.dto.EmployeeDTO;

public interface ReportService {
    void putReport(EmployeeDTO[] employeeDTO);

    int putGeneralReport();

    String getJson(int id);
}
