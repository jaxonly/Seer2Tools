package com.jax.seer2tools.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.jax.seer2tools.entity.HideMoveInfo;
import com.jax.seer2tools.entity.Monster;
import com.jax.seer2tools.entity.MonsterInfo;
import com.jax.seer2tools.entity.PetDictionary;
import com.jax.seer2tools.entity.SkillMonster;
import com.jax.seer2tools.service.IHideMoveInfoService;
import com.jax.seer2tools.service.IMonsterInfoService;
import com.jax.seer2tools.service.IPetDictionnaryService;
import com.jax.seer2tools.service.ISkillMonsterService;
import com.jax.seer2tools.service.impl.MonsterService;

@Controller
@RequestMapping(value = "/monsterinfo")
public class MonsterInfoController {
	@Resource
	IPetDictionnaryService ipd;

	@Resource
	MonsterService ms;

	@Resource
	IMonsterInfoService ims;

	@Resource
	ISkillMonsterService ism;

	@Resource
	IHideMoveInfoService ihm;
	
	@RequestMapping(value = "")
	private ModelAndView index(@RequestParam(value = "pageNum", required = false) Integer pageNum) {
		if (pageNum == null) {
			pageNum = 1;
		}
		List<Monster> pd = ms.queryPetByPage(pageNum, 20);
		PageInfo<?> info = new PageInfo<>(pd);
		ModelAndView mv = new ModelAndView();
		mv.addObject("PetInfo", pd);
		mv.addObject("PageNum", pageNum);
		mv.addObject("PetSize", info.getSize());
		mv.addObject("EndPageNum", info.getPages());
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/query")
	private ModelAndView queryByEntity(@ModelAttribute Monster pdEntity,
			@RequestParam(value = "pageNum", required = false) Integer pageNum) {
		if (pageNum == null) {
			pageNum = 1;
		}
		if ("".equals(pdEntity.getType())) {
			pdEntity.setType(null);
		}
		if ("".equals(pdEntity.getDefName())) {
			pdEntity.setDefName(null);
		}
		if ("".equals(pdEntity.getStar())) {
			pdEntity.setStar(null);
		}
		Map<String, String> map = new HashMap<String, String>();
		List<Monster> pd = ms.queryPetByEntity(pageNum, 20, pdEntity);
		PageInfo<?> info = new PageInfo<>(pd);
		ModelAndView mv = new ModelAndView();
		mv.addObject("PetInfo", pd);
		mv.addObject("PageNum", pageNum);
		mv.addObject("EndPageNum", info.getPages());
		mv.addObject("defName", pdEntity.getDefName());
		mv.addObject("type", pdEntity.getType() == null ? "" : pdEntity.getType());
		mv.addObject("star", pdEntity.getStar() == null ? "" : pdEntity.getStar());
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/info/{PetId}")
	private ModelAndView info(@PathVariable("PetId") Short PetId) {
		PetDictionary pd = ipd.queryOneById(PetId);
		MonsterInfo mi = ims.queryMonsterInfoById(PetId);
		List<SkillMonster> sks = ism.querySkillMonsterAll(PetId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pd", pd);
		mv.addObject("mi", mi);
		mv.addObject("Skills", sks);
		mv.setViewName("info");
		return mv;
	}
	@RequestMapping(value = "/HideMove/{Id}")
	private void info(@PathVariable("Id") Integer Id,HttpServletResponse response) throws IOException {
		HideMoveInfo hm = ihm.queryById(Id);
		response.setContentType("text/html;charset=utf-8");
		if (hm==null) {
			response.getWriter().print("");
		}else{
			response.getWriter().print(hm.getTips());
		}
	}
}
