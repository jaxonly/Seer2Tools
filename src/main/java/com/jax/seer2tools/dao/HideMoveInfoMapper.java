package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.HideMoveInfo;
import java.util.List;

public interface HideMoveInfoMapper {
    int insert(HideMoveInfo record);

    List<HideMoveInfo> selectAll();
}