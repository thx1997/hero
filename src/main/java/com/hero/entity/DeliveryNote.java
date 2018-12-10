package com.hero.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DeliveryNote {
    private String dnId;

    private Date dnCreatetime;

    private Integer dnCId;

    private Integer dnEId;

    private Integer dnStatus;

    private Integer dnAccountantid;

    private Integer dnWarehousepersonid;

    private Integer dnSalesmanid;

    private BigDecimal dnTotalmoney;

    private String dnRemark;

    @Override
	public String toString() {
		return "DeliveryNote [dnId=" + dnId + ", dnCreatetime=" + dnCreatetime + ", dnCId=" + dnCId + ", dnEId=" + dnEId
				+ ", dnStatus=" + dnStatus + ", dnAccountantid=" + dnAccountantid + ", dnWarehousepersonid="
				+ dnWarehousepersonid + ", dnSalesmanid=" + dnSalesmanid + ", dnTotalmoney=" + dnTotalmoney
				+ ", dnRemark=" + dnRemark + "]";
	}

	public DeliveryNote(String dnId, Date dnCreatetime, Integer dnCId, Integer dnEId, Integer dnStatus,
			Integer dnAccountantid, Integer dnWarehousepersonid, Integer dnSalesmanid, BigDecimal dnTotalmoney,
			String dnRemark) {
		super();
		this.dnId = dnId;
		this.dnCreatetime = dnCreatetime;
		this.dnCId = dnCId;
		this.dnEId = dnEId;
		this.dnStatus = dnStatus;
		this.dnAccountantid = dnAccountantid;
		this.dnWarehousepersonid = dnWarehousepersonid;
		this.dnSalesmanid = dnSalesmanid;
		this.dnTotalmoney = dnTotalmoney;
		this.dnRemark = dnRemark;
	}

	public DeliveryNote() {
		super();
	}

	public String getDnId() {
        return dnId;
    }

    public void setDnId(String dnId) {
        this.dnId = dnId == null ? null : dnId.trim();
    }

    public Date getDnCreatetime() {
        return dnCreatetime;
    }

    public void setDnCreatetime(Date dnCreatetime) {
        this.dnCreatetime = dnCreatetime;
    }

    public Integer getDnCId() {
        return dnCId;
    }

    public void setDnCId(Integer dnCId) {
        this.dnCId = dnCId;
    }

    public Integer getDnEId() {
        return dnEId;
    }

    public void setDnEId(Integer dnEId) {
        this.dnEId = dnEId;
    }

    public Integer getDnStatus() {
        return dnStatus;
    }

    public void setDnStatus(Integer dnStatus) {
        this.dnStatus = dnStatus;
    }

    public Integer getDnAccountantid() {
        return dnAccountantid;
    }

    public void setDnAccountantid(Integer dnAccountantid) {
        this.dnAccountantid = dnAccountantid;
    }

    public Integer getDnWarehousepersonid() {
        return dnWarehousepersonid;
    }

    public void setDnWarehousepersonid(Integer dnWarehousepersonid) {
        this.dnWarehousepersonid = dnWarehousepersonid;
    }

    public Integer getDnSalesmanid() {
        return dnSalesmanid;
    }

    public void setDnSalesmanid(Integer dnSalesmanid) {
        this.dnSalesmanid = dnSalesmanid;
    }

    public BigDecimal getDnTotalmoney() {
        return dnTotalmoney;
    }

    public void setDnTotalmoney(BigDecimal dnTotalmoney) {
        this.dnTotalmoney = dnTotalmoney;
    }

    public String getDnRemark() {
        return dnRemark;
    }

    public void setDnRemark(String dnRemark) {
        this.dnRemark = dnRemark == null ? null : dnRemark.trim();
    }
}