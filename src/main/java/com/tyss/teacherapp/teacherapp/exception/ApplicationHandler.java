package com.tyss.teacherapp.teacherapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tyss.teacherapp.teacherapp.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationHandler {
	
	@ExceptionHandler(IdDoesNotPresentExeception.class)
	public ResponseEntity<ResponseStructure<String>> checkIdDoesNotPresentExeception(IdDoesNotPresentExeception exeception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(exeception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

}
