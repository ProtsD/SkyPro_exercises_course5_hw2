package ru.skypro.skypro_exercises_course5_hw1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.skypro_exercises_course5_hw1.dto.EmployeeDTO;
import ru.skypro.skypro_exercises_course5_hw1.dto.EmployeeFullInfo;
import ru.skypro.skypro_exercises_course5_hw1.entity.Employee;
import ru.skypro.skypro_exercises_course5_hw1.entity.Position;
import ru.skypro.skypro_exercises_course5_hw1.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @ParameterizedTest
    @MethodSource("addEmployees_ProvideParamsForTests")
    void addEmployees_ArraysOfEmployee_NoReturn(EmployeeDTO[] employeeDTO) {
        employeeService.addEmployees(employeeDTO);
        verify(employeeRepository, times(1)).saveAll(any());
    }

    public static Stream<Arguments> addEmployees_ProvideParamsForTests() {
        return Stream.of(

                Arguments.of(
                        (Object) new EmployeeDTO[]{
                                EmployeeDTO.fromEmployee(
                                        new Employee()
                                                .setId(123)
                                                .setName("Denis")
                                                .setSalary(400)
                                                .setPosition(new Position().setId(1).setName("Programmer1"))),
                                EmployeeDTO.fromEmployee(
                                        new Employee()
                                                .setId(123)
                                                .setName("Denis2")
                                                .setSalary(400)
                                                .setPosition(new Position().setId(2).setName("Programmer2")))
                        }),
                Arguments.of(
                        (Object) new EmployeeDTO[]{
                                EmployeeDTO.fromEmployee(
                                        new Employee()
                                                .setId(123)
                                                .setName("Denis")
                                                .setSalary(400)
                                                .setPosition(new Position().setId(1).setName("Programmer1")))
                        }),
                Arguments.of((Object) new EmployeeDTO[]{})
        );
    }

    @Test
    void addEmployee_EmployeeDTO_NoReturn() {
        EmployeeDTO employee = EmployeeDTO.fromEmployee(
                new Employee()
                        .setId(123)
                        .setName("Denis")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer1"))
        );
        employeeService.addEmployee(employee);
        verify(employeeRepository, times(1)).save(any());
    }

    @Test
    void putEmployee_IdAndEmployeeDTO_NoReturn() {

        when(employeeRepository.existsById(anyInt()))
                .thenReturn(true);

        Integer inputInteger = 1;
        EmployeeDTO inputEmployee = EmployeeDTO.fromEmployee(
                new Employee()
                        .setId(123)
                        .setName("Denis")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer1"))
        );
        employeeService.putEmployee(inputInteger, inputEmployee);
        verify(employeeRepository, times(1)).save(any());
    }

    @Test
    void getEmployee_EmployeeId_ShouldReturnEmployeeDTO() {
        Integer input = 2;
        EmployeeDTO expectedDTO =
                EmployeeDTO.fromEmployee(new Employee()
                        .setId(123)
                        .setName("Denis1")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer1")));

        Optional<Employee> expectedEntity =
                Optional.ofNullable(new Employee()
                        .setId(123)
                        .setName("Denis1")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer1"))
                );
        when(employeeRepository.findById(input))
                .thenReturn(expectedEntity);


        EmployeeDTO actual = employeeService.getEmployee(input);
        assertEquals(expectedDTO, actual);
        verify(employeeRepository, times(2)).findById(any());
    }

    @Test
    void delEmployee_ById_NoReturn() {
        Integer input = 1;
        employeeService.delEmployee(input);
        verify(employeeRepository, times(1)).deleteById(any());
    }

    @Test
    void getEmployeesWithHighestSalary_ValidPosition_ShouldReturnEmployeeDTOList() {
        List<EmployeeDTO> expected = List.of(
                EmployeeDTO.fromEmployee(new Employee()
                        .setId(123)
                        .setName("Denis1")
                        .setSalary(402)
                        .setPosition(new Position().setId(2).setName("Programmer1"))),
                EmployeeDTO.fromEmployee(new Employee()
                        .setId(123)
                        .setName("Denis2")
                        .setSalary(402)
                        .setPosition(new Position().setId(2).setName("Programmer2")))
        );

        List<Employee> expectedRepositoryOut = List.of(
                new Employee()
                        .setId(123)
                        .setName("Denis1")
                        .setSalary(402)
                        .setPosition(new Position().setId(2).setName("Programmer1")),
                new Employee()
                        .setId(123)
                        .setName("Denis2")
                        .setSalary(402)
                        .setPosition(new Position().setId(2).setName("Programmer2"))
        );
        Integer input = 2;
        when(employeeRepository.getEmployeesWithHighestSalary())
                .thenReturn(expectedRepositoryOut);

        List<EmployeeDTO> actual = employeeService.getEmployeesWithHighestSalary();
        assertEquals(expected, actual);
        verify(employeeRepository, times(1)).getEmployeesWithHighestSalary();
    }

    @Test
    void getEmployeesOnPosition_ValidPosition_ShouldReturnEmployeeDTOList() {
        List<EmployeeDTO> expectedMethodOut = List.of(
                EmployeeDTO.fromEmployee(new Employee()
                        .setId(123)
                        .setName("Denis1")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer1"))),
                EmployeeDTO.fromEmployee(new Employee()
                        .setId(123)
                        .setName("Denis2")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer2")))
        );

        List<Employee> expectedRepositoryOut = List.of(
                new Employee()
                        .setId(123)
                        .setName("Denis1")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer1")),
                new Employee()
                        .setId(123)
                        .setName("Denis2")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer2")),
                new Employee()
                        .setId(1234)
                        .setName("Denis3")
                        .setSalary(401)
                        .setPosition(new Position().setId(3).setName("Programmer3"))
        );
        Integer input = 2;
        when(employeeRepository.findAll())
                .thenReturn(expectedRepositoryOut);

        List<EmployeeDTO> actual = employeeService.getEmployeesOnPosition(input);
        assertEquals(expectedMethodOut, actual);
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void getEmployeeFullInfo_ValidPosition_ShouldReturnEmployeeFullInfo() {
        Integer input = 3;
        EmployeeFullInfo expected = new EmployeeFullInfo()
                .setName("Salary")
                .setSalary(410000)
                .setPositionName("Developer1");

        when(employeeRepository.getEmployeeFullInfo(input))
                .thenReturn(expected);

        EmployeeFullInfo actual = employeeService.getEmployeeFullInfo(input);
        assertEquals(expected, actual);
        verify(employeeRepository, times(1)).getEmployeeFullInfo(any());
    }

    /*@Test
    void getEmployeePage_ValidPosition_ShouldReturnEmployeeFullInfo() {
        int page = 0;
        int size = 2;
        PageRequest input = PageRequest.of(page, size);
        List<EmployeeDTO> expected = List.of(
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
        List<Employee> expectedRepositoryOut = List.of(
                new Employee()
                        .setId(123)
                        .setName("Denis1")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer1")),
                new Employee()
                        .setId(124)
                        .setName("Denis2")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer2")),
                new Employee()
                        .setId(125)
                        .setName("Denis3")
                        .setSalary(400)
                        .setPosition(new Position().setId(2).setName("Programmer1"))
        );

        when(employeeRepository.findAll())
                .thenReturn(expectedRepositoryOut);

        List<EmployeeDTO> actual = employeeService.getEmployeePage(input);
        assertEquals(expected, actual);
        verify(employeeRepository, times(1)).findAll();
    }*/
}