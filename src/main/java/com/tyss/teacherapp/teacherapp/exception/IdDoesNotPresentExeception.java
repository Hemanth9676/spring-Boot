package com.tyss.teacherapp.teacherapp.exception;

public class IdDoesNotPresentExeception extends RuntimeException {
	
	private String message = "Id is Not Present";

	public IdDoesNotPresentExeception(String message) {
		this.message = message;
	}
	 @Override
		public String getMessage() {
			return message;
		}
	}
