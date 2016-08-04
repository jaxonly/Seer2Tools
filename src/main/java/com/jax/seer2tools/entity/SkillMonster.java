package com.jax.seer2tools.entity;

public class SkillMonster {
    /**
     * 
     */
    private Short monsterId;

    /**
     * 
     */
    private Short learningLv;

    /**
     * 
     */
    private Short skillId;

    public Short getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(Short monsterId) {
        this.monsterId = monsterId;
    }

    public Short getLearningLv() {
        return learningLv;
    }

    public void setLearningLv(Short learningLv) {
        this.learningLv = learningLv;
    }

    public Short getSkillId() {
        return skillId;
    }

    public void setSkillId(Short skillId) {
        this.skillId = skillId;
    }

	@Override
	public String toString() {
		return "SkillMonster [monsterId=" + monsterId + ", learningLv=" + learningLv + ", skillId=" + skillId + "]";
	}
}