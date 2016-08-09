package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.Monster;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface MonsterMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Monster record);

    Monster selectByPrimaryKey(Short id);

    List<Monster> selectAll();
    List<Monster> selectByEntity(Monster monster);

    int updateByPrimaryKey(Monster record);
}