package com.hcl.ManyToManyByUsingSpringDataJpa.exceptions;

public class CourseNotFoundException extends RuntimeException {
	public CourseNotFoundException() {
		super("CourseNotFoundException");
	}

}
