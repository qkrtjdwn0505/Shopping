package com.kmove.app.User.vo;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
public class UserVO { 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String uidx; 
    private String uid; 
    private String upw; 
    private String uname; 
    private String ubirth; 
    private String uphone; 
    private String uaddress;
    private String upost;  // 추가된 필드
    private String uaddressd; 
    private String uemail; 
    private Date uinsertdate; 
    private Date uupdatedate; 
    private String udeleteyn; 
    private String ugrade;
	
    public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserVO(String uidx, String uid, String upw, String uname, String ubirth, String uphone, String uaddress,
			String upost, String uaddressd, String uemail, Date uinsertdate, Date uupdatedate, String udeleteyn,
			String ugrade) {
		super();
		this.uidx = uidx;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.ubirth = ubirth;
		this.uphone = uphone;
		this.uaddress = uaddress;
		this.upost = upost;
		this.uaddressd = uaddressd;
		this.uemail = uemail;
		this.uinsertdate = uinsertdate;
		this.uupdatedate = uupdatedate;
		this.udeleteyn = udeleteyn;
		this.ugrade = ugrade;
	}

	public String getUidx() {
		return uidx;
	}

	public void setUidx(String uidx) {
		this.uidx = uidx;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUbirth() {
		return ubirth;
	}

	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getUpost() {
		return upost;
	}

	public void setUpost(String upost) {
		this.upost = upost;
	}

	public String getUaddressd() {
		return uaddressd;
	}

	public void setUaddressd(String uaddressd) {
		this.uaddressd = uaddressd;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public Date getUinsertdate() {
		return uinsertdate;
	}

	public void setUinsertdate(Date uinsertdate) {
		this.uinsertdate = uinsertdate;
	}

	public Date getUupdatedate() {
		return uupdatedate;
	}

	public void setUupdatedate(Date uupdatedate) {
		this.uupdatedate = uupdatedate;
	}

	public String getUdeleteyn() {
		return udeleteyn;
	}

	public void setUdeleteyn(String udeleteyn) {
		this.udeleteyn = udeleteyn;
	}

	public String getUgrade() {
		return ugrade;
	}

	public void setUgrade(String ugrade) {
		this.ugrade = ugrade;
	}

	@Override
	public String toString() {
		return "UserVO [uidx=" + uidx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", ubirth=" + ubirth
				+ ", uphone=" + uphone + ", uaddress=" + uaddress + ", upost=" + upost + ", uaddressd=" + uaddressd
				+ ", uemail=" + uemail + ", uinsertdate=" + uinsertdate + ", uupdatedate=" + uupdatedate
				+ ", udeleteyn=" + udeleteyn + ", ugrade=" + ugrade + "]";
	}


}