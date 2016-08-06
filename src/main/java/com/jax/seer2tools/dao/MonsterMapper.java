package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.Monster;
import java.util.List;

public interface MonsterMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Monster record);

    Monster selectByPrimaryKey(Short id);

    List<Monster> selectAll();

    int updateByPrimaryKey(Monster record);
}