package com.hero.entity;

import java.math.BigDecimal;

public class PurchaseDetail {
    private Integer pdId;

    private String pdPnId;

    private Integer pdPId;

    private Integer pdQuantity;

    private BigDecimal pdUnitprice;

    private Integer pdSId;

    private BigDecimal pdAmount;

    @Override
	public String toString() {
		return "PurchaseDetail [pdId=" + pdId + ", pdPnId=" + pdPnId + ", pdPId=" + pdPId + ", pdQuantity=" + pdQuantity
				+ ", pdUnitprice=" + pdUnitprice + ", pdSId=" + pdSId + ", pdAmount=" + pdAmount + "]";
	}

	public PurchaseDetail() {
		super();
	}

	public PurchaseDetail(Integer pdId, String pdPnId, Integer pdPId, Integer pdQuantity, BigDecimal pdUnitprice,
			Integer pdSId, BigDecimal pdAmount) {
		super();
		this.pdId = pdId;
		this.pdPnId = pdPnId;
		this.pdPId = pdPId;
		this.pdQuantity = pdQuantity;
		this.pdUnitprice = pdUnitprice;
		this.pdSId = pdSId;
		this.pdAmount = pdAmount;
	}

	public Integer getPdId() {
        return pdId;
    }

    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }

    public String getPdPnId() {
        return pdPnId;
    }

    public void setPdPnId(String pdPnId) {
        this.pdPnId = pdPnId == null ? null : pdPnId.trim();
    }

    public Integer getPdPId() {
        return pdPId;
    }

    public void setPdPId(Integer pdPId) {
        this.pdPId = pdPId;
    }

    public Integer getPdQuantity() {
        return pdQuantity;
    }

    public void setPdQuantity(Integer pdQuantity) {
        this.pdQuantity = pdQuantity;
    }

    public BigDecimal getPdUnitprice() {
        return pdUnitprice;
    }

    public void setPdUnitprice(BigDecimal pdUnitprice) {
        this.pdUnitprice = pdUnitprice;
    }

    public Integer getPdSId() {
        return pdSId;
    }

    public void setPdSId(Integer pdSId) {
        this.pdSId = pdSId;
    }

    public BigDecimal getPdAmount() {
        return pdAmount;
    }

    public void setPdAmount(BigDecimal pdAmount) {
        this.pdAmount = pdAmount;
    }
}