package com.hibernate.assignment1.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TeamNotFoundExceptionHandler {

  @ExceptionHandler(TeamNotFound.class)
  public ResponseEntity<String> exceptionHandler(TeamNotFound ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

}
