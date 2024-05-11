package com.example.student.utility.converters.impl;
/**
 * Copyright (c) 2024 Wasif
 */

import com.example.student.dtos.commons.StudentDto;
import com.example.student.dtos.requests.StudentRegistrationDto;
import com.example.student.entities.Student;
import com.example.student.utility.converters.StudentConverter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * This class implement an interface {@link StudentConverter}
 * It contain converter logic for {@link Student} and {@link StudentDto}
 *
 * @author wasif
 * @version 1.0
 * @since 27/04/27
 */
@Component
public class StudentConverterImpl implements StudentConverter {

    private final ModelMapper modelMapper;

    public StudentConverterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * This method convert {@link Student} to {@link StudentRegistrationDto}
     *
     * @return {@link StudentRegistrationDto}
     */
    @Override
    public StudentRegistrationDto studentToStudentRegDto(Student student) {
        return modelMapper.map(student, StudentRegistrationDto.class);
    }

    /**
     * This method convert {@link StudentRegistrationDto} to {@link Student}
     *
     * @return {@link Student}
     */
    @Override
    public Student studentRegDtoToStudent(StudentRegistrationDto studentRegistrationDto) {
        return modelMapper.map(studentRegistrationDto, Student.class);
    }

    /**
     * This method convert {@link Student} to {@link StudentDto}
     *
     * @return {@link StudentDto}
     */
    @Override
    public StudentDto studentToStudentDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }

    /**
     * This method convert {@link StudentDto} to {@link Student}
     *
     * @return {@link Student}
     */
    @Override
    public Student studentDtoToStudent(StudentDto studentDto) {
        return modelMapper.map(studentDto, Student.class);
    }

    /**
     * This method convert {@link StudentDto} to {@link Student}
     *
     * @return {@link Student}
     */
    @Override
    public Student toUpdateStudent(StudentDto studentDto, Student student) {
        modelMapper.map(studentDto, student);
        return student;
    }
}
