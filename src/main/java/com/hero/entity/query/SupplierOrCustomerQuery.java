package com.hero.entity.query;

public class SupplierOrCustomerQuery extends QueryBase{
	private String scname;//名称
	private Integer sctype;//类型
	private Integer cateid;//类别id
	private String orderby;//排序方式


	public SupplierOrCustomerQuery(String scname, Integer sctype, Integer cateid, String orderby) {
		super();
		this.scname = scname;
		this.sctype = sctype;
		this.cateid = cateid;
		this.orderby = orderby;
	}

	public SupplierOrCustomerQuery() {
		super();
	}

	public String getScname() {
		return scname;
	}

	public void setScname(String scname) {
		this.scname = scname;
	}

	public Integer getSctype() {
		return sctype;
	}

	public void setSctype(Integer sctype) {
		this.sctype = sctype;
	}

	public Integer getCateid() {
		return cateid;
	}

	public void setCateid(Integer cateid) {
		this.cateid = cateid;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}


	

	
	
}
