package com.proyectum.users.api.error;

import com.proyectum.model.Error;
import com.proyectum.users.domain.error.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var error = new Error();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        var message = exception.getBindingResult().getFieldErrors()
                        .stream()
                        .map(fieldError -> String.format("%s: %s", fieldError.getField(), fieldError.getDefaultMessage()))
                        .collect(Collectors.joining(" - "));
        error.setMessage(message);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler({EmailAlreadyExistsError.class, UsernameAlreadyExistsError.class})
    public ResponseEntity<Error> badRequestsError(DomainError exception) {
        var error = new Error();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        var message = exception.getMessage();
        error.setMessage(message);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler({UserAlreadyExistsError.class})
    public ResponseEntity<Error> conflictRequestsError(DomainError exception) {
        var error = new Error();
        error.setCode(HttpStatus.CONFLICT.value());
        var message = exception.getMessage();
        error.setMessage(message);
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }

    @ExceptionHandler({InvalidCredentialsError.class})
    public ResponseEntity<Error> unauthorizedRequestsError(DomainError exception) {
        var error = new Error();
        error.setCode(HttpStatus.UNAUTHORIZED.value());
        var message = exception.getMessage();
        error.setMessage(message);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(error);
    }
}
