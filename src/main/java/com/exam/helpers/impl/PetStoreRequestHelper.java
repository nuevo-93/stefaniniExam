package com.exam.helpers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.exam.beans.CategoryPetsBean;
import com.exam.beans.PetStoreRequestBean;
import com.exam.beans.TagPetsBean;
import com.exam.client.beans.CategoryPetsClientBean;
import com.exam.client.beans.PetStoreRequestClientBean;
import com.exam.client.beans.TagPetsClientBean;
import com.exam.helpers.IPetStoreRequestHelper;

@Component
public class PetStoreRequestHelper implements IPetStoreRequestHelper {
	
	@Override
	public PetStoreRequestClientBean toCreatePet(PetStoreRequestBean petStoreRequestBean) {
		PetStoreRequestClientBean petStoreRequestClientBean = new PetStoreRequestClientBean();

		petStoreRequestClientBean.setId(petStoreRequestBean.getId());
		petStoreRequestClientBean.setName(petStoreRequestBean.getName());
		petStoreRequestClientBean.setStatus(petStoreRequestBean.getStatus());
		
		return petStoreRequestClientBean;
	}
	
	@Override
	public PetStoreRequestClientBean toUpdatePet(PetStoreRequestBean petStoreRequestBean) {
		PetStoreRequestClientBean petStoreRequestClientBean = new PetStoreRequestClientBean();
		
		petStoreRequestClientBean.setId(petStoreRequestBean.getId());
		petStoreRequestClientBean.setCategory(toSetCategoryPetsClientBean(petStoreRequestBean.getCategory()));
		petStoreRequestClientBean.setName(petStoreRequestBean.getName());
		petStoreRequestClientBean.setPhotoUrls(petStoreRequestBean.getPhotoUrls());
		petStoreRequestClientBean.setTags(toSetTagPetsClientList(petStoreRequestBean.getTags()));
		petStoreRequestClientBean.setStatus(petStoreRequestBean.getStatus());
		
		return petStoreRequestClientBean;
	}
	
	private CategoryPetsClientBean toSetCategoryPetsClientBean(CategoryPetsBean categoryPetsBean) {
		CategoryPetsClientBean categoryPetsClientBean = new CategoryPetsClientBean();
		
		categoryPetsClientBean.setId(categoryPetsBean.getId());
		categoryPetsClientBean.setName(categoryPetsBean.getName());
		
		return categoryPetsClientBean;
	}
	
	private List<TagPetsClientBean> toSetTagPetsClientList(List<TagPetsBean> tagPetsList){
		if(tagPetsList != null && !tagPetsList.isEmpty()) {
			return tagPetsList.stream().map(this::toSetTagPetsClientBean).collect(Collectors.toList());
		}
		
		return new ArrayList<>();
	}
	
	private TagPetsClientBean toSetTagPetsClientBean(TagPetsBean tagPetsBean) {
		TagPetsClientBean tagPetsClientBean = new TagPetsClientBean();
		
		tagPetsClientBean.setId(tagPetsBean.getId());
		tagPetsClientBean.setName(tagPetsBean.getName());
		
		return tagPetsClientBean;
	}
	
}
