package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TasksNotFoundException.class)
	ResponseEntity<MyErrorDetails> taskNotFound(TasksNotFoundException ex, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	ResponseEntity<MyErrorDetails> employeeNotFoud(EmployeeNotFoundException ex, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<MyErrorDetails> exception(Exception ex, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_ACCEPTABLE);
	}
}
