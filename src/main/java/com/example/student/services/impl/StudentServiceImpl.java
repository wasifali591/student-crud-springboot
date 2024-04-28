package com.example.student.services.impl;
/**
 * Copyright (c) 2024 Wasif
 */

import com.example.student.dtos.commons.StudentDto;
import com.example.student.dtos.requests.StudentRegistrationDto;
import com.example.student.entities.Student;
import com.example.student.exceptions.OperationFailedException;
import com.example.student.exceptions.ResourceAlreadyExistsException;
import com.example.student.exceptions.ResourceNotFoundException;
import com.example.student.repositories.StudentRepository;
import com.example.student.services.StudentService;
import com.example.student.util.converters.StudentConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class implement an interface {@link StudentService}
 * It contain different business logic for Student
 *
 * @author wasif
 * @version 1.0
 * @since 27/04/24
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public StudentServiceImpl(StudentRepository studentRepository, StudentConverter studentConverter) {
        this.studentRepository = studentRepository;
        this.studentConverter = studentConverter;
    }

    /**
     * This method register new {@link Student}.
     * It gets phone number from {@link StudentDto} body,
     * if phone number is not registered then {@link StudentDto} convert to {@link Student} by {@link StudentConverter},
     * and save {@link Student}.
     *
     * @param studentRegistrationDto -studentDto to be registered
     * @return studentRegistrationDto entity
     */
    @Override
    public StudentRegistrationDto add(StudentRegistrationDto studentRegistrationDto) {
        logger.debug("Into add entity service method with data =>{}", studentRegistrationDto);
        if (studentRepository.findByPhoneNo(studentRegistrationDto.getPhone()).isPresent()) {
            logger.error("Business data already exist =>{}", studentRegistrationDto);
            throw new ResourceAlreadyExistsException("Already Exists!");
        }
        Student student = studentConverter.studentRegDtoToStudent(studentRegistrationDto);
        logger.debug("Converted student entity => {} from DTO", student);
        student = studentRepository.save(student);
        logger.debug("Record saved =>{} in DB", student);
        //Check student is created or not
        if (null == student.getId()) {
            logger.error("Failed to save business in DB => {}", student);
            throw new OperationFailedException("Failed to create student");
        }

        StudentRegistrationDto registrationDto = studentConverter.studentToStudentRegDto(student);
        logger.debug("Converted DTO => {} from student entity", registrationDto);
        return registrationDto;
    }

    /**
     * This method return the list of {@link StudentDto}.
     * It converts {@link Student} entity to {@link StudentDto} by {@link StudentConverter}
     *
     * @param
     * @return all studentDto entity.
     */
    @Override
    public List<StudentDto> getAll() {
        logger.debug("Into getAll service method");
        List<Student> studentList = studentRepository.findAll();

        if (studentList.isEmpty()) {
            logger.error("No data available!");
            throw new ResourceNotFoundException("No data available!");
        }
        logger.debug("Fetched student list => {}", studentList);
        return studentList.stream()
                .map(studentConverter::studentToStudentDto)
                .collect(Collectors.toList());
//        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getById(Long Id) {
        return studentRepository.findById(Id);
    }

    @Override
    public Student update(Long Id, Student student) {
        return null;
    }

    @Override
    public void delete(Long Id) {

    }
}
