package com.hero.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.hero.excel.PoiHandler;

public class SupplierOrCustomer {
	@PoiHandler(excelHeader="编号")
    private Integer sId;
	@PoiHandler(excelHeader="名称")
    private String sName;
	@PoiHandler(excelHeader="传真")
    private String sFax;
	@PoiHandler(excelHeader="类别编号")
    private Integer sScId;
    @PoiHandler(excelHeader="联系人")
    private String sConstacperson;
    @PoiHandler(excelHeader="联系人电话")
    private String sConstacphone;
    @PoiHandler(excelHeader="地址")
    private String sAddress;
    @PoiHandler(excelHeader="描述")
    private String sDescription;
    @PoiHandler(excelIgnore=false)
    private String sIsexit;
    @PoiHandler(excelHeader="税号")
    private String sTallage;
    @PoiHandler(excelHeader="创建时间")
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date sCreatetime;
    @PoiHandler(excelHeader="最后更新时间")
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date sUpdatetime;
    @PoiHandler(excelHeader="备注")
    private String sRemark;
    @PoiHandler(excelIgnore=false)
    private Boolean sType;
    @JsonUnwrapped//rfy
    private SupplierOrCustomerCategory category;
   
	public SupplierOrCustomer() {
		super();
	}

	public SupplierOrCustomer(Integer sId, String sName, String sFax, Integer sScId, String sConstacperson,
			String sConstacphone, String sAddress, String sDescription, String sIsexit, String sTallage,
			Date sCreatetime, Date sUpdatetime, String sRemark, Boolean sType) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sFax = sFax;
		this.sScId = sScId;
		this.sConstacperson = sConstacperson;
		this.sConstacphone = sConstacphone;
		this.sAddress = sAddress;
		this.sDescription = sDescription;
		this.sIsexit = sIsexit;
		this.sTallage = sTallage;
		this.sCreatetime = sCreatetime;
		this.sUpdatetime = sUpdatetime;
		this.sRemark = sRemark;
		this.sType = sType;
	}
	
	public SupplierOrCustomer(Integer sId, String sName, String sFax, Integer sScId, String sConstacperson,
			String sConstacphone, String sAddress, String sDescription, String sIsexit, String sTallage,
			Date sCreatetime, Date sUpdatetime, String sRemark, Boolean sType, SupplierOrCustomerCategory category) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sFax = sFax;
		this.sScId = sScId;
		this.sConstacperson = sConstacperson;
		this.sConstacphone = sConstacphone;
		this.sAddress = sAddress;
		this.sDescription = sDescription;
		this.sIsexit = sIsexit;
		this.sTallage = sTallage;
		this.sCreatetime = sCreatetime;
		this.sUpdatetime = sUpdatetime;
		this.sRemark = sRemark;
		this.sType = sType;
		this.category = category;
	}

	public SupplierOrCustomerCategory getCategory() {
		return category;
	}

	public void setCategory(SupplierOrCustomerCategory category) {
		this.category = category;
	}

	public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsFax() {
        return sFax;
    }

    public void setsFax(String sFax) {
        this.sFax = sFax == null ? null : sFax.trim();
    }

    public Integer getsScId() {
        return sScId;
    }

    public void setsScId(Integer sScId) {
        this.sScId = sScId;
    }

    public String getsConstacperson() {
        return sConstacperson;
    }

    public void setsConstacperson(String sConstacperson) {
        this.sConstacperson = sConstacperson == null ? null : sConstacperson.trim();
    }

    public String getsConstacphone() {
        return sConstacphone;
    }

    public void setsConstacphone(String sConstacphone) {
        this.sConstacphone = sConstacphone == null ? null : sConstacphone.trim();
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress == null ? null : sAddress.trim();
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription == null ? null : sDescription.trim();
    }

    public String getsIsexit() {
        return sIsexit;
    }

    public void setsIsexit(String sIsexit) {
        this.sIsexit = sIsexit == null ? null : sIsexit.trim();
    }

    public String getsTallage() {
        return sTallage;
    }

    public void setsTallage(String sTallage) {
        this.sTallage = sTallage == null ? null : sTallage.trim();
    }

    public Date getsCreatetime() {
        return sCreatetime;
    }

    public void setsCreatetime(Date sCreatetime) {
        this.sCreatetime = sCreatetime;
    }

    public Date getsUpdatetime() {
        return sUpdatetime;
    }

    public void setsUpdatetime(Date sUpdatetime) {
        this.sUpdatetime = sUpdatetime;
    }

    public String getsRemark() {
        return sRemark;
    }

    public void setsRemark(String sRemark) {
        this.sRemark = sRemark == null ? null : sRemark.trim();
    }

    public Boolean getsType() {
        return sType;
    }

    public void setsType(Boolean sType) {
        this.sType = sType;
    }

	@Override
	public String toString() {
		return "SupplierOrCustomer [sId=" + sId + ", sName=" + sName + ", sFax=" + sFax + ", sScId=" + sScId
				+ ", sConstacperson=" + sConstacperson + ", sConstacphone=" + sConstacphone + ", sAddress=" + sAddress
				+ ", sDescription=" + sDescription + ", sIsexit=" + sIsexit + ", sTallage=" + sTallage
				+ ", sCreatetime=" + sCreatetime + ", sUpdatetime=" + sUpdatetime + ", sRemark=" + sRemark + ", sType="
				+ sType + ", category=" + category + "]";
	}
    
}