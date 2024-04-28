package com.example.student.controllers;
/**
 * Copyright (c) 2024 Wasif
 */

import com.example.student.dtos.commons.StudentDto;
import com.example.student.dtos.responses.ApiResponseDto;
import com.example.student.entities.Student;
import com.example.student.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student newStudent = studentService.add(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    /**
     * This method is used to get all  {@link StudentDto}.
     *
     * @return json
     */
    @GetMapping
    public ResponseEntity<Object> getAll(){
        logger.trace("Getting all business entity list");
        return new ApiResponseDto().generateResponse(studentService.getAll(), "Successfully data retrieved", HttpStatus.OK);
    }
}