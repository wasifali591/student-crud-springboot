package com.example.student.exceptions;
/**
 * Copyright (c) 2024 Wasif
 */

import org.springframework.http.HttpStatus;

/**
 * This is a custom exception class for already exist resource.
 * It extends {@link ApiException}
 *
 * @author wasif
 * @version 1.0
 * @since 28/04/24
 */
public class ResourceAlreadyExistsException extends ApiException {
    public ResourceAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }

}
