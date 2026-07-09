package com.exam.client.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.exam.client.IPetStoreClient;
import com.exam.client.beans.PetStoreRequestClientBean;
import com.exam.client.beans.PetStoreResponseClientBean;
import com.exam.exception.beans.PetStoreClientException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PetStoreClient implements IPetStoreClient {
	
	private final RestTemplate restTemplate;
	
	@Value("${client.petstore.createPet.url}")
	private String createPetUrl;
	
    @Value("${client.petstore.retrievePet.url}")
    private String retrievePet;
    
    @Override
    public PetStoreResponseClientBean toCreatePet(PetStoreRequestClientBean petStoreRequestClientBean) {
    	try {

            HttpEntity<PetStoreRequestClientBean> httpEntity = new HttpEntity<>(petStoreRequestClientBean);
            ResponseEntity<PetStoreResponseClientBean> responseEntity = restTemplate.exchange(createPetUrl, HttpMethod.POST, httpEntity, 
            		new ParameterizedTypeReference<PetStoreResponseClientBean>(){});

            return responseEntity.getBody();

        } catch (HttpClientErrorException ex) {
        	throw new PetStoreClientException(ex.getStatusCode(), 1, "error", "No fue posible crear la mascota.");
        }
    }
    
	@Override
	public PetStoreResponseClientBean toRetrievePet(Long id) {
		try {
			
			HttpEntity<Void> httpEntity = new HttpEntity<>(null);
			ResponseEntity<PetStoreResponseClientBean> responseEntity = restTemplate.exchange(retrievePet, HttpMethod.GET, httpEntity, 
					new ParameterizedTypeReference<PetStoreResponseClientBean>(){}, id);

			return responseEntity.getBody();
			
		} catch (HttpClientErrorException.NotFound ex) {
			throw new PetStoreClientException(ex.getStatusCode(), 1, "error", "Mascota no encontrada");
        }
	}

	@Override
	public PetStoreResponseClientBean toUpdatePet(PetStoreRequestClientBean petStoreRequestClientBean) {
		try {

            HttpEntity<PetStoreRequestClientBean> httpEntity = new HttpEntity<>(petStoreRequestClientBean);
            ResponseEntity<PetStoreResponseClientBean> responseEntity = restTemplate.exchange(createPetUrl, HttpMethod.PUT, httpEntity, 
            		new ParameterizedTypeReference<PetStoreResponseClientBean>(){});

            return responseEntity.getBody();

        } catch (HttpClientErrorException ex) {
        	throw new PetStoreClientException(ex.getStatusCode(), 1, "error", "No fue posible actualizar la mascota.");
        }
	}

	@Override
	public PetStoreResponseClientBean toDeletePet(Long id) {
		try {
			
			HttpEntity<Void> httpEntity = new HttpEntity<>(null);
			ResponseEntity<PetStoreResponseClientBean> responseEntity = restTemplate.exchange(retrievePet, HttpMethod.DELETE, httpEntity, 
					new ParameterizedTypeReference<PetStoreResponseClientBean>(){}, id);

			return responseEntity.getBody();
			
		} catch (HttpClientErrorException.NotFound ex) {
			throw new PetStoreClientException(ex.getStatusCode(), 1, "error", "Mascota no encontrada");
        }
	}
	
}