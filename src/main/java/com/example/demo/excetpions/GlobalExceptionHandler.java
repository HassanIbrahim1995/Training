package com.example.demo.excetpions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<Problem> handleEmployeeNotFoundException(EmployeeException ex) {
        Problem problem = Problem.builder()
                .withStatus(Status.NOT_FOUND)
                .withTitle("Employee not found")
                .withDetail(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }

}
