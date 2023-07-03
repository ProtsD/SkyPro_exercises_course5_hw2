package ru.skypro.skypro_exercises_course5_hw1.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.skypro.skypro_exercises_course5_hw1.dto.EmployeeDTO;
import ru.skypro.skypro_exercises_course5_hw1.dto.EmployeeFullInfo;
import ru.skypro.skypro_exercises_course5_hw1.entity.Employee;
import ru.skypro.skypro_exercises_course5_hw1.entity.Position;
import ru.skypro.skypro_exercises_course5_hw1.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Override
    public void addEmployees(EmployeeDTO[] employeeDTO) {
        logger.info("Invoke addEmployees() with argument: employeeDTO={}", Arrays.stream(employeeDTO).toList());
        employeeRepository.saveAll(Arrays.stream(employeeDTO).map(EmployeeDTO::toEmployee).toList());
        logger.debug("addEmployees() is processed ok");
    }

    @Override
    public void addEmployee(EmployeeDTO employeeDTO) {
        logger.info("Invoke addEmployee() with argument: employeeDTO={}", employeeDTO);
        employeeRepository.save(employeeDTO.toEmployee());
        logger.debug("addEmployee() is processed ok");
    }

    @Override
    public void putEmployee(Integer id, EmployeeDTO employeeDTO) {
        logger.info("Invoke putEmployee() with argument: id={}, employeeDTO={}", id, employeeDTO);
        if (employeeRepository.existsById(id)) {
            employeeDTO.setId(id);
            employeeRepository.save(employeeDTO.toEmployee());
            logger.debug("putEmployee() is processed ok");
        }
    }

    @Override
    public EmployeeDTO getEmployee(Integer id) {
        logger.info("Invoke getEmployee() with argument: id={}", id);
        if (employeeRepository.findById(id).isPresent()) {
            EmployeeDTO employeeDTO = EmployeeDTO.fromEmployee(employeeRepository.findById(id).get());
            logger.debug("putEmployee() is processed ok");
            return employeeDTO;
        }
        logger.error("Invoke getEmployee() with argument: id={}. There is no employee with the id.", id);
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void delEmployee(Integer id) {
        logger.info("Invoke delEmployee() with argument: id={}", id);
        employeeRepository.deleteById(id);
        logger.debug("delEmployee() is processed ok");
    }

    @Override
    public List<EmployeeDTO> getEmployeeWithSalaryHigherThan(int salary) {
        logger.info("Invoke getEmployeeWithSalaryHigherThan() with argument: salary={}", salary);
        List<EmployeeDTO> listEmployeeDTO = employeeRepository.getSalaryHigherThan(salary).stream().map(EmployeeDTO::fromEmployee).toList();
        logger.debug("getEmployeeWithSalaryHigherThan() is processed ok");
        return listEmployeeDTO;
    }

    @Override
    public List<EmployeeDTO> getEmployeesWithHighestSalary() {
        logger.info("Invoke getEmployeesWithHighestSalary() w/o arguments");
        List<EmployeeDTO> listEmployeeDTO = employeeRepository.getEmployeesWithHighestSalary().stream().map(EmployeeDTO::fromEmployee).toList();
        logger.debug("getEmployeesWithHighestSalary() is processed ok");
        return listEmployeeDTO;
    }

    @Override
    public List<EmployeeDTO> getEmployeesOnPosition(Integer position) {
        logger.info("Invoke getEmployeesOnPosition() with argument: position={}", position);
        List<EmployeeDTO> EmployeeDTOList = new ArrayList<>();
        if (Optional.ofNullable(position).isPresent()) {
            for (Employee employee : employeeRepository.findAll()) {
                Position EmployeePosition = employee.getPosition();
                if (Optional.ofNullable(EmployeePosition).isPresent()) {
                    if (EmployeePosition.getId().equals(position)) {
                        EmployeeDTOList.add(EmployeeDTO.fromEmployee(employee));
                        logger.debug("getEmployeesOnPosition() is processed ok");
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
        logger.info("Invoke getEmployeeFullInfo() with argument: id={}", id);
        EmployeeFullInfo employeeInfo = employeeRepository.getEmployeeFullInfo(id);
        logger.debug("getEmployeeFullInfo() is processed ok");
        return employeeInfo;
    }

    @Override
    public List<EmployeeDTO> getEmployeePage(PageRequest pageRequest) {
        logger.info("Invoke getEmployeePage() with argument: pageRequest={}", pageRequest);
        List<EmployeeDTO> employeesList = employeeRepository.findAll(pageRequest).stream().map(EmployeeDTO::fromEmployee).toList();
        logger.debug("getEmployeePage() is processed ok");
        return employeesList;
    }
}
