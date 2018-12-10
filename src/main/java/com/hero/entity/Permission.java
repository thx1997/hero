package com.hero.entity;

import java.util.Date;

public class Permission {
    private Integer perId;

    private String perValue;

    private String perMoule;

    private String perName;

    private Date perCreatetime;

    private Date perUpdatetime;

    private String perRemark;
    
    

	@Override
	public String toString() {
		return "Permission [perId=" + perId + ", perValue=" + perValue + ", perMoule=" + perMoule + ", perName="
				+ perName + ", perCreatetime=" + perCreatetime + ", perUpdatetime=" + perUpdatetime + ", perRemark="
				+ perRemark + "]";
	}

	public Permission(String perValue, String perMoule, String perName) {
		super();
		this.perValue = perValue;
		this.perMoule = perMoule;
		this.perName = perName;
	}
    
	public Permission(Integer perId, String perValue, String perMoule, String perName, Date perCreatetime,
			Date perUpdatetime, String perRemark) {
		super();
		this.perId = perId;
		this.perValue = perValue;
		this.perMoule = perMoule;
		this.perName = perName;
		this.perCreatetime = perCreatetime;
		this.perUpdatetime = perUpdatetime;
		this.perRemark = perRemark;
	}
	
	public Permission() {
		super();
	}

	public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerValue() {
        return perValue;
    }

    public void setPerValue(String perValue) {
        this.perValue = perValue == null ? null : perValue.trim();
    }

    public String getPerMoule() {
        return perMoule;
    }

    public void setPerMoule(String perMoule) {
        this.perMoule = perMoule == null ? null : perMoule.trim();
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName == null ? null : perName.trim();
    }

    public Date getPerCreatetime() {
        return perCreatetime;
    }

    public void setPerCreatetime(Date perCreatetime) {
        this.perCreatetime = perCreatetime;
    }

    public Date getPerUpdatetime() {
        return perUpdatetime;
    }

    public void setPerUpdatetime(Date perUpdatetime) {
        this.perUpdatetime = perUpdatetime;
    }

    public String getPerRemark() {
        return perRemark;
    }

    public void setPerRemark(String perRemark) {
        this.perRemark = perRemark == null ? null : perRemark.trim();
    }
}