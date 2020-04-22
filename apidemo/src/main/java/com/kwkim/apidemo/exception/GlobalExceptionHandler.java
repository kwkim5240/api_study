package com.kwkim.apidemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleException(BaseException e) {
        return new ResponseEntity<>(
                e.getResMap(),
                HttpStatus.valueOf(e.getStatus())
        );
    }

}
