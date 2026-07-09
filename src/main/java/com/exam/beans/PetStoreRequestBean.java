package com.exam.beans;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PetStoreRequestBean implements Serializable {
	
	private static final long serialVersionUID = -4888291061167027531L;
	
	private Long id;
	private CategoryPetsBean category;
	private String name;
	private String[] photoUrls;
	private List<TagPetsBean> tags;
	private String status;
	
}
