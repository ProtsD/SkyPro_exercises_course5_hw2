package ru.skypro.skypro_exercises_course5_hw2.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.skypro.skypro_exercises_course5_hw2.dto.EmployeeDTO;
import ru.skypro.skypro_exercises_course5_hw2.repository.EmployeeRepository;

import java.util.List;

import static Constants.EmployeeConstants.returnEmployeeListFromDB;
import static Constants.EmployeeConstants.returnJsonEmployeeDTOList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class ReportControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void putReport() throws Exception {
        int arrayElement1 = 1;
        int arrayElement2 = 2;
        String jsonString = returnJsonEmployeeDTOList(arrayElement1, arrayElement2);
        MockMultipartFile multipartFile = new MockMultipartFile(
                "file",
                "Employee import file.json",
                MediaType.APPLICATION_JSON_VALUE,
                objectMapper.writeValueAsBytes(objectMapper.readValue(jsonString, new TypeReference<List<EmployeeDTO>>() {
                })));


        mockMvc.perform(MockMvcRequestBuilders.multipart("/employees/upload")
                        .file(multipartFile)
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE))
                .andExpect(status().isOk());


        List<EmployeeDTO> actual = returnEmployeeListFromDB(employeeRepository).stream().map(EmployeeDTO::fromEmployee).toList();
        assertThat(actual)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("position")
                .containsAnyElementsOf(objectMapper.readValue(jsonString, new TypeReference<List<EmployeeDTO>>() {
                }));
    }

    @Test
    void putGeneralReport() {
    }

    @Test
    void getJson() {
    }
}