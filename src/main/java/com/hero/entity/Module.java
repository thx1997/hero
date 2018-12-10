package com.hero.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hero.entity.query.QueryBase;

public class Module extends QueryBase{
    private Integer mId;

    private String mName;

    private Integer mParentid;

    private String mPath;

    private Integer mWeight;
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date mCreatetime;
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date mUpdatetime;

    private String mRemark;
    private List<Module> children;
   	public Boolean checked;
    

	public Module(Integer mId, String mName, Integer mParentid, String mPath, Integer mWeight, Date mCreatetime,
			Date mUpdatetime, String mRemark, List<Module> children, Boolean checked) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mParentid = mParentid;
		this.mPath = mPath;
		this.mWeight = mWeight;
		this.mCreatetime = mCreatetime;
		this.mUpdatetime = mUpdatetime;
		this.mRemark = mRemark;
		this.children = children;
		this.checked = checked;
	}

	public Module() {
		super();
	}

	public Module(Integer mId, String mName, Integer mParentid, String mPath, Integer mWeight, Date mCreatetime,
			Date mUpdatetime, String mRemark) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mParentid = mParentid;
		this.mPath = mPath;
		this.mWeight = mWeight;
		this.mCreatetime = mCreatetime;
		this.mUpdatetime = mUpdatetime;
		this.mRemark = mRemark;
	}

	public List<Module> getChildren() {
		return children;
	}

	public void setChildren(List<Module> children) {
		this.children = children;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public Integer getmParentid() {
        return mParentid;
    }

    public void setmParentid(Integer mParentid) {
        this.mParentid = mParentid;
    }

    public String getmPath() {
        return mPath;
    }

    public void setmPath(String mPath) {
        this.mPath = mPath == null ? null : mPath.trim();
    }

    public Integer getmWeight() {
        return mWeight;
    }

    public void setmWeight(Integer mWeight) {
        this.mWeight = mWeight;
    }

    public Date getmCreatetime() {
        return mCreatetime;
    }

    public void setmCreatetime(Date mCreatetime) {
        this.mCreatetime = mCreatetime;
    }

    public Date getmUpdatetime() {
        return mUpdatetime;
    }

    public void setmUpdatetime(Date mUpdatetime) {
        this.mUpdatetime = mUpdatetime;
    }

    public String getmRemark() {
        return mRemark;
    }

    public void setmRemark(String mRemark) {
        this.mRemark = mRemark == null ? null : mRemark.trim();
    }

	@Override
	public String toString() {
		return "Module [mId=" + mId + ", mName=" + mName + ", mParentid=" + mParentid + ", mPath=" + mPath
				+ ", mWeight=" + mWeight + ", mCreatetime=" + mCreatetime + ", mUpdatetime=" + mUpdatetime
				+ ", mRemark=" + mRemark + ", children=" + children + ", checked=" + checked + "]";
	}
    
}