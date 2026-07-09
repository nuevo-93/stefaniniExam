package com.exam.exception.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseBean implements Serializable {

    private static final long serialVersionUID = 1693456234784285772L;
	
	private Integer code;
    private String type;
    private String message;
    
}