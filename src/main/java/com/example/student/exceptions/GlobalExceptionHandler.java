package com.example.student.exceptions;
/**
 * Copyright (c) 2024 Wasif
 */

import com.example.student.dtos.responses.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller advice class to handle exceptions in centralized way.
 *
 * @author wasif
 * @version 1.0
 * @since 04/05/24
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Exception handler for OperationFailedException.
     *
     * @param ex The OperationFailedException to handle.
     * @return ResponseEntity containing the error response.
     */
    @ExceptionHandler(OperationFailedException.class)
    public ResponseEntity<Object> handleOperationFailedException(Exception ex) {

        String errorMessage = ex.getMessage();
        errorMessage = (null == errorMessage) ? "Internal Server Error" : errorMessage;

        return new ApiResponseDto().generateResponse(null, errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Exception handler for ResourceNotFoundException.
     *
     * @param ex The ResourceNotFoundException to handle.
     * @return ResponseEntity containing the error response.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(Exception ex) {

        String errorMessage = ex.getMessage();
        errorMessage = (null == errorMessage) ? "Internal Server Error" : errorMessage;

        return new ApiResponseDto().generateResponse(null, errorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception handler for ResourceAlreadyExistsException.
     *
     * @param ex The ResourceAlreadyExistsException to handle.
     * @return ResponseEntity containing the error response.
     */
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<Object> handleResourceAlreadyExceptionException(Exception ex) {

        String errorMessage = ex.getMessage();
        errorMessage = (null == errorMessage) ? "Internal Server Error" : errorMessage;

        return new ApiResponseDto().generateResponse(null, errorMessage, HttpStatus.CONFLICT);
    }
}

