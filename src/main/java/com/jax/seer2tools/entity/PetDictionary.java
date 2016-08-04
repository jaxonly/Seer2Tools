package com.jax.seer2tools.entity;

public class PetDictionary {
    /**
     * 编号ID
     */
    private Short numbersId;

    /**
     * 纹章ID
     */
    private Short emblemId;

    /**
     * 精灵名称
     */
    private String defName;

    /**
     * 属性
     */
    private String type;

    /**
     * 身高
     */
    private String height;

    /**
     * 体重
     */
    private String weight;

    /**
     * 获取方式文字描述
     */
    private String foundin;

    /**
     * 是否新精灵
     */
    private Byte isNew;

    /**
     * 特性文字描述
     */
    private String features;

    /**
     * 特点描述
     */
    private String intro;

    /**
     * 性格
     */
    private String chara;

    /**
     * 推荐属性加点
     */
    private String charaPoint;

    /**
     * 推荐加点
     */
    private String recommendQuality;

    /**
     * 推荐技能
     */
    private String recommendSkill;

    /**
     * 获得方式
     */
    private String getWay;

    /**
     * 是否下架
     */
    private Byte isClose;

    /**
     * 变身提示
     */
    private String changeTip;

    public Short getNumbersId() {
        return numbersId;
    }

    public void setNumbersId(Short numbersId) {
        this.numbersId = numbersId;
    }

    public Short getEmblemId() {
        return emblemId;
    }

    public void setEmblemId(Short emblemId) {
        this.emblemId = emblemId;
    }

    public String getDefName() {
        return defName;
    }

    public void setDefName(String defName) {
        this.defName = defName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getFoundin() {
        return foundin;
    }

    public void setFoundin(String foundin) {
        this.foundin = foundin;
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
        this.features = features;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getChara() {
        return chara;
    }

    public void setChara(String chara) {
        this.chara = chara;
    }

    public String getCharaPoint() {
        return charaPoint;
    }

    public void setCharaPoint(String charaPoint) {
        this.charaPoint = charaPoint;
    }

    public String getRecommendQuality() {
        return recommendQuality;
    }

    public void setRecommendQuality(String recommendQuality) {
        this.recommendQuality = recommendQuality;
    }

    public String getRecommendSkill() {
        return recommendSkill;
    }

    public void setRecommendSkill(String recommendSkill) {
        this.recommendSkill = recommendSkill;
    }

    public String getGetWay() {
        return getWay;
    }

    public void setGetWay(String getWay) {
        this.getWay = getWay;
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
        this.changeTip = changeTip;
    }
}