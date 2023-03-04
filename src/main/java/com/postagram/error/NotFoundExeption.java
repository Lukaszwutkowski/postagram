package com.postagram.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExeption extends RuntimeException {

    private static final long serialVersionUID = 123456789L;
    public NotFoundExeption(String message) {
        super(message);
    }
}
