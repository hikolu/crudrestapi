package com.hikolu.crudrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class DriversExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<DriversErrorResponse> handleException(DriverNotFoundException exc) {

        // create a response entity
        DriversErrorResponse error = new DriversErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setSuccess(Boolean.FALSE);

        // return response entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<DriversErrorResponse> handleException(BadRequestException exc) {

        DriversErrorResponse error = new DriversErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setSuccess(Boolean.FALSE);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<DriversErrorResponse> handleException(MethodArgumentTypeMismatchException exc) {

        DriversErrorResponse error = new DriversErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setSuccess(Boolean.FALSE);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
