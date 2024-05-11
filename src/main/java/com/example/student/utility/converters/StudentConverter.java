package com.example.student.utility.converters;
/**
 * Copyright (c) 2024 Wasif
 */

import com.example.student.dtos.commons.StudentDto;
import com.example.student.dtos.requests.StudentRegistrationDto;
import com.example.student.entities.Student;

/**
 * This is a converter interface.
 * It is used to map {@link Student} entity class with {@link StudentDto} dto class.
 *
 * @author wasif
 * @version 1.0
 * @since 27/04/24
 */
public interface StudentConverter {
    /**
     * This method convert {@link Student} to {@link StudentRegistrationDto}
     *
     * @return {@link StudentRegistrationDto}
     */
    StudentRegistrationDto studentToStudentRegDto(Student student);

    /**
     * This method convert {@link StudentRegistrationDto} to {@link Student}
     *
     * @return {@link Student}
     */
    Student studentRegDtoToStudent(StudentRegistrationDto studentRegistrationDto);

    /**
     * This method convert {@link Student} to {@link StudentDto}
     *
     * @return {@link StudentDto}
     */
    StudentDto studentToStudentDto(Student student);

    /**
     * This method convert {@link StudentDto} to {@link Student}
     *
     * @return {@link Student}
     */
    Student studentDtoToStudent(StudentDto studentDto);

    /**
     * This method update existing {@link Student} by {@link StudentDto}
     *
     * @return {@link Student}
     */
    Student toUpdateStudent(StudentDto studentDto, Student student);
}
