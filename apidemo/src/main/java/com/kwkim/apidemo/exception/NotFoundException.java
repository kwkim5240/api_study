package com.kwkim.apidemo.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
    public NotFoundException(String error, String message) {
        super(HttpStatus.NOT_FOUND.value(),error, message);
    }
}
