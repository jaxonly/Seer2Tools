package com.jax.seer2tools.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jax.seer2tools.dao.MonsterInfoMapper;
import com.jax.seer2tools.dao.PetDictionaryMapper;
import com.jax.seer2tools.entity.MonsterInfo;
import com.jax.seer2tools.entity.PetDictionary;
import com.jax.seer2tools.service.IMonsterInfoService;
import com.jax.seer2tools.service.IPetDictionnaryService;
@Service
public class MonsterInfoService implements IMonsterInfoService {

	@Resource
	private MonsterInfoMapper mf;
	@Override
	public MonsterInfo queryMonsterInfoById(Short id) {
		return mf.selectByPrimaryKey(id);
	}
}
