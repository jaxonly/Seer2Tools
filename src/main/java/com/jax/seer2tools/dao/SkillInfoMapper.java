package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.SkillInfo;
import java.util.List;

public interface SkillInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SkillInfo record);

    SkillInfo selectByPrimaryKey(Integer id);

    List<SkillInfo> selectAll();

    int updateByPrimaryKey(SkillInfo record);
}