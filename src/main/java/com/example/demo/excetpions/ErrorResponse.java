package com.example.demo.excetpions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class ErrorResponse {
    private HttpStatus status;
    private String message;
    private List<String> errors;
}
