package com.jax.seer2tools.entity;

public class EmblemInfo {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 精灵编号
     */
    private Short numbersId;

    /**
     * 荣耀点兑换
     */
    private Short honorPrice;

    /**
     * 对应米币购买ID
     */
    private Short miBuyId;

    /**
     * 描述
     */
    private String tip;

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

    public Short getNumbersId() {
        return numbersId;
    }

    public void setNumbersId(Short numbersId) {
        this.numbersId = numbersId;
    }

    public Short getHonorPrice() {
        return honorPrice;
    }

    public void setHonorPrice(Short honorPrice) {
        this.honorPrice = honorPrice;
    }

    public Short getMiBuyId() {
        return miBuyId;
    }

    public void setMiBuyId(Short miBuyId) {
        this.miBuyId = miBuyId;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}