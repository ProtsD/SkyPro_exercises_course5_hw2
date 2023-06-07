package ru.skypro.skypro_exercises_course4_hw6.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.skypro_exercises_course4_hw6.dto.EmployeeDTO;
import ru.skypro.skypro_exercises_course4_hw6.entity.Report;
import ru.skypro.skypro_exercises_course4_hw6.exception.ReportNotFoundException;
import ru.skypro.skypro_exercises_course4_hw6.repository.EmployeeRepository;
import ru.skypro.skypro_exercises_course4_hw6.repository.ReportRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final EmployeeRepository employeeRepository;
    private final ReportRepository reportRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void putReport(MultipartFile file) {

        try {
            List<EmployeeDTO> employeeDTO = objectMapper.readValue(file.getBytes(), new TypeReference<>(){});
            employeeDTO.stream().map(EmployeeDTO::toEmployee).forEach(employeeRepository::save);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int putGeneralReport() {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(employeeRepository.putGeneralReport());
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        Report report = new Report(json);
        reportRepository.save(report);
        return report.getId();
    }

    @Override
    public Resource getJson(int id) {
        Optional<Report> file = reportRepository.findById(id);
        if (file.isPresent()) {
            String jsonText = reportRepository.findById(id).get().getText();
            return new ByteArrayResource(jsonText.getBytes());
        }
        throw new ReportNotFoundException();
    }
}
