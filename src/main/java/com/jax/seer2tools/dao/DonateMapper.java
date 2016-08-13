package com.jax.seer2tools.dao;

import com.jax.seer2tools.entity.Donate;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface DonateMapper {
    List<Donate> selectAll();
}