package com.hero.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer pId;

    private String pName;

    private Integer pPsId;

    private Integer pPcId;

    private Integer pPbId;

    private BigDecimal pSalemoney;

    private BigDecimal pOyaltyrate;

    private Boolean pState;

    private Date pCreatetime;

    private Date pUpdatetime;

    private String pRemark;

    public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pPsId=" + pPsId + ", pPcId=" + pPcId + ", pPbId=" + pPbId
				+ ", pSalemoney=" + pSalemoney + ", pOyaltyrate=" + pOyaltyrate + ", pState=" + pState
				+ ", pCreatetime=" + pCreatetime + ", pUpdatetime=" + pUpdatetime + ", pRemark=" + pRemark + "]";
	}

	public Product(Integer pId, String pName, Integer pPsId, Integer pPcId, Integer pPbId, BigDecimal pSalemoney,
			BigDecimal pOyaltyrate, Boolean pState, Date pCreatetime, Date pUpdatetime, String pRemark) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPsId = pPsId;
		this.pPcId = pPcId;
		this.pPbId = pPbId;
		this.pSalemoney = pSalemoney;
		this.pOyaltyrate = pOyaltyrate;
		this.pState = pState;
		this.pCreatetime = pCreatetime;
		this.pUpdatetime = pUpdatetime;
		this.pRemark = pRemark;
	}

	public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer getpPsId() {
        return pPsId;
    }

    public void setpPsId(Integer pPsId) {
        this.pPsId = pPsId;
    }

    public Integer getpPcId() {
        return pPcId;
    }

    public void setpPcId(Integer pPcId) {
        this.pPcId = pPcId;
    }

    public Integer getpPbId() {
        return pPbId;
    }

    public void setpPbId(Integer pPbId) {
        this.pPbId = pPbId;
    }

    public BigDecimal getpSalemoney() {
        return pSalemoney;
    }

    public void setpSalemoney(BigDecimal pSalemoney) {
        this.pSalemoney = pSalemoney;
    }

    public BigDecimal getpOyaltyrate() {
        return pOyaltyrate;
    }

    public void setpOyaltyrate(BigDecimal pOyaltyrate) {
        this.pOyaltyrate = pOyaltyrate;
    }

    public Boolean getpState() {
        return pState;
    }

    public void setpState(Boolean pState) {
        this.pState = pState;
    }

    public Date getpCreatetime() {
        return pCreatetime;
    }

    public void setpCreatetime(Date pCreatetime) {
        this.pCreatetime = pCreatetime;
    }

    public Date getpUpdatetime() {
        return pUpdatetime;
    }

    public void setpUpdatetime(Date pUpdatetime) {
        this.pUpdatetime = pUpdatetime;
    }

    public String getpRemark() {
        return pRemark;
    }

    public void setpRemark(String pRemark) {
        this.pRemark = pRemark == null ? null : pRemark.trim();
    }
}