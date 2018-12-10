package com.hero.entity;

import java.util.Date;

public class ChangeStorehouse {
    private Integer cshId;

    private Date cshCreatetime;

    private Integer cshEId;

    private Integer cshOldid;

    private Integer cshNewid;

    private Integer cshPId;

    private Integer cshCount;

    @Override
	public String toString() {
		return "ChangeStorehouse [cshId=" + cshId + ", cshCreatetime=" + cshCreatetime + ", cshEId=" + cshEId
				+ ", cshOldid=" + cshOldid + ", cshNewid=" + cshNewid + ", cshPId=" + cshPId + ", cshCount=" + cshCount
				+ "]";
	}

	public ChangeStorehouse() {
		super();
	}

	public ChangeStorehouse(Integer cshId, Date cshCreatetime, Integer cshEId, Integer cshOldid, Integer cshNewid,
			Integer cshPId, Integer cshCount) {
		super();
		this.cshId = cshId;
		this.cshCreatetime = cshCreatetime;
		this.cshEId = cshEId;
		this.cshOldid = cshOldid;
		this.cshNewid = cshNewid;
		this.cshPId = cshPId;
		this.cshCount = cshCount;
	}

	public Integer getCshId() {
        return cshId;
    }

    public void setCshId(Integer cshId) {
        this.cshId = cshId;
    }

    public Date getCshCreatetime() {
        return cshCreatetime;
    }

    public void setCshCreatetime(Date cshCreatetime) {
        this.cshCreatetime = cshCreatetime;
    }

    public Integer getCshEId() {
        return cshEId;
    }

    public void setCshEId(Integer cshEId) {
        this.cshEId = cshEId;
    }

    public Integer getCshOldid() {
        return cshOldid;
    }

    public void setCshOldid(Integer cshOldid) {
        this.cshOldid = cshOldid;
    }

    public Integer getCshNewid() {
        return cshNewid;
    }

    public void setCshNewid(Integer cshNewid) {
        this.cshNewid = cshNewid;
    }

    public Integer getCshPId() {
        return cshPId;
    }

    public void setCshPId(Integer cshPId) {
        this.cshPId = cshPId;
    }

    public Integer getCshCount() {
        return cshCount;
    }

    public void setCshCount(Integer cshCount) {
        this.cshCount = cshCount;
    }
}