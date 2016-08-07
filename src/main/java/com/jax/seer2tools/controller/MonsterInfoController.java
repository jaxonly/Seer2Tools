package com.jax.seer2tools.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
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
		PageInfo<?> info = new PageInfo<>(pd);
		ModelAndView mv = new ModelAndView();
		mv.addObject("PetInfo", pd);
		mv.addObject("PageNum", pageNum);
		mv.addObject("PetSize", info.getSize());
		mv.addObject("EndPageNum", info.getPages());
		mv.setViewName("index");
		return mv;
	}
	
	
	@RequestMapping(value = "/queryName/{defName}")
	private ModelAndView queryByDefName(
			@PathVariable("defName") String defName) {
		return this.queryByDefName(1,defName);
	}
	@RequestMapping(value = "/queryName/{defName}/{pageNum}")
	private ModelAndView queryByDefName(
			@PathVariable("pageNum") Integer pageNum,
			@PathVariable("defName") String defName) {
		if (pageNum==null) {
			pageNum=1;
		}
		if (defName==null) {
			defName="";
		}
		List<PetDictionary> pd = ipd.queryPetByPageAndName(pageNum, 20, defName);
		PageInfo<?> info = new PageInfo<>(pd);
		ModelAndView mv = new ModelAndView();
		mv.addObject("PetInfo", pd);
		mv.addObject("PageNum", pageNum);
		mv.addObject("PetSize", info.getSize());
		mv.addObject("EndPageNum", info.getPages());
		mv.addObject("defName", defName);
		mv.setViewName("index");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/info/{PetId}")
	private ModelAndView info(
			@PathVariable("PetId") Short PetId) {
		PetDictionary pd = ipd.queryOneById(PetId);
		MonsterInfo mi =ims.queryMonsterInfoById(PetId);
		List<SkillMonster> sks = ism.querySkillMonsterAll(PetId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pd", pd);
		mv.addObject("mi", mi);
		mv.addObject("Skills", sks);
		mv.setViewName("info");
		return mv;
	}
}
