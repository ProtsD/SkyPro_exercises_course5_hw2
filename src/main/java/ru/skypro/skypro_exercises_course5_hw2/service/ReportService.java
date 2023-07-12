package ru.skypro.skypro_exercises_course5_hw2.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ReportService {
    void putReport(MultipartFile file);

    int putGeneralReport();

    Resource getJson(int id);
}
