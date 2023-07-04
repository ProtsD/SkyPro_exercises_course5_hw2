package ru.skypro.skypro_exercises_course5_hw1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.skypro_exercises_course5_hw1.exception.ReportNotFoundException;
import ru.skypro.skypro_exercises_course5_hw1.repository.EmployeeRepository;
import ru.skypro.skypro_exercises_course5_hw1.repository.ReportRepository;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private ReportRepository reportRepository;
    @Mock
    private ObjectMapper objectMapper;
    @InjectMocks
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private ReportServiceImpl reportService;

    @Test
    void putReport() throws IOException {
/*        List<EmployeeDTO> expected = List.of(
                EmployeeDTO.fromEmployee(new Employee()
                        .setId(123)
                        .setName("Denis1")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer1"))),
                EmployeeDTO.fromEmployee(new Employee()
                        .setId(124)
                        .setName("Denis2")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer2")))
        );
        when(objectMapper.readValue((JsonParser) any(), (TypeReference<Object>) any()))
                .thenReturn(expected);
        verify(employeeRepository, times(1)).save(any(EmployeeDTO.class));*/

    }

    @Test
    void putGeneralReport() {
    }

    @Test
    void getJson_ThrowReportNotFoundException() {
        Integer input = 20;
        when(reportRepository.findById(any()))
                .thenThrow(ReportNotFoundException.class);
        assertThrows(ReportNotFoundException.class, () -> reportRepository.findById(input));
    }
}