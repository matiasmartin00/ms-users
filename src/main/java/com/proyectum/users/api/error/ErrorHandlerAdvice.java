package com.proyectum.users.api.error;

import com.proyectum.model.Error;
import com.proyectum.users.boot.config.ddd.exceptions.UnknownCommandHandlerException;
import com.proyectum.users.boot.config.ddd.exceptions.UnknownQueryHandlerException;
import com.proyectum.users.domain.error.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ErrorHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.warn("MethodArgumentNotValidException", exception);
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

    @ExceptionHandler({EmailAlreadyExistsError.class, UsernameAlreadyExistsError.class, RoleNameAlreadyExistsError.class})
    public ResponseEntity<Error> badRequestsError(DomainError exception) {
        log.warn("BadRequestsError", exception);
        var error = new Error();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        var message = exception.getMessage();
        error.setMessage(message);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler({DomainError.class})
    public ResponseEntity<Error> internalServerError(DomainError exception) {
        log.error("internalServerError", exception);
        var error = new Error();
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        var message = exception.getMessage();
        error.setMessage(message);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Error> genericInternalServerError(Exception exception) {
        log.error("genericInternalServerError", exception);
        var error = new Error();
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        var message = exception.getMessage();
        error.setMessage(message);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<Error> genericBadRequestsError(RuntimeException exception) {
        log.warn("genericBadRequestsError", exception);
        var error = new Error();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        var message = exception.getMessage();
        error.setMessage(message);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }


    @ExceptionHandler({UserAlreadyExistsError.class, RoleAlreadyExistsError.class})
    public ResponseEntity<Error> conflictRequestsError(DomainError exception) {
        log.warn("conflictRequestsError", exception);
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
        log.warn("unauthorizedRequestsError", exception);
        var error = new Error();
        error.setCode(HttpStatus.UNAUTHORIZED.value());
        var message = exception.getMessage();
        error.setMessage(message);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(error);
    }

    @ExceptionHandler({RoleNotFoundError.class})
    public ResponseEntity<Error> notFoundRequestsError(DomainError exception) {
        log.warn("notFoundRequestsError", exception);
        var error = new Error();
        error.setCode(HttpStatus.NOT_FOUND.value());
        var message = exception.getMessage();
        error.setMessage(message);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler({UnknownQueryHandlerException.class, UnknownCommandHandlerException.class})
    public ResponseEntity<Error> internalRequestsError(DomainError exception) {
        log.error("internalRequestsError", exception);
        var error = new Error();
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        var message = exception.getMessage();
        error.setMessage(message);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }
}
