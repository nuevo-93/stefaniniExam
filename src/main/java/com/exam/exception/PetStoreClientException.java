package com.exam.exception;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PetStoreClientException extends RuntimeException {
	
	private static final long serialVersionUID = -112605502822903789L;
	
	private final HttpStatusCode status;
	private final Integer code;
	private final String type;
	private final String message;

}