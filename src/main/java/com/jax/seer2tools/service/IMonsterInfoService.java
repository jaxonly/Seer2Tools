package com.jax.seer2tools.service;

import java.util.List;

import com.jax.seer2tools.entity.MonsterInfo;
import com.jax.seer2tools.entity.PetDictionary;

public interface IMonsterInfoService {
	MonsterInfo queryMonsterInfoById(Short id);
}
