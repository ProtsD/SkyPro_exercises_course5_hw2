package ru.skypro.skypro_exercises_course5_hw2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.skypro_exercises_course5_hw2.dto.EmployeeFullInfo;
import ru.skypro.skypro_exercises_course5_hw2.dto.ReportDTO;
import ru.skypro.skypro_exercises_course5_hw2.entity.Employee;
import ru.skypro.skypro_exercises_course5_hw2.entity.Position;

import java.util.List;

public interface PositionRepository extends CrudRepository<Position, Integer> {

}
