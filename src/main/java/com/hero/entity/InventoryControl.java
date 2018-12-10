package com.hero.entity;

public class InventoryControl {
    private Integer icId;

    private Integer icSId;

    private Integer icEId;

    private Integer icTopnum;

    private Integer icDownnum;

    private Integer icGoodnum;

    private String icRemark;

    private Integer icPId;

    @Override
	public String toString() {
		return "InventoryControl [icId=" + icId + ", icSId=" + icSId + ", icEId=" + icEId + ", icTopnum=" + icTopnum
				+ ", icDownnum=" + icDownnum + ", icGoodnum=" + icGoodnum + ", icRemark=" + icRemark + ", icPId="
				+ icPId + "]";
	}

	public InventoryControl() {
		super();
	}

	public InventoryControl(Integer icId, Integer icSId, Integer icEId, Integer icTopnum, Integer icDownnum,
			Integer icGoodnum, String icRemark, Integer icPId) {
		super();
		this.icId = icId;
		this.icSId = icSId;
		this.icEId = icEId;
		this.icTopnum = icTopnum;
		this.icDownnum = icDownnum;
		this.icGoodnum = icGoodnum;
		this.icRemark = icRemark;
		this.icPId = icPId;
	}

	public Integer getIcId() {
        return icId;
    }

    public void setIcId(Integer icId) {
        this.icId = icId;
    }

    public Integer getIcSId() {
        return icSId;
    }

    public void setIcSId(Integer icSId) {
        this.icSId = icSId;
    }

    public Integer getIcEId() {
        return icEId;
    }

    public void setIcEId(Integer icEId) {
        this.icEId = icEId;
    }

    public Integer getIcTopnum() {
        return icTopnum;
    }

    public void setIcTopnum(Integer icTopnum) {
        this.icTopnum = icTopnum;
    }

    public Integer getIcDownnum() {
        return icDownnum;
    }

    public void setIcDownnum(Integer icDownnum) {
        this.icDownnum = icDownnum;
    }

    public Integer getIcGoodnum() {
        return icGoodnum;
    }

    public void setIcGoodnum(Integer icGoodnum) {
        this.icGoodnum = icGoodnum;
    }

    public String getIcRemark() {
        return icRemark;
    }

    public void setIcRemark(String icRemark) {
        this.icRemark = icRemark == null ? null : icRemark.trim();
    }

    public Integer getIcPId() {
        return icPId;
    }

    public void setIcPId(Integer icPId) {
        this.icPId = icPId;
    }
}