package com.example.student;

import com.example.student.entities.Student;
import com.example.student.repositories.StudentRepository;
import com.example.student.services.StudentService;
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
	@MockBean
	private StudentRepository studentRepository;

	@Test
	public void addStudentTest(){
		Student student = new Student(2l,"ha ha ha", "6754738746", "nilam@mail.com");
		when(studentRepository.save(student)).thenReturn(student);
		assertEquals(student, studentService.add(student));
	}

	@Test
	public void getStudentTest(){
		when(studentRepository.findAll()).thenReturn(Stream.of(
				new Student(2l,"nilam", "6754738746", "nilam@mail.com"),
				new Student(3l,"altaf", "6754738746", "altaf@mail.com"),
				new Student(4l,"altaf", "6754738746", "altaf@mail.com"))
				.collect(Collectors.toList()));
		assertEquals(3, studentService.getAll().size());
	}

}
