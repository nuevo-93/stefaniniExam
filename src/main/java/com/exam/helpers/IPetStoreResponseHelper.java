package com.exam.helpers;

import com.exam.beans.PetStoreResponseBean;
import com.exam.client.beans.PetStoreResponseClientBean;

public interface IPetStoreResponseHelper {
	
	public PetStoreResponseBean toResponse(PetStoreResponseClientBean petStoreResponseClientBean);
	
}
