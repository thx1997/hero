package com.hero.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Role {
    private Integer rId;

    private String rName;
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date rCreatetime;
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date rUpdatetime;

    private String rRemark;

    public Role() {
		super();
	}

	@Override
	public String toString() {
		return "Role [rId=" + rId + ", rName=" + rName + ", rCreatetime=" + rCreatetime + ", rUpdatetime=" + rUpdatetime
				+ ", rRemark=" + rRemark + "]";
	}

	public Role(Integer rId, String rName, Date rCreatetime, Date rUpdatetime, String rRemark) {
		super();
		this.rId = rId;
		this.rName = rName;
		this.rCreatetime = rCreatetime;
		this.rUpdatetime = rUpdatetime;
		this.rRemark = rRemark;
	}

	public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public Date getrCreatetime() {
        return rCreatetime;
    }

    public void setrCreatetime(Date rCreatetime) {
        this.rCreatetime = rCreatetime;
    }

    public Date getrUpdatetime() {
        return rUpdatetime;
    }

    public void setrUpdatetime(Date rUpdatetime) {
        this.rUpdatetime = rUpdatetime;
    }

    public String getrRemark() {
        return rRemark;
    }

    public void setrRemark(String rRemark) {
        this.rRemark = rRemark == null ? null : rRemark.trim();
    }
}