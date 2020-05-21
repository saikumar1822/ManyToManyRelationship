package com.hcl.ManyToManyByUsingSpringDataJpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ManyToManyByUsingSpringDataJpa.exceptions.CourseNotFoundException;
import com.hcl.ManyToManyByUsingSpringDataJpa.exceptions.NoCourseFoundException;
import com.hcl.ManyToManyByUsingSpringDataJpa.exceptions.NullDataFOundInCourseException;
import com.hcl.ManyToManyByUsingSpringDataJpa.model.Course;
import com.hcl.ManyToManyByUsingSpringDataJpa.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;

	public Course saveCourse(Course course) {
		if (course != null) {
			return courseRepository.save(course);
		} else {
			throw new NullDataFOundInCourseException();
		}
	}

	public Course getCourseById(Long id) {
		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent()) {
			return course.get();
		} else {
			throw new CourseNotFoundException();
		}

	}

	public Course getCourseByTitle(String title) {
	Course course=	courseRepository.findByTitle(title);
	if(course==null) {
		throw new CourseNotFoundException();
	}
	else {
		return course;
	}

	}

	public void deleteCourseById(Long id) {
		courseRepository.deleteById(id);
	}

	public List<Course> getAllCourses() {
		
		List <Course> courses=courseRepository.findAll();
		if(courses.isEmpty()) {
			throw new NoCourseFoundException();
		}
		return courses;
	}
}
