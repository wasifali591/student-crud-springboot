package com.example.student.exceptions;
/**
 * Copyright (c) 2024 Wasif
 */

import org.springframework.http.HttpStatus;

/**
 * This is a custom exception class.
 * It extends {@link RuntimeException}.
 *
 * @author wasif
 * @version 1.0
 * @since 27/04/24
 */
public class ApiException extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;

    public ApiException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
