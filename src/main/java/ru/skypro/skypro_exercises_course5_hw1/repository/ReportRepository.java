package ru.skypro.skypro_exercises_course5_hw1.repository;

import org.springframework.data.repository.CrudRepository;
import ru.skypro.skypro_exercises_course5_hw1.entity.Report;

public interface ReportRepository extends CrudRepository<Report, Integer> {

}
