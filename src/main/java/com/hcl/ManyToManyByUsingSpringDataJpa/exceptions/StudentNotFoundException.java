package com.hcl.ManyToManyByUsingSpringDataJpa.exceptions;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException() {
		super("StudentNotFoundException");
	}

}
