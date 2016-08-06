package com.jax.seer2tools.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jax.seer2tools.entity.MonsterInfo;
import com.jax.seer2tools.entity.PetDictionary;
import com.jax.seer2tools.entity.SkillMonster;
import com.jax.seer2tools.service.IMonsterInfoService;
import com.jax.seer2tools.service.IPetDictionnaryService;
import com.jax.seer2tools.service.ISkillMonsterService;

@Controller
@RequestMapping(value = "/monsterinfo")
public class MonsterInfoController {
	@Resource
	IPetDictionnaryService ipd;

	@Resource
	IMonsterInfoService ims;

	@Resource
	ISkillMonsterService ism;
	
	@RequestMapping(value = "")
	private ModelAndView index() {
		return this.index(1);
	}
	@RequestMapping(value = "/{pageNum}")
	private ModelAndView index(
			@PathVariable("pageNum") Integer pageNum) {
		if (pageNum==null) {
			pageNum=1;
		}
		List<PetDictionary> pd = ipd.queryPetByPage(pageNum, 20);
		ModelAndView mv = new ModelAndView();
		mv.addObject("PetInfo", pd);
		mv.addObject("PageNum", pageNum);
		mv.setViewName("index");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/info/{PetId}")
	private ModelAndView info(
			@PathVariable("PetId") Short PetId) {
		PetDictionary pd = ipd.queryOneById(PetId);
		System.out.println(pd);
		MonsterInfo mi =ims.queryMonsterInfoById(PetId);
		System.out.println(mi);
		List<SkillMonster> sks = ism.querySkillMonsterAll(PetId);
		for (SkillMonster skillMonster : sks) {
			System.out.println(skillMonster);
		}
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}
