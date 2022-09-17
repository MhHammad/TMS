package com.app.exc_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.dto.ErrorResponse;

import custom_exceptions.CustomerHandlingException;
import custom_exceptions.ResourceNotFoundException;

@ControllerAdvice // MANDATORY annotation to tell SC , following is the global exc handler class
// to intercept exceptions in all controllers n rest controllers
//ResponseEntityExceptionHandler => a base class , for handling methdo arg not valid type of excs
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e)
	{
		System.out.println("handle res not found.... ");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
	}

	@ExceptionHandler(CustomerHandlingException.class)
	public ResponseEntity<?> handleCustomerHandlingException(CustomerHandlingException e) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Error: "+e.getMessage()));
	}

//	@ExceptionHandler(HomeMakerHandlingException.class)
//	public ResponseEntity<?> handleHomeMakerHandlingException(HomeMakerHandlingException e) {
//
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Error: "+e.getMessage()));
//	}

}
