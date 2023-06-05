package ru.skypro.skypro_exercises_course4_hw5.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.skypro_exercises_course4_hw5.exception.ReportNotFoundException;

public interface ReportService {
    void putReport(MultipartFile file);

    int putGeneralReport();

    Resource getJson(int id);
}
