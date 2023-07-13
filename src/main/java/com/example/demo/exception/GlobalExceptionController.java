package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
//it is the annotations of @contreller  and @responsebody
public class GlobalExceptionController {

	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<?> handleCustomerIdNotFoundException(CustomerIdNotFoundException exception,
			HttpServletRequest request) {
		ApiError apiError = new ApiError();
		apiError.setMessage(exception.getMessage());
		apiError.setLocalDateTime(LocalDateTime.now());
		apiError.setEndPoint(request.getRequestURI());
		apiError.setHttpStatus(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(apiError, apiError.getHttpStatus());

	}

}
