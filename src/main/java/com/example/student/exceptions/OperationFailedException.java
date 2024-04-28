package com.example.student.exceptions;
/**
 * Copyright (c) 2024 Wasif
 */

import org.springframework.http.HttpStatus;

/**
 * This is a custom exception class for operation failed.
 * It extends {@link ApiException}
 *
 * @author wasif
 * @version 1.0
 * @since 28/04/22
 */
public class OperationFailedException extends ApiException {

    public OperationFailedException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
