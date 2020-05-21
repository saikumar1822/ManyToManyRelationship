package com.hcl.ManyToManyByUsingSpringDataJpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ManyToManyByUsingSpringDataJpa.exceptions.NoStudentFoundException;
import com.hcl.ManyToManyByUsingSpringDataJpa.exceptions.NullStudentDataFoundException;
import com.hcl.ManyToManyByUsingSpringDataJpa.exceptions.StudentNotFoundException;
import com.hcl.ManyToManyByUsingSpringDataJpa.model.Student;
import com.hcl.ManyToManyByUsingSpringDataJpa.repository.StundentRepository;

@Service
public class StudentService {
	@Autowired
	StundentRepository stundentRepository;

	public Student saveStudent(Student student) {
		if (student != null) {
		return	stundentRepository.save(student);
		} else {
			throw new NullStudentDataFoundException();
		}

	}

	public Student getStudent(Long id) {

		Optional<Student> student = stundentRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		} else {
			throw new StudentNotFoundException();
		}
	}

	public void deleteStudent(Long id) {
		stundentRepository.deleteById(id);
		;
	}

	public List<Student> getAllStudents() {
		List<Student> students = stundentRepository.findAll();
		if (students.isEmpty()) {
			throw new NoStudentFoundException();
		}
		return students;
	}

}
