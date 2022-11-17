package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //add student
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    //show all students
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }
}

