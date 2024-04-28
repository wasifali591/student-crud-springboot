package com.example.student.controllers;
/**
 * Copyright (c) 2024 Wasif
 */

import com.example.student.dtos.commons.StudentDto;
import com.example.student.dtos.requests.StudentRegistrationDto;
import com.example.student.dtos.responses.ApiResponseDto;
import com.example.student.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * This class is a controller class of Student.
 * It processes the request and return the view as response.
 *
 * @author wasif
 * @version 1.0
 * @since 27/04/24
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * This method register new student using phone number.
     *
     * @param studentRegistrationDto- dto to be registered
     * @return json
     */
    @PostMapping
    public ResponseEntity<Object> add(@Valid @RequestBody StudentRegistrationDto studentRegistrationDto) {
        logger.trace("Creating new student entity with registration data => {}", studentRegistrationDto);
        return new ApiResponseDto().generateResponse(studentService.add(studentRegistrationDto), "Successfully registered", HttpStatus.CREATED);
    }

    /**
     * This method is used to get all  {@link StudentDto}.
     *
     * @return json
     */
    @GetMapping
    public ResponseEntity<Object> getAll() {
        logger.trace("Getting all student entity list");
        return new ApiResponseDto().generateResponse(studentService.getAll(), "Successfully data retrieved", HttpStatus.OK);
    }

    /**
     * TThis method is used to get a specific  {@link StudentDto}.
     *
     * @param id - stduent id
     * @return json
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {

        logger.trace("Getting student entity by id => {}", id);
        return new ApiResponseDto().generateResponse(studentService.getById(id), "Successfully data retrieved", HttpStatus.OK);
    }
}