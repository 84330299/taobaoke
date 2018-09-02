package com.igogogo.domain;

import java.io.Serializable;
import java.util.Date;

public class Ig_Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer adminid;

	private String adminname;

	private String adminpwd;

	private Date adminlastlogintime = new Date();

	private Date addtime = new Date();

	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname == null ? null : adminname.trim();
	}

	public String getAdminpwd() {
		return adminpwd;
	}

	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd == null ? null : adminpwd.trim();
	}

	public Date getAdminlastlogintime() {
		return adminlastlogintime;
	}

	public void setAdminlastlogintime(Date adminlastlogintime) {
		this.adminlastlogintime = adminlastlogintime;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	@Override
	public String toString() {
		return "Ig_Admin [adminid=" + adminid + ", adminname=" + adminname + ", adminpwd=" + adminpwd
				+ ", adminlastlogintime=" + adminlastlogintime + ", addtime=" + addtime + "]";
	}

}