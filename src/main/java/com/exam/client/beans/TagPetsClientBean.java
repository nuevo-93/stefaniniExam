package com.exam.client.beans;

import java.io.Serializable;

import lombok.Data;

@Data
public class TagPetsClientBean implements Serializable {
	
	private static final long serialVersionUID = 96076026293470517L;
	
	private Long id;
	private String name;
	
}
