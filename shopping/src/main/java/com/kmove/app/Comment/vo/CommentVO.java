package com.kmove.app.Comment.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CommentVO {
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String cidx; 
	private String pidx; 
	private String uidx; 
	private	String ccontent; 
	private int cstar; 
	private String cdeleteyn; 
	private Date cinsertdate; 
	private Date cupdatedate; 
	public CommentVO() {
		super();
	}
	public String getCidx() {
		return cidx;
	}
	public void setCidx(String cidx) {
		this.cidx = cidx;
	}
	public String getPidx() {
		return pidx;
	}
	public void setPidx(String pidx) {
		this.pidx = pidx;
	}
	public String getUidx() {
		return uidx;
	}
	public void setUidx(String uidx) {
		this.uidx = uidx;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public int getCstar() {
		return cstar;
	}
	public void setCstar(int cstar) {
		this.cstar = cstar;
	}
	public String getCdeleteyn() {
		return cdeleteyn;
	}
	public void setCdeleteyn(String cdeleteyn) {
		this.cdeleteyn = cdeleteyn;
	}
	public Date getCinsertdate() {
		return cinsertdate;
	}
	public void setCinsertdate(Date cinsertdate) {
		this.cinsertdate = cinsertdate;
	}
	public Date getCupdatedate() {
		return cupdatedate;
	}
	public void setCupdatedate(Date cupdatedate) {
		this.cupdatedate = cupdatedate;
	}
	public CommentVO(String cidx, String pidx, String uidx, String ccontent, int cstar, String cdeleteyn,
			Date cinsertdate, Date cupdatedate) {
		super();
		this.cidx = cidx;
		this.pidx = pidx;
		this.uidx = uidx;
		this.ccontent = ccontent;
		this.cstar = cstar;
		this.cdeleteyn = cdeleteyn;
		this.cinsertdate = cinsertdate;
		this.cupdatedate = cupdatedate;
	}
	@Override
	public String toString() {
		return "CommentVO [cidx=" + cidx + ", pidx=" + pidx + ", uidx=" + uidx + ", ccontent=" + ccontent + ", cstar="
				+ cstar + ", cdeleteyn=" + cdeleteyn + ", cinsertdate=" + cinsertdate + ", cupdatedate=" + cupdatedate
				+ ", getCidx()=" + getCidx() + ", getPidx()=" + getPidx() + ", getUidx()=" + getUidx()
				+ ", getCcontent()=" + getCcontent() + ", getCstar()=" + getCstar() + ", getCdeleteyn()="
				+ getCdeleteyn() + ", getCinsertdate()=" + getCinsertdate() + ", getCupdatedate()=" + getCupdatedate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
}
