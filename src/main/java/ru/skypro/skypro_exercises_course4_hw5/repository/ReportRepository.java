package ru.skypro.skypro_exercises_course4_hw5.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skypro.skypro_exercises_course4_hw5.entity.Report;

public interface ReportRepository extends CrudRepository<Report, Integer> {

}
