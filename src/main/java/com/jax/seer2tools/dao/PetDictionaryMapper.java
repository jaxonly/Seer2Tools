package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.PetDictionary;
import java.util.List;

public interface PetDictionaryMapper {
    int deleteByPrimaryKey(Short id);

    int insert(PetDictionary record);

    PetDictionary selectByPrimaryKey(Short id);

    List<PetDictionary> selectAll();

    int updateByPrimaryKey(PetDictionary record);
}