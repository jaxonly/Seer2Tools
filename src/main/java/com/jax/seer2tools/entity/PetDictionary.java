package com.jax.seer2tools.entity;

public class PetDictionary {
    private Short id;

    private Short numbersId;

    private Integer emblemId;

    private String defName;

    private String type;

    private String height;

    private String weight;

    private String foundin;

    private Byte isNew;

    private String features;

    private String intro;

    private String chara;

    private String charaPoint;

    private String recommendQuality;

    private String recommendSkill;

    private String getWay;

    private Byte isClose;

    private String changeTip;

    private String supermodule;
    
    private EmblemInfo emblem;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getNumbersId() {
        return numbersId;
    }

    public void setNumbersId(Short numbersId) {
        this.numbersId = numbersId;
    }

    public Integer getEmblemId() {
        return emblemId;
    }

    public void setEmblemId(Integer emblemId) {
        this.emblemId = emblemId;
    }

    public String getDefName() {
        return defName;
    }

    public void setDefName(String defName) {
        this.defName = defName == null ? null : defName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getFoundin() {
        return foundin;
    }

    public void setFoundin(String foundin) {
        this.foundin = foundin == null ? null : foundin.trim();
    }

    public Byte getIsNew() {
        return isNew;
    }

    public void setIsNew(Byte isNew) {
        this.isNew = isNew;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features == null ? null : features.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getChara() {
        return chara;
    }

    public void setChara(String chara) {
        this.chara = chara == null ? null : chara.trim();
    }

    public String getCharaPoint() {
        return charaPoint;
    }

    public void setCharaPoint(String charaPoint) {
        this.charaPoint = charaPoint == null ? null : charaPoint.trim();
    }

    public String getRecommendQuality() {
        return recommendQuality;
    }

    public void setRecommendQuality(String recommendQuality) {
        this.recommendQuality = recommendQuality == null ? null : recommendQuality.trim();
    }

    public String getRecommendSkill() {
        return recommendSkill;
    }

    public void setRecommendSkill(String recommendSkill) {
        this.recommendSkill = recommendSkill == null ? null : recommendSkill.trim();
    }

    public String getGetWay() {
        return getWay;
    }

    public void setGetWay(String getWay) {
        this.getWay = getWay == null ? null : getWay.trim();
    }

    public Byte getIsClose() {
        return isClose;
    }

    public void setIsClose(Byte isClose) {
        this.isClose = isClose;
    }

    public String getChangeTip() {
        return changeTip;
    }

    public void setChangeTip(String changeTip) {
        this.changeTip = changeTip == null ? null : changeTip.trim();
    }

    public String getSupermodule() {
        return supermodule;
    }

    public void setSupermodule(String supermodule) {
        this.supermodule = supermodule == null ? null : supermodule.trim();
    }
    
	public EmblemInfo getEmblem() {
		return emblem;
	}

	public void setEmblem(EmblemInfo emblem) {
		this.emblem = emblem;
	}

	@Override
	public String toString() {
		return "PetDictionary [id=" + id + ", numbersId=" + numbersId + ", emblemId=" + emblemId + ", defName="
				+ defName + ", type=" + type + ", height=" + height + ", weight=" + weight + ", foundin=" + foundin
				+ ", isNew=" + isNew + ", features=" + features + ", intro=" + intro + ", chara=" + chara
				+ ", charaPoint=" + charaPoint + ", recommendQuality=" + recommendQuality + ", recommendSkill="
				+ recommendSkill + ", getWay=" + getWay + ", isClose=" + isClose + ", changeTip=" + changeTip
				+ ", supermodule=" + supermodule + ", emblem=" + emblem + "]";
	}
    
}