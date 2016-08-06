package com.jax.seer2tools.entity;

public class SkillInfo {
    private Integer id;

    private String name;

    private Byte category;

    private Byte type;

    private Integer power;

    private Short accuracy;

    private Byte anger;

    private String tips;

    private Integer chgMoveId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Short getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Short accuracy) {
        this.accuracy = accuracy;
    }

    public Byte getAnger() {
        return anger;
    }

    public void setAnger(Byte anger) {
        this.anger = anger;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    public Integer getChgMoveId() {
        return chgMoveId;
    }

    public void setChgMoveId(Integer chgMoveId) {
        this.chgMoveId = chgMoveId;
    }

	@Override
	public String toString() {
		return "SkillInfo [id=" + id + ", name=" + name + ", category=" + category + ", type=" + type + ", power="
				+ power + ", accuracy=" + accuracy + ", anger=" + anger + ", tips=" + tips + ", chgMoveId=" + chgMoveId
				+ "]";
	}
    
}