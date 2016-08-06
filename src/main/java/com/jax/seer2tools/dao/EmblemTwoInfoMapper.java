package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.EmblemTwoInfo;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface EmblemTwoInfoMapper {
    int insert(EmblemTwoInfo record);

    List<EmblemTwoInfo> selectAll();
}