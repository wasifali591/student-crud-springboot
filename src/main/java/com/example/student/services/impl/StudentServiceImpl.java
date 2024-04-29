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
     * @param studentRegistrationDto - studentDto to be registered
     * @return studentRegistrationDto - entity
     */
    @Override
    public StudentRegistrationDto add(StudentRegistrationDto studentRegistrationDto) {
        logger.debug("Into add entity service method with data =>{}", studentRegistrationDto);
        if (studentRepository.findByPhone(studentRegistrationDto.getPhone()).isPresent()) {
            logger.error("Student data already exist =>{}", studentRegistrationDto);
            throw new ResourceAlreadyExistsException("Already Exists!");
        }
        Student student = studentConverter.studentRegDtoToStudent(studentRegistrationDto);
        logger.debug("Converted student entity => {} from DTO", student);
        student = studentRepository.save(student);
        logger.debug("Record saved =>{} in DB", student);
        //Check student is created or not
        if (null == student.getId()) {
            logger.error("Failed to save student in DB => {}", student);
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
        return studentList.stream().map(studentConverter::studentToStudentDto).collect(Collectors.toList());
    }

    /**
     * This method return the information of {@link StudentDto}.
     *
     * @param id - student id
     * @return studentDto entity.
     */
    @Override
    public StudentDto getById(Long id) {
        logger.debug("Into get entity service method with id => {}", id);
        Optional<Student> optionalStudent;

        optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isEmpty()) {
            logger.error("No data available!");
            throw new ResourceNotFoundException("No data available!");
        }
        Student student = optionalStudent.get();
        logger.debug("Fetched student entity => {}", student);
        StudentDto studentDto = studentConverter.studentToStudentDto(student);
        logger.debug("Converted DTO => {} from student entity", studentDto);
        return studentDto;
    }

    /**
     * This method update {@link Student} identified by studentID.
     * It finds {@link Student} by id and update its changes by converting {@link StudentDto} to {@link Student},
     * using {@link StudentConverter} and save it.
     *
     * @param id         - id of the entity to find. Must not be null.
     * @param studentDto - StudentDto to be updated
     * @return StudentDto entity
     */
    @Override
    public StudentDto update(Long id, StudentDto studentDto) {
        logger.debug("Into update entity service method with id => {} and data => {}", id, studentDto);
        if (!studentRepository.existsById(id)) {
            logger.error("Resource doesn't exist!");
            throw new ResourceNotFoundException("Resource doesn't exist!");
        }

        Student student = studentConverter.studentDtoToStudent(studentDto);
        logger.debug("Converted student entity => {} from DTO => {}", student, studentDto);
        student.setId(id);
        student = studentRepository.save(student);
        logger.debug("Student record updated in DB=>{}", student);
        StudentDto dto = studentConverter.studentToStudentDto(student);
        logger.debug("Converted DTO => {} from student entity", dto);
        return dto;
    }

    /**
     * This method delete the {@link Student} entity identified by the given id
     *
     * @param id - the id of the entity to be deleted. Must not be null.
     * @return true of false
     */
    @Override
    public Boolean delete(Long id) {
        logger.debug("Into delete entity service method with id => {}", id);
        // Validate.
        if (studentRepository.findById(id).isEmpty()) {
            logger.error("Resource doesn't exist!");
            throw new ResourceNotFoundException("Resource doesn't exist!");
        }

        Student student = studentRepository.getById(id);
        logger.debug("Fetching student entity by id => {} from DB using repository", id);
        studentRepository.deleteById(id);
        logger.debug("Business entity deleted from DB=>{}", student);
        return true;

    }
}
