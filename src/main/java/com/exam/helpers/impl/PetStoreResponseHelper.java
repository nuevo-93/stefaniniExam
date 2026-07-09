package com.exam.helpers.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.exam.beans.PetStoreResponseBean;
import com.exam.client.beans.PetStoreResponseClientBean;
import com.exam.helpers.IPetStoreResponseHelper;

@Component
public class PetStoreResponseHelper implements IPetStoreResponseHelper {
	
	@Override
	public PetStoreResponseBean toResponse(PetStoreResponseClientBean petStoreResponseClientBean) {
		PetStoreResponseBean petStoreResponseBean = new PetStoreResponseBean();
		
		petStoreResponseBean.setTransactionId(UUID.randomUUID().toString());
		petStoreResponseBean.setDateCreated(new Date());
		petStoreResponseBean.setStatus(petStoreResponseClientBean.getStatus());
		petStoreResponseBean.setName(petStoreResponseClientBean.getName());
		
		return petStoreResponseBean;
	}
	
}
