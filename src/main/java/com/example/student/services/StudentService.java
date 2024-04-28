package com.example.student.services;

import com.example.student.dtos.commons.StudentDto;
import com.example.student.dtos.requests.StudentRegistrationDto;
import com.example.student.entities.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    //add student
    public StudentRegistrationDto add(StudentRegistrationDto studentRegistrationDto);

    //show all students
    public List<StudentDto> getAll();

    public Optional<Student> getById(Long Id);

    public Student update(Long Id, Student student);

    public void delete(Long Id);
}

