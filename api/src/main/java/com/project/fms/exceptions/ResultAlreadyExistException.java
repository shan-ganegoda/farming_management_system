package com.project.fms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class ResultAlreadyExistException extends RuntimeException{

    public ResultAlreadyExistException(String message) {
        super(message);
    }
}
