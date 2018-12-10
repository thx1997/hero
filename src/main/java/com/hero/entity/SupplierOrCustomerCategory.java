package com.hero.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SupplierOrCustomerCategory {
    private Integer scId;

    private String scName;

    private Date scCreatetime;

    private Date scUpdatetime;

    private String scRemark;

    private Boolean scType;

    private BigDecimal scDiscount;

    @Override
	public String toString() {
		return "SupplierOrCustomerCategory [scId=" + scId + ", scName=" + scName + ", scCreatetime=" + scCreatetime
				+ ", scUpdatetime=" + scUpdatetime + ", scRemark=" + scRemark + ", scType=" + scType + ", scDiscount="
				+ scDiscount + "]";
	}

	public SupplierOrCustomerCategory() {
		super();
	}

	public SupplierOrCustomerCategory(Integer scId, String scName, Date scCreatetime, Date scUpdatetime,
			String scRemark, Boolean scType, BigDecimal scDiscount) {
		super();
		this.scId = scId;
		this.scName = scName;
		this.scCreatetime = scCreatetime;
		this.scUpdatetime = scUpdatetime;
		this.scRemark = scRemark;
		this.scType = scType;
		this.scDiscount = scDiscount;
	}

	public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName == null ? null : scName.trim();
    }

    public Date getScCreatetime() {
        return scCreatetime;
    }

    public void setScCreatetime(Date scCreatetime) {
        this.scCreatetime = scCreatetime;
    }

    public Date getScUpdatetime() {
        return scUpdatetime;
    }

    public void setScUpdatetime(Date scUpdatetime) {
        this.scUpdatetime = scUpdatetime;
    }

    public String getScRemark() {
        return scRemark;
    }

    public void setScRemark(String scRemark) {
        this.scRemark = scRemark == null ? null : scRemark.trim();
    }

    public Boolean getScType() {
        return scType;
    }

    public void setScType(Boolean scType) {
        this.scType = scType;
    }

    public BigDecimal getScDiscount() {
        return scDiscount;
    }

    public void setScDiscount(BigDecimal scDiscount) {
        this.scDiscount = scDiscount;
    }
}