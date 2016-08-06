package com.jax.seer2tools.service;

import java.util.List;

import com.jax.seer2tools.entity.PetDictionary;

public interface IPetDictionnaryService {
	List<PetDictionary> queryPetByPage(int pageNum , int pageSize);
	PetDictionary queryOneById(Short id);
}
