package com.jax.seer2tools.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jax.seer2tools.dao.DonateMapper;
import com.jax.seer2tools.dao.MonsterMapper;
import com.jax.seer2tools.dao.PetDictionaryMapper;
import com.jax.seer2tools.entity.Donate;
import com.jax.seer2tools.entity.Monster;
import com.jax.seer2tools.entity.PetDictionary;
import com.jax.seer2tools.service.IDonateService;
import com.jax.seer2tools.service.IMonsterService;
@Service
public class DonateService implements IDonateService {

	@Resource
	private DonateMapper dm;

	@Override
	public List<Donate> queryAll() {
		return dm.selectAll();
	}

}
