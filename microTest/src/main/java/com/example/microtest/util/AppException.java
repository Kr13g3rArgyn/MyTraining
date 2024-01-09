package com.example.microtest.util;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException{
    private final HttpStatus httpStatus;

        public AppException(String message, HttpStatus notFound){
            super(message);
            this.httpStatus = notFound;
        }
        public HttpStatus getHttpStatus(){
            return httpStatus;
        }
}
