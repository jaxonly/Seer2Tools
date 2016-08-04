package com.jax.seer2tools.entity;

public class SkillInfo {
    /**
     * ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类别
     */
    private Byte category;

    /**
     * 属性
     */
    private Byte type;

    /**
     * 威力
     */
    private Byte power;

    /**
     * 命中率
     */
    private Byte accuracy;

    /**
     * 怒气消耗
     */
    private Byte anger;

    /**
     * 描述语言
     */
    private String tips;

    /**
     * 变身后新技能ID
     */
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
        this.name = name;
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

    public Byte getPower() {
        return power;
    }

    public void setPower(Byte power) {
        this.power = power;
    }

    public Byte getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Byte accuracy) {
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
        this.tips = tips;
    }

    public Integer getChgMoveId() {
        return chgMoveId;
    }

    public void setChgMoveId(Integer chgMoveId) {
        this.chgMoveId = chgMoveId;
    }
}