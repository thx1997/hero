package com.hero.entity;

public class StorePartition {
    private Integer spId;

    private String spName;

    private Integer spParentid;

    public StorePartition() {
		super();
	}

	@Override
	public String toString() {
		return "StorePartition [spId=" + spId + ", spName=" + spName + ", spParentid=" + spParentid + "]";
	}

	public StorePartition(Integer spId, String spName, Integer spParentid) {
		super();
		this.spId = spId;
		this.spName = spName;
		this.spParentid = spParentid;
	}

	public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName == null ? null : spName.trim();
    }

    public Integer getSpParentid() {
        return spParentid;
    }

    public void setSpParentid(Integer spParentid) {
        this.spParentid = spParentid;
    }
}