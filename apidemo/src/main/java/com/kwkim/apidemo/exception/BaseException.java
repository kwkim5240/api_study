package com.kwkim.apidemo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class BaseException extends RuntimeException {
    Date timestamp = new Date();
    @Getter
    final Integer status;
    final String error;
    final String message;

    public Map<String, Object> getResMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", timestamp);
        map.put("status", status);
        map.put("error", error);
        map.put("message", message);
        return map;
    }
}
