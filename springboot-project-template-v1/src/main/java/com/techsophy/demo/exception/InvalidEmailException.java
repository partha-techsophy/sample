package com.techsophy.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidEmailException extends Exception{
    private static final long serialVersionUID = 1L;

    public InvalidEmailException(String message){
        super(message);
    }

}
