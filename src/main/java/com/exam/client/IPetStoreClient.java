package com.exam.client;

import com.exam.client.beans.PetStoreRequestClientBean;
import com.exam.client.beans.PetStoreResponseClientBean;

public interface IPetStoreClient {
	
	public PetStoreResponseClientBean toCreatePet(PetStoreRequestClientBean petStoreRequestClientBean);
	public PetStoreResponseClientBean toRetrievePet(Long id);
	public PetStoreResponseClientBean toUpdatePet(PetStoreRequestClientBean petStoreRequestClientBean);
	public PetStoreResponseClientBean toDeletePet(Long id);
	
}
