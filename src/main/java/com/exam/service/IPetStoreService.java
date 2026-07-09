package com.exam.service;

import com.exam.beans.PetStoreRequestBean;
import com.exam.beans.PetStoreResponseBean;

public interface IPetStoreService {
	
	public PetStoreResponseBean toCreatePet(PetStoreRequestBean petStoreRequestBean);
	public PetStoreResponseBean toRetrievePet(Long id);
	public PetStoreResponseBean toUpdatePet(PetStoreRequestBean petStoreRequestBean);
	public PetStoreResponseBean toDeletePet(Long id);
	
}
