package com.example.student.services;
/**
 * Copyright (c) 2024 Wasif
 */

import com.example.student.dtos.commons.StudentDto;
import com.example.student.dtos.requests.StudentRegistrationDto;

import java.util.List;


public interface StudentService {

    //add student
    StudentRegistrationDto add(StudentRegistrationDto studentRegistrationDto);

    //show all students
    List<StudentDto> getAll();

    StudentDto getById(Long Id);

    StudentDto update(Long id, StudentDto studentDto);

    Boolean delete(Long id);
}

