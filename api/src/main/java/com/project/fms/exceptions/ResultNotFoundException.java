package com.project.fms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResultNotFoundException extends RuntimeException{

    public ResultNotFoundException(String message) {
        super(message);
    }
}
