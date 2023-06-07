package ru.skypro.skypro_exercises_course4_hw6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.skypro_exercises_course4_hw6.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLogin(String login);
}
