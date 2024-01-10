package com.example.microtest.config;

import com.example.microtest.dto.ErrorDTO;
import com.example.microtest.util.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(AppException appException){
        return ResponseEntity.status(appException.getHttpStatus()).body(new ErrorDTO(appException.getMessage()));
    }
}
