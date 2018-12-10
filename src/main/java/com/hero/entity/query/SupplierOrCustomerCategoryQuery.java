package com.hero.entity.query;

public class SupplierOrCustomerCategoryQuery extends QueryBase{
	private String scname;//名称
	private Integer sctype;//类型
	private String orderby;//排序方式


	public SupplierOrCustomerCategoryQuery(String scname, Integer sctype,  String orderby) {
		super();
		this.scname = scname;
		this.sctype = sctype;
		this.orderby = orderby;
	}

	public SupplierOrCustomerCategoryQuery() {
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

	

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}


	

	
	
}
