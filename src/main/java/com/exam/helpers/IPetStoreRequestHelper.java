package com.exam.helpers;

import com.exam.beans.PetStoreRequestBean;
import com.exam.client.beans.PetStoreRequestClientBean;

public interface IPetStoreRequestHelper {
	
	public PetStoreRequestClientBean toCreatePet(PetStoreRequestBean petStoreRequestBean);
	public PetStoreRequestClientBean toUpdatePet(PetStoreRequestBean petStoreRequestBean);

}
