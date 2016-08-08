package com.jax.seer2tools.service;

import java.util.List;
import java.util.Map;

import com.jax.seer2tools.entity.PetDictionary;

public interface IPetDictionnaryService {
	List<PetDictionary> queryPetByPage(int pageNum , int pageSize);
	List<PetDictionary> queryPetByEntity(int pageNum , int pageSize ,PetDictionary record);
	PetDictionary queryOneById(Short id);
}
