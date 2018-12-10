package com.hero.entity.query;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 员工查询实体类
 * @author thx
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class EmployeeQuery extends QueryBase{
	private Integer eId;//编号
    private String eName;//姓名
    private String eLoginname;//登录名
    private String eSex;//性别
    private String eIdcard;//身份证号
    //生日时间段
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date beginBirthday;
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date endBirthday;
    //最近登录时间段
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date beginLogintime;
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date endLogintime;
    //创建时间段
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date beginCreatetime;
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date endCreatetime;
    //修改时间段
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date beginUpdatetime;
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date endUpdatetime;    
    
    private Integer eIslockout;//是否锁定
    private String eEmail;//邮箱
    private String eTelphone;//手机号
    private Integer eDeptid;//部门编号
    private String orderby;//排序（列名）
 
     


	public EmployeeQuery(String eIdcard, Integer eIslockout) {
		super();
		this.eIdcard = eIdcard;
		this.eIslockout = eIslockout;
	}
	public EmployeeQuery() {
		super();
	}
	public EmployeeQuery(Integer eId, String eName, String eLoginname, String eSex, String eIdcard, Date beginBirthday,
			Date endBirthday, Date beginLogintime, Date endLogintime, Date beginCreatetime, Date endCreatetime,
			Date beginUpdatetime, Date endUpdatetime, Integer eIslockout, String eEmail, String eTelphone,
			Integer eDeptid, String orderby) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eLoginname = eLoginname;
		this.eSex = eSex;
		this.eIdcard = eIdcard;
		this.beginBirthday = beginBirthday;
		this.endBirthday = endBirthday;
		this.beginLogintime = beginLogintime;
		this.endLogintime = endLogintime;
		this.beginCreatetime = beginCreatetime;
		this.endCreatetime = endCreatetime;
		this.beginUpdatetime = beginUpdatetime;
		this.endUpdatetime = endUpdatetime;
		this.eIslockout = eIslockout;
		this.eEmail = eEmail;
		this.eTelphone = eTelphone;
		this.eDeptid = eDeptid;
		this.orderby = orderby;
	}
	@Override
	public String toString() {
		return "EmployeeQuery [eId=" + eId + ", eName=" + eName + ", eLoginname=" + eLoginname + ", eSex=" + eSex
				+ ", eIdcard=" + eIdcard + ", beginBirthday=" + beginBirthday + ", endBirthday=" + endBirthday
				+ ", beginLogintime=" + beginLogintime + ", endLogintime=" + endLogintime + ", beginCreatetime="
				+ beginCreatetime + ", endCreatetime=" + endCreatetime + ", beginUpdatetime=" + beginUpdatetime
				+ ", endUpdatetime=" + endUpdatetime + ", eIslockout=" + eIslockout + ", eEmail=" + eEmail
				+ ", eTelphone=" + eTelphone + ", eDeptid=" + eDeptid + ", orderby=" + orderby +  "]";
	}
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteLoginname() {
		return eLoginname;
	}
	public void seteLoginname(String eLoginname) {
		this.eLoginname = eLoginname;
	}
	public String geteSex() {
		return eSex;
	}
	public void seteSex(String eSex) {
		this.eSex = eSex;
	}
	public String geteIdcard() {
		return eIdcard;
	}
	public void seteIdcard(String eIdcard) {
		this.eIdcard = eIdcard;
	}
	public Date getBeginBirthday() {
		return beginBirthday;
	}
	public void setBeginBirthday(Date beginBirthday) {
		this.beginBirthday = beginBirthday;
	}
	public Date getEndBirthday() {
		return endBirthday;
	}
	public void setEndBirthday(Date endBirthday) {
		this.endBirthday = endBirthday;
	}
	public Date getBeginLogintime() {
		return beginLogintime;
	}
	public void setBeginLogintime(Date beginLogintime) {
		this.beginLogintime = beginLogintime;
	}
	public Date getEndLogintime() {
		return endLogintime;
	}
	public void setEndLogintime(Date endLogintime) {
		this.endLogintime = endLogintime;
	}
	public Date getBeginCreatetime() {
		return beginCreatetime;
	}
	public void setBeginCreatetime(Date beginCreatetime) {
		this.beginCreatetime = beginCreatetime;
	}
	public Date getEndCreatetime() {
		return endCreatetime;
	}
	public void setEndCreatetime(Date endCreatetime) {
		this.endCreatetime = endCreatetime;
	}
	public Date getBeginUpdatetime() {
		return beginUpdatetime;
	}
	public void setBeginUpdatetime(Date beginUpdatetime) {
		this.beginUpdatetime = beginUpdatetime;
	}
	public Date getEndUpdatetime() {
		return endUpdatetime;
	}
	public void setEndUpdatetime(Date endUpdatetime) {
		this.endUpdatetime = endUpdatetime;
	}
	public Integer geteIslockout() {
		return eIslockout;
	}
	public void seteIslockout(Integer eIslockout) {
		this.eIslockout = eIslockout;
	}
	public String geteEmail() {
		return eEmail;
	}
	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}
	public String geteTelphone() {
		return eTelphone;
	}
	public void seteTelphone(String eTelphone) {
		this.eTelphone = eTelphone;
	}
	public Integer geteDeptid() {
		return eDeptid;
	}
	public void seteDeptid(Integer eDeptid) {
		this.eDeptid = eDeptid;
	}
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	


}
