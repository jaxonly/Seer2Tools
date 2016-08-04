package com.jax.seer2tools.entity;

public class MonsterInfo {
    /**
     * 编号ID
     */
    private Integer numbersId;

    /**
     * 形态ID
     */
    private Short id;

    /**
     * 精灵名字
     */
    private String defName;

    /**
     * 成长类型
     */
    private Byte growthType;

    /**
     * 体力
     */
    private Short hp;

    /**
     * 物攻
     */
    private Short atk;

    /**
     * 物防
     */
    private Short def;

    /**
     * 特攻
     */
    private Short spAtk;

    /**
     * 特防
     */
    private Short spDef;

    /**
     * 速度
     */
    private Short spd;

    /**
     * 被击败产生经验
     */
    private Short yieldingExp;

    /**
     * 被击败产生学习力
     */
    private Short yieldingEv;

    /**
     * 上一形态ID
     */
    private Short evolvesFrom;

    /**
     * 下一形态ID
     */
    private Short evolvesTo;

    /**
     * 升级下一形态等级
     */
    private Short evolvesLv;

    /**
     * 属性
     */
    private Byte type;

    /**
     * 捕捉率
     */
    private Byte catchRat;

    /**
     * 是否需要道具升级
     */
    private Short evolvFlag;

    /**
     * 是否可以放生
     */
    private Byte freeForbidden;

    /**
     * 身高
     */
    private String height;

    /**
     * 体重
     */
    private String weight;

    /**
     * 雌雄比例
     */
    private String gender;

    /**
     * 特性
     */
    private Short features;

    /**
     * 是否为骑宠
     */
    private Byte ride;

    /**
     * 同时上场精灵数
     */
    private Byte useNum;

    /**
     * 神迹变身后精灵ID
     */
    private Short chgMonId;

    public Integer getNumbersId() {
        return numbersId;
    }

    public void setNumbersId(Integer numbersId) {
        this.numbersId = numbersId;
    }

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
        this.defName = defName;
    }

    public Byte getGrowthType() {
        return growthType;
    }

    public void setGrowthType(Byte growthType) {
        this.growthType = growthType;
    }

    public Short getHp() {
        return hp;
    }

    public void setHp(Short hp) {
        this.hp = hp;
    }

    public Short getAtk() {
        return atk;
    }

    public void setAtk(Short atk) {
        this.atk = atk;
    }

    public Short getDef() {
        return def;
    }

    public void setDef(Short def) {
        this.def = def;
    }

    public Short getSpAtk() {
        return spAtk;
    }

    public void setSpAtk(Short spAtk) {
        this.spAtk = spAtk;
    }

    public Short getSpDef() {
        return spDef;
    }

    public void setSpDef(Short spDef) {
        this.spDef = spDef;
    }

    public Short getSpd() {
        return spd;
    }

    public void setSpd(Short spd) {
        this.spd = spd;
    }

    public Short getYieldingExp() {
        return yieldingExp;
    }

    public void setYieldingExp(Short yieldingExp) {
        this.yieldingExp = yieldingExp;
    }

    public Short getYieldingEv() {
        return yieldingEv;
    }

    public void setYieldingEv(Short yieldingEv) {
        this.yieldingEv = yieldingEv;
    }

    public Short getEvolvesFrom() {
        return evolvesFrom;
    }

    public void setEvolvesFrom(Short evolvesFrom) {
        this.evolvesFrom = evolvesFrom;
    }

    public Short getEvolvesTo() {
        return evolvesTo;
    }

    public void setEvolvesTo(Short evolvesTo) {
        this.evolvesTo = evolvesTo;
    }

    public Short getEvolvesLv() {
        return evolvesLv;
    }

    public void setEvolvesLv(Short evolvesLv) {
        this.evolvesLv = evolvesLv;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getCatchRat() {
        return catchRat;
    }

    public void setCatchRat(Byte catchRat) {
        this.catchRat = catchRat;
    }

    public Short getEvolvFlag() {
        return evolvFlag;
    }

    public void setEvolvFlag(Short evolvFlag) {
        this.evolvFlag = evolvFlag;
    }

    public Byte getFreeForbidden() {
        return freeForbidden;
    }

    public void setFreeForbidden(Byte freeForbidden) {
        this.freeForbidden = freeForbidden;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Short getFeatures() {
        return features;
    }

    public void setFeatures(Short features) {
        this.features = features;
    }

    public Byte getRide() {
        return ride;
    }

    public void setRide(Byte ride) {
        this.ride = ride;
    }

    public Byte getUseNum() {
        return useNum;
    }

    public void setUseNum(Byte useNum) {
        this.useNum = useNum;
    }

    public Short getChgMonId() {
        return chgMonId;
    }

    public void setChgMonId(Short chgMonId) {
        this.chgMonId = chgMonId;
    }
}