package com.jax.seer2tools.entity;

public class Monster {
    private Short id;

    private String defName;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDefName() {
        return defName;
    }

    public void setDefName(String defName) {
        this.defName = defName == null ? null : defName.trim();
    }

	@Override
	public String toString() {
		return "Monster [id=" + id + ", defName=" + defName + "]";
	}
    
}