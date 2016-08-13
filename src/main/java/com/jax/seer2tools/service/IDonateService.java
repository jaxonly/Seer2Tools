package com.jax.seer2tools.service;

import java.util.List;
import java.util.Map;

import com.jax.seer2tools.entity.Donate;
import com.jax.seer2tools.entity.Monster;
import com.jax.seer2tools.entity.PetDictionary;

public interface IDonateService {
	List<Donate> queryAll();
}
