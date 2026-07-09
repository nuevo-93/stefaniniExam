package com.exam.client.beans;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PetStoreRequestClientBean implements Serializable {
	
	private static final long serialVersionUID = -4888291061167027531L;
	
	private Long id;
	private CategoryPetsClientBean category;
	private String name;
	private String[] photoUrls;
	private List<TagPetsClientBean> tags;
	private String status;
	
}
