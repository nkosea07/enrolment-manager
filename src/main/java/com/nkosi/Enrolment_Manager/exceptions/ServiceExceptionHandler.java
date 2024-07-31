package com.nkosi.Enrolment_Manager.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nkosi.Enrolment_Manager.dtos.CustomErrorMessage;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.ErrorMessage;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

@Slf4j
@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Object> duplicateKeyExceptionExceptionHandler(DuplicateKeyException ex) {
        CustomErrorMessage customError = new CustomErrorMessage();
        customError.setEventTime(ZonedDateTime.now());
        customError.setTitle("Duplicate Key Exception");
        customError.setMessage("Duplicate key constraint violation error occurred");
        customError.setDescription(ex.getLocalizedMessage());
        customError.setCode(HttpStatus.BAD_REQUEST);
        log.error(customError.toString(), ex);
        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> entityNotFoundExceptionHandler(EntityNotFoundException ex) {
        CustomErrorMessage customError = new CustomErrorMessage();
        customError.setEventTime(ZonedDateTime.now());
        customError.setMessage("Error occurred in the Data Access Object: Request to commit a transaction by accessing the data object failed");
        customError.setDescription("One or more requested objects not found, causing violation of constraints");
        customError.setCode(HttpStatus.NOT_FOUND);
        log.error(customError.toString(), ex);
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }

 }


