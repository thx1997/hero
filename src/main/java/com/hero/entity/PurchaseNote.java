package com.hero.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseNote {
    private String pnId;

    private Date pnCreatetime;

    private Integer pnEId;

    private Integer pnStatus;

    private Integer pnAccountantid;

    private Integer pnWarehousepersonid;

    private BigDecimal pnTotalmoney;

    private String pnRemark;

    @Override
	public String toString() {
		return "PurchaseNote [pnId=" + pnId + ", pnCreatetime=" + pnCreatetime + ", pnEId=" + pnEId + ", pnStatus="
				+ pnStatus + ", pnAccountantid=" + pnAccountantid + ", pnWarehousepersonid=" + pnWarehousepersonid
				+ ", pnTotalmoney=" + pnTotalmoney + ", pnRemark=" + pnRemark + "]";
	}

	public PurchaseNote() {
		super();
	}

	public PurchaseNote(String pnId, Date pnCreatetime, Integer pnEId, Integer pnStatus, Integer pnAccountantid,
			Integer pnWarehousepersonid, BigDecimal pnTotalmoney, String pnRemark) {
		super();
		this.pnId = pnId;
		this.pnCreatetime = pnCreatetime;
		this.pnEId = pnEId;
		this.pnStatus = pnStatus;
		this.pnAccountantid = pnAccountantid;
		this.pnWarehousepersonid = pnWarehousepersonid;
		this.pnTotalmoney = pnTotalmoney;
		this.pnRemark = pnRemark;
	}

	public String getPnId() {
        return pnId;
    }

    public void setPnId(String pnId) {
        this.pnId = pnId == null ? null : pnId.trim();
    }

    public Date getPnCreatetime() {
        return pnCreatetime;
    }

    public void setPnCreatetime(Date pnCreatetime) {
        this.pnCreatetime = pnCreatetime;
    }

    public Integer getPnEId() {
        return pnEId;
    }

    public void setPnEId(Integer pnEId) {
        this.pnEId = pnEId;
    }

    public Integer getPnStatus() {
        return pnStatus;
    }

    public void setPnStatus(Integer pnStatus) {
        this.pnStatus = pnStatus;
    }

    public Integer getPnAccountantid() {
        return pnAccountantid;
    }

    public void setPnAccountantid(Integer pnAccountantid) {
        this.pnAccountantid = pnAccountantid;
    }

    public Integer getPnWarehousepersonid() {
        return pnWarehousepersonid;
    }

    public void setPnWarehousepersonid(Integer pnWarehousepersonid) {
        this.pnWarehousepersonid = pnWarehousepersonid;
    }

    public BigDecimal getPnTotalmoney() {
        return pnTotalmoney;
    }

    public void setPnTotalmoney(BigDecimal pnTotalmoney) {
        this.pnTotalmoney = pnTotalmoney;
    }

    public String getPnRemark() {
        return pnRemark;
    }

    public void setPnRemark(String pnRemark) {
        this.pnRemark = pnRemark == null ? null : pnRemark.trim();
    }
}