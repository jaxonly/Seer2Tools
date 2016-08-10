package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.HideMoveInfo;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface HideMoveInfoMapper {
    int insert(HideMoveInfo record);

    List<HideMoveInfo> selectAll();
    HideMoveInfo selectById(Integer id);
}