package com.jax.seer2tools.entity;

public class EmblemTwoInfo {
    private Integer id;

    private String name;

    private Short type;

    private Short numbersId;

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

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getNumbersId() {
        return numbersId;
    }

    public void setNumbersId(Short numbersId) {
        this.numbersId = numbersId;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip == null ? null : tip.trim();
    }

	@Override
	public String toString() {
		return "EmblemTwoInfo [id=" + id + ", name=" + name + ", type=" + type + ", numbersId=" + numbersId + ", tip="
				+ tip + "]";
	}
    
}