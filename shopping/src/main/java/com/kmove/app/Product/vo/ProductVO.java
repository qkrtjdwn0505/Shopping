package com.kmove.app.Product.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductVO {
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	
	private String pidx; 
	private String pname; 
	private String pprice;
	private int pstar; 
	private String pdetail; 
	private String pcategory; 
	private String pimage; 
	private Date pinsertdate; 
	private Date pupdatedate; 
	public ProductVO() {
		super();
	}
	public String getPidx() {
		return pidx;
	}
	public void setPidx(String pidx) {
		this.pidx = pidx;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public int getPstar() {
		return pstar;
	}
	public void setPstar(int pstar) {
		this.pstar = pstar;
	}
	public String getPdetail() {
		return pdetail;
	}
	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public Date getPinsertdate() {
		return pinsertdate;
	}
	public void setPinsertdate(Date pinsertdate) {
		this.pinsertdate = pinsertdate;
	}
	public Date getPupdatedate() {
		return pupdatedate;
	}
	public void setPupdatedate(Date pupdatedate) {
		this.pupdatedate = pupdatedate;
	}
	public ProductVO(String pidx, String pname, String pprice, int pstar, String pdetail, String pcategory,
			String pimage, Date pinsertdate, Date pupdatedate) {
		super();
		this.pidx = pidx;
		this.pname = pname;
		this.pprice = pprice;
		this.pstar = pstar;
		this.pdetail = pdetail;
		this.pcategory = pcategory;
		this.pimage = pimage;
		this.pinsertdate = pinsertdate;
		this.pupdatedate = pupdatedate;
	}
	@Override
	public String toString() {
		return "ProductVO [pidx=" + pidx + ", pname=" + pname + ", pprice=" + pprice + ", pstar=" + pstar + ", pdetail="
				+ pdetail + ", pcategory=" + pcategory + ", pimage=" + pimage + ", pinsertdate=" + pinsertdate
				+ ", pupdatedate=" + pupdatedate + "]";
	}
	
	
}
