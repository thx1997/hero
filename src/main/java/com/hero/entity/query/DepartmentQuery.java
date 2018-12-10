package com.hero.entity.query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 部门查询实体类
 * @author thx
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class DepartmentQuery extends QueryBase{
	    private Integer dId;
	    private String dName;//部门名称
	    //创建时间段
	    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date beginCreatetime;
	    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date endCreatetime;
	    //最近修改时间段
	    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date beginUpdatetime;
	    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date endUpdatetime;
		public Integer getdId() {
			return dId;
		}
		public void setdId(Integer dId) {
			this.dId = dId;
		}
		public String getdName() {
			return dName;
		}
		public void setdName(String dName) {
			this.dName = dName;
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
		public DepartmentQuery(Integer dId, String dName, Date beginCreatetime, Date endCreatetime,
				Date beginUpdatetime, Date endUpdatetime) {
			super();
			this.dId = dId;
			this.dName = dName;
			this.beginCreatetime = beginCreatetime;
			this.endCreatetime = endCreatetime;
			this.beginUpdatetime = beginUpdatetime;
			this.endUpdatetime = endUpdatetime;
		}
		public DepartmentQuery() {
			super();
		}
		@Override
		public String toString() {
			return "DepartmentQuery [dId=" + dId + ", dName=" + dName + ", beginCreatetime=" + beginCreatetime
					+ ", endCreatetime=" + endCreatetime + ", beginUpdatetime=" + beginUpdatetime + ", endUpdatetime="
					+ endUpdatetime + "]";
		}
	    
}
