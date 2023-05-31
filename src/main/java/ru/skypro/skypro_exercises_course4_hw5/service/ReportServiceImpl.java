package ru.skypro.skypro_exercises_course4_hw5.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.skypro_exercises_course4_hw5.dto.EmployeeDTO;
import ru.skypro.skypro_exercises_course4_hw5.entity.Report;
import ru.skypro.skypro_exercises_course4_hw5.repository.EmployeeRepository;
import ru.skypro.skypro_exercises_course4_hw5.repository.ReportRepository;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final EmployeeRepository employeeRepository;
    private final ReportRepository reportRepository;

    @Override
    public void putReport(EmployeeDTO[] employeeDTO) {
        StringBuilder builder = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            builder.append(objectMapper.writeValueAsString(employeeDTO));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        Report report = new Report(builder.toString());
        reportRepository.save(report);
    }

    @Override
    public int putGeneralReport() {
        StringBuilder builder = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            builder.append(objectMapper.writeValueAsString(employeeRepository.putGeneralReport()));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        Report report = new Report(builder.toString());
        reportRepository.save(report);

        return report.getId();
    }

    @Override
    public String getJson(int id) {
        reportRepository.findById(id);
        return reportRepository.findById(id).get().getText();
    }

    ;
}
