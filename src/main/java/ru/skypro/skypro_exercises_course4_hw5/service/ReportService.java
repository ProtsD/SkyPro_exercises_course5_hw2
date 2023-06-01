package ru.skypro.skypro_exercises_course4_hw5.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ReportService {
    void putReport(MultipartFile file);

    int putGeneralReport();

    ResponseEntity<Resource> getJson(int id);
}
