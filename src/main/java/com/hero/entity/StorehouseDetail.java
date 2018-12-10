package com.hero.entity;

import java.util.Date;

public class StorehouseDetail {
    private Integer sdId;

    private Integer sdSId;

    private Integer sdPId;

    private Integer sdNumber;

    private Date sdUpdatetime;

    private String sdRemark;

    @Override
	public String toString() {
		return "StorehouseDetail [sdId=" + sdId + ", sdSId=" + sdSId + ", sdPId=" + sdPId + ", sdNumber=" + sdNumber
				+ ", sdUpdatetime=" + sdUpdatetime + ", sdRemark=" + sdRemark + "]";
	}

	public StorehouseDetail() {
		super();
	}

	public StorehouseDetail(Integer sdId, Integer sdSId, Integer sdPId, Integer sdNumber, Date sdUpdatetime,
			String sdRemark) {
		super();
		this.sdId = sdId;
		this.sdSId = sdSId;
		this.sdPId = sdPId;
		this.sdNumber = sdNumber;
		this.sdUpdatetime = sdUpdatetime;
		this.sdRemark = sdRemark;
	}

	public Integer getSdId() {
        return sdId;
    }

    public void setSdId(Integer sdId) {
        this.sdId = sdId;
    }

    public Integer getSdSId() {
        return sdSId;
    }

    public void setSdSId(Integer sdSId) {
        this.sdSId = sdSId;
    }

    public Integer getSdPId() {
        return sdPId;
    }

    public void setSdPId(Integer sdPId) {
        this.sdPId = sdPId;
    }

    public Integer getSdNumber() {
        return sdNumber;
    }

    public void setSdNumber(Integer sdNumber) {
        this.sdNumber = sdNumber;
    }

    public Date getSdUpdatetime() {
        return sdUpdatetime;
    }

    public void setSdUpdatetime(Date sdUpdatetime) {
        this.sdUpdatetime = sdUpdatetime;
    }

    public String getSdRemark() {
        return sdRemark;
    }

    public void setSdRemark(String sdRemark) {
        this.sdRemark = sdRemark == null ? null : sdRemark.trim();
    }
}