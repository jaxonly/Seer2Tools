package com.jax.seer2tools.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jax.seer2tools.dao.PetDictionaryMapper;
import com.jax.seer2tools.entity.PetDictionary;
import com.jax.seer2tools.service.IPetDictionnaryService;
@Service
public class PetDictionnaryService implements IPetDictionnaryService {

	@Resource
	private PetDictionaryMapper pm;
	@Override
	public List<PetDictionary> queryPetByPage(int pageNum, int pageSize) {
		PageHelper ph = new PageHelper();
		ph.startPage(pageNum, pageSize);
		return pm.selectAll();
	}
	@Override
	public List<PetDictionary> queryPetByPageAndName(int pageNum, int pageSize,String defName) {
		PageHelper ph = new PageHelper();
		ph.startPage(pageNum, pageSize);
		return pm.selectByLikeName(defName);
	}
	@Override
	public PetDictionary queryOneById(Short id) {
		return pm.selectByPrimaryKey(id);
	}
	@Override
	public List<PetDictionary> queryPetByPageAndType(int pageNum, int pageSize, String Type) {
		PageHelper ph = new PageHelper();
		ph.startPage(pageNum, pageSize);
		return pm.selectByLikeType(Type);
	}
	@Override
	public List<PetDictionary> queryPetByPageAndTypeAndName(int pageNum, int pageSize, Map<String, String> map) {
		PageHelper ph = new PageHelper();
		ph.startPage(pageNum, pageSize);
		return pm.selectByLikeTypeAndName(map);
	}

}
