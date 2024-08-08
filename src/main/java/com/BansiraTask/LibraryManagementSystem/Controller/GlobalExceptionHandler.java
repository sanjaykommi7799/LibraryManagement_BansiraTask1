package com.BansiraTask.LibraryManagementSystem.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.BansiraTask.LibraryManagementSystem.exception.NotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	static class Error{
		private final String reason;
		private final String message;
		public Error(String reason, String message) {
			super();
			this.reason = reason;
			this.message = message;
	}
		public String getReason() {
			return reason;
		}
		public String getMessage() {
			return message;
		}
		@ExceptionHandler(NotFoundException.class)
		@ResponseBody
		@ResponseStatus(HttpStatus.NOT_FOUND)
		public Error NotFoundException(NotFoundException e)
		{
			return new Error(HttpStatus.NOT_FOUND.getReasonPhrase(),e.getMessage());
		}
		
		@ExceptionHandler(Exception.class)
		@ResponseBody
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		public Error NotFoundException(Exception e)
		{
			return new Error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),e.getMessage());
		}
		
	}	
}
