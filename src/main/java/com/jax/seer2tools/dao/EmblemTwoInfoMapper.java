package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.EmblemTwoInfo;
import java.util.List;

public interface EmblemTwoInfoMapper {
    int insert(EmblemTwoInfo record);

    List<EmblemTwoInfo> selectAll();
}