package com.hero.entity;

import java.util.Date;

public class Invoice {
    private Integer inId;

    private Integer inSerialnum;

    private String inPayeename;

    private Date inCreatedate;

    private String inDnId;

    @Override
	public String toString() {
		return "Invoice [inId=" + inId + ", inSerialnum=" + inSerialnum + ", inPayeename=" + inPayeename
				+ ", inCreatedate=" + inCreatedate + ", inDnId=" + inDnId + "]";
	}

	public Invoice() {
		super();
	}

	public Invoice(Integer inId, Integer inSerialnum, String inPayeename, Date inCreatedate, String inDnId) {
		super();
		this.inId = inId;
		this.inSerialnum = inSerialnum;
		this.inPayeename = inPayeename;
		this.inCreatedate = inCreatedate;
		this.inDnId = inDnId;
	}

	public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public Integer getInSerialnum() {
        return inSerialnum;
    }

    public void setInSerialnum(Integer inSerialnum) {
        this.inSerialnum = inSerialnum;
    }

    public String getInPayeename() {
        return inPayeename;
    }

    public void setInPayeename(String inPayeename) {
        this.inPayeename = inPayeename == null ? null : inPayeename.trim();
    }

    public Date getInCreatedate() {
        return inCreatedate;
    }

    public void setInCreatedate(Date inCreatedate) {
        this.inCreatedate = inCreatedate;
    }

    public String getInDnId() {
        return inDnId;
    }

    public void setInDnId(String inDnId) {
        this.inDnId = inDnId == null ? null : inDnId.trim();
    }
}