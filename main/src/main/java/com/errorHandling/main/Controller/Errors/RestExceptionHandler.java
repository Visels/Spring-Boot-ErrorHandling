package com.errorHandling.main.Controller.Errors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(HttpServletRequest req, NoSuchElementException ex){


        return null;
    }


    //incorrect sql post response --> missing some certain value in the post request body
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleSqlIntegrityConstraintViolationException(HttpServletRequest req, SQLIntegrityConstraintViolationException ex){

        String error = "Unable to submit post request:" + ex.getMessage();
        return null;
    }


    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {

        return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
    }



}
