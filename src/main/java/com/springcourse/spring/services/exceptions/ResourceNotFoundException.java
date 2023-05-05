package com.springcourse.spring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("ID Not Found: " + id);
	}
	
}
