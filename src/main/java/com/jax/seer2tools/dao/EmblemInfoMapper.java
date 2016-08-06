package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.EmblemInfo;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface EmblemInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmblemInfo record);

    EmblemInfo selectByPrimaryKey(Integer id);

    List<EmblemInfo> selectAll();

    int updateByPrimaryKey(EmblemInfo record);
}