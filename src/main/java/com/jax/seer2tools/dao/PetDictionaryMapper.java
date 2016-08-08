package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.PetDictionary;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public interface PetDictionaryMapper {
    int deleteByPrimaryKey(Short id);

    int insert(PetDictionary record);

    PetDictionary selectByPrimaryKey(Short id);

    List<PetDictionary> selectAll();
    
    List<PetDictionary> selectByEntity(PetDictionary record);
    
    int updateByPrimaryKey(PetDictionary record);
}