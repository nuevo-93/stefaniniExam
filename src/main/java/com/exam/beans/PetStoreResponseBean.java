package com.exam.beans;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PetStoreResponseBean implements Serializable {
	
	private static final long serialVersionUID = -3822664192164982812L;
	
	private String transactionId;
	private Date dateCreated;
	private String status;
	private String name;
	
}
