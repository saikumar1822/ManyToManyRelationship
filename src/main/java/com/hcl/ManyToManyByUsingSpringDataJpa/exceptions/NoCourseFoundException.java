package com.hcl.ManyToManyByUsingSpringDataJpa.exceptions;

public class NoCourseFoundException extends RuntimeException {
	public NoCourseFoundException() {
		super("NoCourseFoundException");
	}

}
