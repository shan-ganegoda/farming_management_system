package com.project.fms.advisor;

import com.project.fms.dtos.StandardResponse;
import com.project.fms.exceptions.ResultAlreadyExistException;
import com.project.fms.exceptions.ResultNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ResultNotFoundException.class)
    public ResponseEntity<StandardResponse> handleResourceNotFoundException(ResultNotFoundException exception){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error",exception), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ResultAlreadyExistException.class)
    public ResponseEntity<StandardResponse> handleResourceAlreadyExistException(ResultAlreadyExistException exception){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(302,"Error",exception), HttpStatus.FOUND
        );
    }
}
