package com.hero.entity;

import java.util.Date;

public class BreakageOverflowDetail {
    private Integer bodId;

    private Integer bodPId;

    private Boolean bodType;

    private Date bodCreatetime;

    private String bobRemark;

    @Override
	public String toString() {
		return "BreakageOverflowDetail [bodId=" + bodId + ", bodPId=" + bodPId + ", bodType=" + bodType
				+ ", bodCreatetime=" + bodCreatetime + ", bobRemark=" + bobRemark + "]";
	}

	public BreakageOverflowDetail() {
		super();
	}

	public BreakageOverflowDetail(Integer bodId, Integer bodPId, Boolean bodType, Date bodCreatetime,
			String bobRemark) {
		super();
		this.bodId = bodId;
		this.bodPId = bodPId;
		this.bodType = bodType;
		this.bodCreatetime = bodCreatetime;
		this.bobRemark = bobRemark;
	}

	public Integer getBodId() {
        return bodId;
    }

    public void setBodId(Integer bodId) {
        this.bodId = bodId;
    }

    public Integer getBodPId() {
        return bodPId;
    }

    public void setBodPId(Integer bodPId) {
        this.bodPId = bodPId;
    }

    public Boolean getBodType() {
        return bodType;
    }

    public void setBodType(Boolean bodType) {
        this.bodType = bodType;
    }

    public Date getBodCreatetime() {
        return bodCreatetime;
    }

    public void setBodCreatetime(Date bodCreatetime) {
        this.bodCreatetime = bodCreatetime;
    }

    public String getBobRemark() {
        return bobRemark;
    }

    public void setBobRemark(String bobRemark) {
        this.bobRemark = bobRemark == null ? null : bobRemark.trim();
    }
}