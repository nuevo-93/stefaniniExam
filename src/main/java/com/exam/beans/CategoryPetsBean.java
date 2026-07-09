package com.exam.beans;

import java.io.Serializable;

import lombok.Data;

@Data
public class CategoryPetsBean implements Serializable  {
	
	private static final long serialVersionUID = 686541245113102927L;
	
	private Long id;
	private String name;
	
}
