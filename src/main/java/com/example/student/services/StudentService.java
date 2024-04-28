package com.example.student.services;
/**
 * Copyright (c) 2024 Wasif
 */

import com.example.student.dtos.commons.StudentDto;
import com.example.student.dtos.requests.StudentRegistrationDto;
import com.example.student.entities.Student;

import java.util.List;

/**
 * This interface provides create, retrieve, update and delete operation for student.
 *
 * @author wasif
 * @version 1.0
 * @since 28/04/24
 */
public interface StudentService {

    /**
     * This method add nre {@link Student}.
     *
     * @param studentRegistrationDto - businessDto to be registered
     * @return {@link StudentRegistrationDto}
     */
    StudentRegistrationDto add(StudentRegistrationDto studentRegistrationDto);

    /**
     * This method return the list of {@link Student}
     *
     * @return list of {@link StudentDto}
     */
    List<StudentDto> getAll();

    /**
     * This method return a specific {@link StudentDto} entity identified by the {@link Student} id.
     *
     * @param id - - id of the entity to find. Must not be null.
     * @return {@link StudentDto}
     */
    StudentDto getById(Long id);

    /**
     * This method update {@link Student} identified by student id.
     *
     * @param id         - id of the entity to update. Must not be null.
     * @param studentDto - {@link StudentDto} to be updated
     * @return {@link StudentDto}
     */
    StudentDto update(Long id, StudentDto studentDto);

    /**
     * This method delete the {@link Student} entity identified by the given id.
     *
     * @param id - id of the {@link Student} entity to delete. Must not be null.
     * @return true or false
     */
    Boolean delete(Long id);
}

