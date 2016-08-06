package com.jax.seer2tools.entity;

public class SkillMonster {
    private Short monsterId;

    private Short learningLv;

    private Integer skillId;
    
    private SkillInfo skill;

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

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }
    
	public SkillInfo getSkill() {
		return skill;
	}

	public void setSkill(SkillInfo skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "SkillMonster [monsterId=" + monsterId + ", learningLv=" + learningLv + ", skillId=" + skillId
				+ ", skill=" + skill + ", getMonsterId()=" + getMonsterId() + ", getLearningLv()=" + getLearningLv()
				+ ", getSkillId()=" + getSkillId() + ", getSkill()=" + getSkill() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
}