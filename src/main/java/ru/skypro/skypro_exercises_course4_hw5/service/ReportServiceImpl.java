package ru.skypro.skypro_exercises_course4_hw5.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.skypro_exercises_course4_hw5.dto.EmployeeDTO;
import ru.skypro.skypro_exercises_course4_hw5.entity.Report;
import ru.skypro.skypro_exercises_course4_hw5.repository.EmployeeRepository;
import ru.skypro.skypro_exercises_course4_hw5.repository.ReportRepository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final EmployeeRepository employeeRepository;
    private final ReportRepository reportRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void putReport(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            int StreamSize = inputStream.available();
            byte[] bytes = new byte[StreamSize];
            inputStream.read(bytes);
            String jsonText = new String(bytes, StandardCharsets.UTF_8);

            List<EmployeeDTO> employeeDTO = Arrays.asList(objectMapper.readValue(jsonText, EmployeeDTO[].class));
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
    public ResponseEntity<Resource> getJson(int id) {
        String fileName = "employee.json";
        Optional<Report> file = reportRepository.findById(id);
        if (file.isPresent()) {
            String jsonText = reportRepository.findById(id).get().getText();
            Resource resource = new ByteArrayResource(jsonText.getBytes());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(resource);
        }
        throw new NoSuchElementException();
    }
}
