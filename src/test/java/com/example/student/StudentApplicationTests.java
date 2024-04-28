package com.example.student;

import com.example.student.dtos.requests.StudentRegistrationDto;
import com.example.student.entities.Student;
import com.example.student.repositories.StudentRepository;
import com.example.student.services.StudentService;
import com.example.student.util.converters.StudentConverter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class StudentApplicationTests {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentConverter studentConverter;
    @MockBean
    private StudentRepository studentRepository;

//    @Test
//    public void addStudentTest() {
//        StudentRegistrationDto studentRegistrationDto = new StudentRegistrationDto("6754738746");
//        Student student = studentConverter.studentRegDtoToStudent(studentRegistrationDto);
//        when(studentRepository.save(student)).thenReturn(student);
//        assertEquals(studentRegistrationDto, studentService.add(studentRegistrationDto));
//    }
//
//    @Test
//    public void getStudentTest() {
//        when(studentRepository.findAll()).thenReturn(Stream.of(
//                        new Student(2l, "nilam", "6754738746", "nilam@mail.com"),
//                        new Student(3l, "altaf", "6754738746", "altaf@mail.com"),
//                        new Student(4l, "altaf", "6754738746", "altaf@mail.com"))
//                .collect(Collectors.toList()));
//        assertEquals(3, studentService.getAll().size());
//    }

}
