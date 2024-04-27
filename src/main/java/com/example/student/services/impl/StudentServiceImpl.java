package com.example.student.services.impl;
/**
 * Copyright (c) 2024 Wasif
 */

import com.example.student.entities.Student;
import com.example.student.exceptions.ResourceNotFoundException;
import com.example.student.repositories.StudentRepository;
import com.example.student.services.StudentService;
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
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //add student
    @Override
    public Student add(Student student){
        return studentRepository.save(student);
    }

    /**
     * This method return the list of {@link BusinessDto}.
     * It converts {@link Student} entity to {@link BusinessDto} by {@link BusinessConverter}
     *
     * @param
     * @return all studentDto entity.
     */
    @Override
    public List<Student> getAll(){
        logger.debug("Into getAll service method");
        List<Student> studentList = studentRepository.findAll();

        if (studentList.isEmpty()) {
            logger.error("No data available!");
            throw new ResourceNotFoundException("No data available!");
        }
        logger.debug("Fetched student list => {}", studentList);
        return studentList.stream()
                .map(businessConverter::businessToBusinessDto)
                .collect(Collectors.toList());
        return studentRepository.findAll();
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
