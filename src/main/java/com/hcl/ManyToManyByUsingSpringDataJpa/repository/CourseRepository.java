package com.hcl.ManyToManyByUsingSpringDataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ManyToManyByUsingSpringDataJpa.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	public Course findByTitle(String title);

}
