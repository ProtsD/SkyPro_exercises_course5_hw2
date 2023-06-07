package ru.skypro.skypro_exercises_course4_hw6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.skypro.skypro_exercises_course4_hw6.dto.EmployeeDTO;
import ru.skypro.skypro_exercises_course4_hw6.dto.EmployeeFullInfo;
import ru.skypro.skypro_exercises_course4_hw6.entity.Employee;
import ru.skypro.skypro_exercises_course4_hw6.entity.Position;
import ru.skypro.skypro_exercises_course4_hw6.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public void addEmployees(EmployeeDTO[] employeeDTO) {
        employeeRepository.saveAll(Arrays.stream(employeeDTO).map(EmployeeDTO::toEmployee).toList());
    }

    @Override
    public void addEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(employeeDTO.toEmployee());
    }

    @Override
    public void putEmployee(Integer id, EmployeeDTO employeeDTO) {
        if (employeeRepository.existsById(id)) {
            employeeDTO.setId(id);
            employeeRepository.save(employeeDTO.toEmployee());
        }
    }

    @Override
    public EmployeeDTO getEmployee(Integer id) {
        if (employeeRepository.findById(id).isPresent()) {
            return EmployeeDTO.fromEmployee(employeeRepository.findById(id).get());
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void delEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getEmployeeWithSalaryHigherThan(int salary) {
        return employeeRepository.getSalaryHigherThan(salary).stream().map(EmployeeDTO::fromEmployee).toList();
    }

    @Override
    public List<EmployeeDTO> getEmployeesWithHighestSalary() {
        return employeeRepository.getEmployeesWithHighestSalary().stream().map(EmployeeDTO::fromEmployee).toList();
    }

    @Override
    public List<EmployeeDTO> getEmployeesOnPosition(Integer position) {
        List<EmployeeDTO> EmployeeDTOList = new ArrayList<>();
        if (Optional.ofNullable(position).isPresent()) {
            for (Employee employee : employeeRepository.findAll()) {
                Position EmployeePosition = employee.getPosition();
                if (Optional.ofNullable(EmployeePosition).isPresent()) {
                    if (EmployeePosition.getId().equals(position)) {
                        EmployeeDTOList.add(EmployeeDTO.fromEmployee(employee));
                    }
                }
            }
        } else {
            employeeRepository.findAll().forEach(employee -> EmployeeDTOList.add(EmployeeDTO.fromEmployee(employee)));
        }
        return EmployeeDTOList;
    }

    @Override
    public EmployeeFullInfo getEmployeeFullInfo(Integer id) {
        return employeeRepository.getEmployeeFullInfo(id);
    }

    @Override
    public List<EmployeeDTO> getEmployeePage(PageRequest pageRequest) {
        List<EmployeeDTO> employeesList = employeeRepository.findAll(pageRequest).stream().map(EmployeeDTO::fromEmployee).toList();
        return employeesList;
    }
}
