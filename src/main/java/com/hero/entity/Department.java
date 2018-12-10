package com.hero.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Department {
    private Integer dId;
    private String dName;

    private Integer dParentid;
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date dCreatetime;
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date dUpdatetime;

    private String dRemark;

    @Override
	public String toString() {
		return "Department [dId=" + dId + ", dName=" + dName + ", dParentid=" + dParentid + ", dCreatetime="
				+ dCreatetime + ", dUpdatetime=" + dUpdatetime + ", dRemark=" + dRemark + "]";
	}

	public Integer getdId() {
        return dId;
    }

    public Department() {
		super();
	}

	public Department(Integer dId, String dName, Integer dParentid, Date dCreatetime, Date dUpdatetime,
			String dRemark) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dParentid = dParentid;
		this.dCreatetime = dCreatetime;
		this.dUpdatetime = dUpdatetime;
		this.dRemark = dRemark;
	}

	public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public Integer getdParentid() {
        return dParentid;
    }

    public void setdParentid(Integer dParentid) {
        this.dParentid = dParentid;
    }

    public Date getdCreatetime() {
        return dCreatetime;
    }

    public void setdCreatetime(Date dCreatetime) {
        this.dCreatetime = dCreatetime;
    }

    public Date getdUpdatetime() {
        return dUpdatetime;
    }

    public void setdUpdatetime(Date dUpdatetime) {
        this.dUpdatetime = dUpdatetime;
    }

    public String getdRemark() {
        return dRemark;
    }

    public void setdRemark(String dRemark) {
        this.dRemark = dRemark == null ? null : dRemark.trim();
    }
}