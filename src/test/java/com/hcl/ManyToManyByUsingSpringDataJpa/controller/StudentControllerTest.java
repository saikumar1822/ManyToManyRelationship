package com.hcl.ManyToManyByUsingSpringDataJpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import com.hcl.ManyToManyByUsingSpringDataJpa.exceptions.StudentNotFoundException;
import com.hcl.ManyToManyByUsingSpringDataJpa.model.Course;
import com.hcl.ManyToManyByUsingSpringDataJpa.model.Student;
import com.hcl.ManyToManyByUsingSpringDataJpa.service.StudentService;
import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StudentControllerTest {
	@InjectMocks
	StudentController studentController;

	@Mock
	StudentService studentService;

	@Test
	public void testSaveStudentForPositive() {
		Student student = new Student();
		student.setName("sai");
		student.setId(1l);
		student.setEmail("sai@gmail.com");
		List<Course> courses = new ArrayList();
		Course course = new Course();
		course.setId(12l);
		course.setTitle("Spring");
		courses.add(course);
		student.setCourses(courses);
		Mockito.when(studentService.saveStudent(Mockito.any(Student.class))).thenReturn((student));
		ResponseEntity<Student> resStudent = studentController.saveStudent(student);
		Assert.assertNotNull(resStudent);
		Assert.assertEquals(student.getName(), "sai");
	}

	@Test
	public void testSaveStudentForNegative() {
		Student student1 = new Student();
		student1.setName("sai");
		student1.setId(1l);
		Student student = new Student();
		student.setName("sai");
		student.setId(1l);
		student.setEmail("sai@gmail.com");
		List<Course> courses = new ArrayList();
		Course course = new Course();
		course.setId(12l);
		course.setTitle("Spring");
		courses.add(course);
		student.setCourses(courses);
		Mockito.when(studentService.saveStudent(Mockito.any(Student.class))).thenReturn((student1));
		ResponseEntity<Student> resStudent = studentController.saveStudent(student);
		Assert.assertNotNull(resStudent);
		Assert.assertEquals(student.getName(), "sai");
	}

	@Test(expected = NullPointerException.class)
	public void testSaveStudentForExce() {
		Student student = new Student();
		Mockito.when(studentService.saveStudent(Mockito.any(Student.class))).thenThrow(NullPointerException.class);
		Student resStudent = studentService.saveStudent(student);
	}

	@Test
	public void testFindByIdForPositive() {
		Student student = new Student();
		student.setName("sai");
		student.setId(1l);
		student.setEmail("sai@gmail.com");
		List<Course> courses = new ArrayList();
		Course course = new Course();
		course.setId(12l);
		course.setTitle("Spring");
		courses.add(course);
		student.setCourses(courses);
		Mockito.when(studentService.getStudent(1l)).thenReturn(student);
		ResponseEntity<Student> resStudent = studentController.getStudent(1l);
		Assert.assertNotNull(resStudent);
	}

	@Test
	public void testGetAllStudentsForPosite() {
		List<Student> students = new ArrayList();
		Student student = new Student();
		student.setName("kumar");
		student.setId(2l);
		student.setEmail("kumar@gmail.com");
		List<Course> courses = new ArrayList();
		Course course = new Course();
		course.setId(12l);
		course.setTitle("SpringBoot");
		courses.add(course);
		student.setCourses(courses);
		students.add(student);
		Mockito.when(studentService.getAllStudents()).thenReturn(students);
		ResponseEntity<List<Student>> resStudents =  studentController.getAllStudents();
		Assert.assertNotNull(resStudents);
		Assert.assertEquals(1, students.size());

	}

	@Test(expected = NullPointerException.class)
	public void testGetAllStudentsForExc() {
		Mockito.when(studentService.getAllStudents()).thenThrow(NullPointerException.class);
		List<Student> resStudents = (List<Student>) studentController.getAllStudents();

	}

}
