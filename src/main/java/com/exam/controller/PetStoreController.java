package com.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.beans.PetStoreRequestBean;
import com.exam.beans.PetStoreResponseBean;
import com.exam.service.IPetStoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetStoreController {
	
    private final IPetStoreService petStoreService;
    
	@PostMapping
	public ResponseEntity<PetStoreResponseBean> createPet(@RequestBody PetStoreRequestBean petStoreRequestBean) {
		PetStoreResponseBean response = petStoreService.toCreatePet(petStoreRequestBean);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
    
    @GetMapping("/{id}")
    public ResponseEntity<PetStoreResponseBean> retrievePet(@PathVariable("id") Long id) {
        return ResponseEntity.ok(petStoreService.toRetrievePet(id));
    }
    
    @PutMapping
	public ResponseEntity<PetStoreResponseBean> updatePet(@RequestBody PetStoreRequestBean petStoreRequestBean) {
		PetStoreResponseBean response = petStoreService.toUpdatePet(petStoreRequestBean);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<PetStoreResponseBean> deletePet(@PathVariable("id") Long id) {
        return ResponseEntity.ok(petStoreService.toDeletePet(id));
    }
    
}
