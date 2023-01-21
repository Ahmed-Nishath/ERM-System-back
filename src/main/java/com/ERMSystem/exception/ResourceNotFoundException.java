package com.ERMSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 6126481076073281086L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}
