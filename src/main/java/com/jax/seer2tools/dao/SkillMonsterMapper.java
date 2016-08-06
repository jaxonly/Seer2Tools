package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.SkillMonster;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface SkillMonsterMapper {
    int insert(SkillMonster record);

    List<SkillMonster> selectAll(Short id);
}