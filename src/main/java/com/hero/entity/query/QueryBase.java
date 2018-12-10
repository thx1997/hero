package com.hero.entity.query;

public class QueryBase {
	 //--------分页所用--------
    private Integer page=1;
    private Integer rows=10;
    
    private Integer startIndex=0;//mysql分页首先查询limit第一个参数

	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getStartIndex() {
		return (page-1)*rows;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
}
