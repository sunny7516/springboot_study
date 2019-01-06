package com.example.demo2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvicer {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public String badRequest(Throwable throwable){
        System.out.println(throwable.getMessage());
        return "http status code : 400";
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String root(Exception e){
        System.out.println(e.getMessage());
        return "http status code : 500";
    }
}
