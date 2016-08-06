package com.jax.seer2tools.service;

import java.util.List;

import com.jax.seer2tools.entity.MonsterInfo;
import com.jax.seer2tools.entity.PetDictionary;
import com.jax.seer2tools.entity.SkillInfo;
import com.jax.seer2tools.entity.SkillMonster;

public interface ISkillMonsterService {
	List<SkillMonster> querySkillMonsterAll(Short petId);
}
