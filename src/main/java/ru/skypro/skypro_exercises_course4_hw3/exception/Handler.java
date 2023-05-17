package ru.skypro.skypro_exercises_course4_hw3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.SQLException;

@RestControllerAdvice
public class Handler {
    @ExceptionHandler(value = {SQLException.class, IOException.class})
    public ResponseEntity<?> handlerSQLException(SQLException sqlException) {
       return new ResponseEntity<>(sqlException.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
