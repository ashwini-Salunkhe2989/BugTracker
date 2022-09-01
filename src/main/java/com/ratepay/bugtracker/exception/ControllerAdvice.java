package com.ratepay.bugtracker.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

	

	

	
	@ExceptionHandler(value = CustomExceptionMessageGenerator.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleCustomExceptionMessage(CustomExceptionMessageGenerator ex) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
	
	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse hanldeEmptyDataAccess(CustomExceptionMessageGenerator ex) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Please make sure data present in system before accessing it");
	}
	 

}
