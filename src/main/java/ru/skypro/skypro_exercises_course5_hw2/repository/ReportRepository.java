package ru.skypro.skypro_exercises_course5_hw2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.skypro.skypro_exercises_course5_hw2.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {

}
