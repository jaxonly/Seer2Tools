package com.jax.seer2tools.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jax.seer2tools.dao.MonsterMapper;
import com.jax.seer2tools.dao.PetDictionaryMapper;
import com.jax.seer2tools.entity.Monster;
import com.jax.seer2tools.entity.PetDictionary;
import com.jax.seer2tools.service.IMonsterService;
@Service
public class MonsterService implements IMonsterService {

	@Resource
	private MonsterMapper mm;
	@Override
	public List<Monster> queryPetByPage(int pageNum, int pageSize) {
		PageHelper ph = new PageHelper();
		ph.startPage(pageNum, pageSize);
		return mm.selectAll();
	}
	@Override
	public List<Monster> queryPetByEntity(int pageNum, int pageSize, Monster monster) {
		PageHelper ph = new PageHelper();
		ph.startPage(pageNum, pageSize);
		return mm.selectByEntity(monster);
	}
}
