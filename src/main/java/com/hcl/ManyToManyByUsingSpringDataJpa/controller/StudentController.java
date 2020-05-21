package com.hcl.ManyToManyByUsingSpringDataJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ManyToManyByUsingSpringDataJpa.model.Course;
import com.hcl.ManyToManyByUsingSpringDataJpa.model.Student;
import com.hcl.ManyToManyByUsingSpringDataJpa.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student student1=studentService.saveStudent(student);
		return new ResponseEntity<Student>(student1, HttpStatus.OK);
	}

	@PutMapping("/student")
	public ResponseEntity<String> UpdateStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return new ResponseEntity<String>("student is Updated successfully", HttpStatus.OK);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Student student = studentService.getStudent(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);

	}

	@GetMapping("/student1")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("student is  deleted successfully", HttpStatus.OK);

	}

}
