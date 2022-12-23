package com.masai.Exceptions;

import java.time.LocalDateTime; 

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalExceptionHandler {

	
	
	
	
	@ExceptionHandler(EntryException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(EntryException ee, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(ee.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception ee, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(ee.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	
	
	
}