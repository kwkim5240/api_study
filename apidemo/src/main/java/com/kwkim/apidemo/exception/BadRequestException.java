package com.kwkim.apidemo.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException {
    public BadRequestException(String error, String message) {
        super(HttpStatus.BAD_REQUEST.value(),error, message);
    }
}
