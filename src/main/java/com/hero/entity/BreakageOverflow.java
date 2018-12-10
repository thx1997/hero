package com.hero.entity;

import java.util.Date;

public class BreakageOverflow {
    private Integer boId;

    private Integer boEId;

    private Date boCreatetime;

    private Integer boSId;

    private Integer boNumber;

    private String boRemark;

    @Override
	public String toString() {
		return "BreakageOverflow [boId=" + boId + ", boEId=" + boEId + ", boCreatetime=" + boCreatetime + ", boSId="
				+ boSId + ", boNumber=" + boNumber + ", boRemark=" + boRemark + "]";
	}

	public BreakageOverflow(Integer boId, Integer boEId, Date boCreatetime, Integer boSId, Integer boNumber,
			String boRemark) {
		super();
		this.boId = boId;
		this.boEId = boEId;
		this.boCreatetime = boCreatetime;
		this.boSId = boSId;
		this.boNumber = boNumber;
		this.boRemark = boRemark;
	}

	public BreakageOverflow() {
		super();
	}

	public Integer getBoId() {
        return boId;
    }

    public void setBoId(Integer boId) {
        this.boId = boId;
    }

    public Integer getBoEId() {
        return boEId;
    }

    public void setBoEId(Integer boEId) {
        this.boEId = boEId;
    }

    public Date getBoCreatetime() {
        return boCreatetime;
    }

    public void setBoCreatetime(Date boCreatetime) {
        this.boCreatetime = boCreatetime;
    }

    public Integer getBoSId() {
        return boSId;
    }

    public void setBoSId(Integer boSId) {
        this.boSId = boSId;
    }

    public Integer getBoNumber() {
        return boNumber;
    }

    public void setBoNumber(Integer boNumber) {
        this.boNumber = boNumber;
    }

    public String getBoRemark() {
        return boRemark;
    }

    public void setBoRemark(String boRemark) {
        this.boRemark = boRemark == null ? null : boRemark.trim();
    }
}