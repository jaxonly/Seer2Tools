package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.PetDictionary;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface PetDictionaryMapper {
    int deleteByPrimaryKey(Short id);

    int insert(PetDictionary record);

    PetDictionary selectByPrimaryKey(Short id);

    List<PetDictionary> selectAll();
    
    List<PetDictionary> selectByLikeName(String name);

    int updateByPrimaryKey(PetDictionary record);
}