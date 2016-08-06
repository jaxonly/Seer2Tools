package com.jax.seer2tools.entity;

public class EmblemInfo {
    private Integer id;

    private String name;

    private Short numbersId;

    private Short honorPrice;

    private Integer miBuyId;

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
        this.name = name == null ? null : name.trim();
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

    public Integer getMiBuyId() {
        return miBuyId;
    }

    public void setMiBuyId(Integer miBuyId) {
        this.miBuyId = miBuyId;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip == null ? null : tip.trim();
    }

	@Override
	public String toString() {
		return "EmblemInfo [id=" + id + ", name=" + name + ", numbersId=" + numbersId + ", honorPrice=" + honorPrice
				+ ", miBuyId=" + miBuyId + ", tip=" + tip + "]";
	}
    
}