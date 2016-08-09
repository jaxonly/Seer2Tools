package com.jax.seer2tools.service;

import java.util.List;
import java.util.Map;

import com.jax.seer2tools.entity.Monster;
import com.jax.seer2tools.entity.PetDictionary;

public interface IMonsterService {
	List<Monster> queryPetByPage(int pageNum , int pageSize);
	List<Monster> queryPetByEntity(int pageNum , int pageSize ,Monster monster);
}
