package com.exam.service.impl;

import org.springframework.stereotype.Service;

import com.exam.beans.PetStoreRequestBean;
import com.exam.beans.PetStoreResponseBean;
import com.exam.client.IPetStoreClient;
import com.exam.client.beans.PetStoreRequestClientBean;
import com.exam.client.beans.PetStoreResponseClientBean;
import com.exam.helpers.IPetStoreRequestHelper;
import com.exam.helpers.IPetStoreResponseHelper;
import com.exam.service.IPetStoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PetStoreService implements IPetStoreService {
	
	private final IPetStoreClient petStoreClient;
	private final IPetStoreRequestHelper petStoreRequestHelper;
	private final IPetStoreResponseHelper petStoreResponseHelper;
	
	@Override
	public PetStoreResponseBean toCreatePet(PetStoreRequestBean petStoreRequestBean) {
		PetStoreRequestClientBean petStoreRequestClientBean = petStoreRequestHelper.toCreatePet(petStoreRequestBean);
		PetStoreResponseClientBean petStoreResponseClientBean = petStoreClient.toCreatePet(petStoreRequestClientBean);
		
		return petStoreResponseHelper.toResponse(petStoreResponseClientBean);
	}
	
	@Override
	public PetStoreResponseBean toRetrievePet(Long id) {
		PetStoreResponseClientBean petStoreResponseClientBean = petStoreClient.toRetrievePet(id);
		
		return petStoreResponseHelper.toResponse(petStoreResponseClientBean);
	}

	@Override
	public PetStoreResponseBean toUpdatePet(PetStoreRequestBean petStoreRequestBean) {
		PetStoreRequestClientBean petStoreRequestClientBean = petStoreRequestHelper.toUpdatePet(petStoreRequestBean);
		PetStoreResponseClientBean petStoreResponseClientBean = petStoreClient.toUpdatePet(petStoreRequestClientBean);
		
		return petStoreResponseHelper.toResponse(petStoreResponseClientBean);
	}

	@Override
	public PetStoreResponseBean toDeletePet(Long id) {
		PetStoreResponseClientBean petStoreResponseClientBean = petStoreClient.toDeletePet(id);
		
		return petStoreResponseHelper.toResponse(petStoreResponseClientBean);
	}

}
