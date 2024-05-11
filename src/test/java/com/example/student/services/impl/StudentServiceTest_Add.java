package com.example.student.services.impl;
/**
 * Copyright (c) 2024 Wasif
 */

import com.example.student.dtos.requests.StudentRegistrationDto;
import com.example.student.entities.Student;
import com.example.student.exceptions.ResourceAlreadyExistsException;
import com.example.student.repositories.StudentRepository;
import com.example.student.services.StudentService;
import com.example.student.utility.converters.impl.StudentConverterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * This is a test class of {@link StudentService}
 *
 * @author wasif
 * @version 1.0
 * @since 29/04/24
 */
@ContextConfiguration(classes = {StudentServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class StudentServiceTest_Add {
    @MockBean
    private StudentRepository studentRepository;
    @MockBean
    private StudentConverterImpl studentConverter;
    @Autowired
    private StudentServiceImpl studentService;

    /**
     * Method under test: {@link StudentService#add(StudentRegistrationDto)}
     */
    @Test
    void testAdd_NewStudent_Success() {
        // Arrange
        StudentRegistrationDto studentRegistrationDto = new StudentRegistrationDto(9876456732L);
        Student student = new Student(1L, "", 9876456732L, "");

        when(studentRepository.findByPhone(studentRegistrationDto.getPhone())).thenReturn(Optional.empty());
        when(studentConverter.studentRegDtoToStudent(studentRegistrationDto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(student);
        when(studentConverter.studentToStudentRegDto(student)).thenReturn(studentRegistrationDto);

        // Act
        StudentRegistrationDto result = studentService.add(studentRegistrationDto);

        // Assert
        assertNotNull(result);
        Assertions.assertEquals(studentRegistrationDto, result); // Check if the returned DTO is the same as the input DTO
        assertSame(studentRegistrationDto, result); // Check if the returned DTO is the same object as the input DTO
        Assertions.assertEquals(studentRegistrationDto.getPhone(), result.getPhone()); // Check if the phone number is preserved
    }

    /**
     * Method under test: {@link StudentService#add(StudentRegistrationDto)}
     */
    @Test
    void testAdd_ExistingStudent_Failure() {
        // Arrange
        StudentRegistrationDto existingStudentDto = new StudentRegistrationDto(1234567890L);

        when(studentRepository.findByPhone(existingStudentDto.getPhone())).thenReturn(Optional.of(new Student(1L, "wasif", 1234567890L, "wasif@mail.com")));

        // Act & Assert
        assertThrows(ResourceAlreadyExistsException.class, () -> studentService.add(existingStudentDto));
    }

    /**
     * Method under test: {@link StudentService#add(StudentRegistrationDto)}
     */
    @Test
    void testAdd_SaveFailed_Failure() {
        // Arrange
        StudentRegistrationDto studentRegistrationDto = new StudentRegistrationDto(9876456732L);
        Student student = new Student(1L, "", 9876456732L, "");

        when(studentRepository.findByPhone(studentRegistrationDto.getPhone())).thenReturn(Optional.empty());
        when(studentConverter.studentRegDtoToStudent(studentRegistrationDto)).thenReturn(student);
        when(studentRepository.save(student)).thenThrow(new RuntimeException("Save failed"));

        // Act and Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> studentService.add(studentRegistrationDto));
        assertEquals("Save failed", exception.getMessage()); // Check exception message
    }

}
