package com.jax.seer2tools.service;

import java.util.List;

import com.jax.seer2tools.entity.PetDictionary;

public interface IPetDictionnaryService {
	List<PetDictionary> queryPetByPage(int pageNum , int pageSize);
	List<PetDictionary> queryPetByPageAndName(int pageNum , int pageSize ,String defName);
	List<PetDictionary> queryPetByPageAndType(int pageNum , int pageSize ,String Type);
	PetDictionary queryOneById(Short id);
}
