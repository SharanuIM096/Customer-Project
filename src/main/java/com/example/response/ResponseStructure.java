package com.example.response;

import org.springframework.http.HttpStatus;

public class ResponseStructure<T> {
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}
	private T data;
	private HttpStatus httpstatus;

}
