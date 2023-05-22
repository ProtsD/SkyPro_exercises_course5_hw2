package ru.skypro.skypro_exercises_course4_hw4.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.skypro.skypro_exercises_course4_hw4.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Getter

public class EmployeeRepositoryImpl implements EmployeeRepository {
    public List<Employee> employeeList = new ArrayList<>();

    @Override
    public void addEmployees(Employee[] employee) {
        employeeList.addAll(List.of(employee));
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
    @Override
    public void putEmployee(Integer id, Employee employee) {
        employee.setId(id);
        int index = employeeList.indexOf(employee);
        employeeList.set(index, employee);
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }
/*    @Override
    public void putEmployee(Map<String, String> params) {
        Employee employee = new Employee();

        Optional<Object> optional = Optional.ofNullable(params.get("id"));
        if (optional.isPresent()) {
            employee.setId(Integer.parseInt(params.get("id")));
        }
        int index = employeeList.indexOf(employee);
        employee = employeeList.get(index);

        optional = Optional.ofNullable(params.get("name"));
        if (optional.isPresent()) {
            employee.setName(params.get("name"));
        }

        optional = Optional.ofNullable(params.get("salary"));
        if (optional.isPresent()) {
            employee.setSalary(Integer.parseInt(params.get("salary")));
        }

        index = employeeList.indexOf(employee);
        employeeList.set(index, employee);

        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }*/

    @Override
    public Employee getEmployee(Integer id) {
        Employee employee = new Employee();
        employee.setId(id);
        int index = employeeList.indexOf(employee);
        return employeeList.get(index);
    }

    @Override
    public void delEmployee(Integer id) {
        Employee employee = new Employee();
        employee.setId(id);
        int index = employeeList.indexOf(employee);
        employeeList.remove(index);
    }

    @Override
    public List<Employee> getsalaryHigherThan(int salary) {
        return employeeList.stream().filter((s) -> s.getSalary() > salary).collect(Collectors.toList());
    }

    public int getSize() {
        return employeeList.size();
    }
}
