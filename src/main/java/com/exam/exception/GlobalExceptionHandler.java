package com.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exam.exception.beans.ErrorResponseBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PetStoreClientException.class)
	public ResponseEntity<ErrorResponseBean> handlePetStoreClientException(PetStoreClientException ex) {
		ErrorResponseBean error = new ErrorResponseBean(ex.getCode(), ex.getType(), ex.getMessage());
		
	    return ResponseEntity.status(ex.getStatus()).body(error);
	}
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseBean> handleGenericException(Exception ex) {
    	ErrorResponseBean error = new ErrorResponseBean(500, "error", "Ocurrio un error inesperado");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    
}