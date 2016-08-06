package com.jax.seer2tools.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jax.seer2tools.dao.SkillMonsterMapper;
import com.jax.seer2tools.entity.SkillMonster;
import com.jax.seer2tools.service.ISkillMonsterService;
@Service
public class SkillMonsterService implements ISkillMonsterService {

	@Resource
	private SkillMonsterMapper smm;
	
	@Override
	public List<SkillMonster> querySkillMonsterAll(Short petId) {
		return smm.selectAll(petId);
	}

}
