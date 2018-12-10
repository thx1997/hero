package com.hero.entity.query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 角色查询条件实体类
 * 
 */
@JsonInclude(Include.NON_EMPTY)	//没有接收到的参数为空的不序列化
public class RoleQuery extends QueryBase{
	private Integer rId;
	private String roleName;
	//创建时间段
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date beginCreatetime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date endCreatetime;	
	@DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date beginUpdatetime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    private Date endUpdatetime;
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	public RoleQuery(Integer rId, String roleName, Date beginCreatetime, Date endCreatetime, Date beginUpdatetime,
			Date endUpdatetime) {
		super();
		this.rId = rId;
		this.roleName = roleName;
		this.beginCreatetime = beginCreatetime;
		this.endCreatetime = endCreatetime;
		this.beginUpdatetime = beginUpdatetime;
		this.endUpdatetime = endUpdatetime;
	}
	public RoleQuery() {
		super();
	}
	@Override
	public String toString() {
		return "RoleQuery [rId=" + rId + ", roleName=" + roleName + ", beginCreatetime=" + beginCreatetime
				+ ", endCreatetime=" + endCreatetime + ", beginUpdatetime=" + beginUpdatetime + ", endUpdatetime="
				+ endUpdatetime + "]";
	}
   
}
