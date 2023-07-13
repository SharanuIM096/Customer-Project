package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiError {
	private String message;//exception messaege info
	private LocalDateTime localDateTime;//date and time of exception
	private String endPoint;//in which endpoint created the exceptopn
	private HttpStatus httpStatus;//error status code
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	

}
