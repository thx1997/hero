package com.hero.entity;

public class ProductUnit {
    private Integer puId;

    private String puName;

    private String puType;

    private String puRemark;

    public ProductUnit() {
		super();
	}

	@Override
	public String toString() {
		return "ProductUnit [puId=" + puId + ", puName=" + puName + ", puType=" + puType + ", puRemark=" + puRemark
				+ "]";
	}

	public ProductUnit(Integer puId, String puName, String puType, String puRemark) {
		super();
		this.puId = puId;
		this.puName = puName;
		this.puType = puType;
		this.puRemark = puRemark;
	}

	public Integer getPuId() {
        return puId;
    }

    public void setPuId(Integer puId) {
        this.puId = puId;
    }

    public String getPuName() {
        return puName;
    }

    public void setPuName(String puName) {
        this.puName = puName == null ? null : puName.trim();
    }

    public String getPuType() {
        return puType;
    }

    public void setPuType(String puType) {
        this.puType = puType == null ? null : puType.trim();
    }

    public String getPuRemark() {
        return puRemark;
    }

    public void setPuRemark(String puRemark) {
        this.puRemark = puRemark == null ? null : puRemark.trim();
    }
}