package com.hcl.ManyToManyByUsingSpringDataJpa.exceptions;

public class NoStudentFoundException extends RuntimeException {
	public NoStudentFoundException() {
		super("NoStudentFoundException");
	}

}
