package com.jax.seer2tools.entity;

public class HideMoveInfo {
    /**
     * 技能ID
     */
    private Integer id;

    /**
     * 获得方式
     */
    private String tips;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

	@Override
	public String toString() {
		return "HideMoveInfo [id=" + id + ", tips=" + tips + "]";
	}

}