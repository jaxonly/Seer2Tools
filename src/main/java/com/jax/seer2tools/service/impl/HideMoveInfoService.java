package com.jax.seer2tools.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jax.seer2tools.dao.HideMoveInfoMapper;
import com.jax.seer2tools.entity.HideMoveInfo;
import com.jax.seer2tools.service.IHideMoveInfoService;
@Service
public class HideMoveInfoService implements IHideMoveInfoService {

	@Resource
	HideMoveInfoMapper hmim;
	@Override
	public HideMoveInfo queryById(Integer id) {
		return hmim.selectById(id);
	}

}
