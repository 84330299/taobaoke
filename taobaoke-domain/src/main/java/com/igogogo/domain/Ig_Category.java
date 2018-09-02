package com.igogogo.domain;

import java.io.Serializable;
import java.util.List;

public class Ig_Category implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer categoryid;

	private String categoryname;

	private String categoryimg;

	private String keyword;

	private Integer parentid;

	private Integer ishot = 0;

	private Integer isdisplay = 1;

	private List<Ig_Category> childrens;

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname == null ? null : categoryname.trim();
	}

	public String getCategoryimg() {
		return categoryimg;
	}

	public void setCategoryimg(String categoryimg) {
		this.categoryimg = categoryimg == null ? null : categoryimg.trim();
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getIshot() {
		return ishot;
	}

	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}

	public Integer getIsdisplay() {
		return isdisplay;
	}

	public void setIsdisplay(Integer isdisplay) {
		this.isdisplay = isdisplay;
	}

	public List<Ig_Category> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Ig_Category> childrens) {
		this.childrens = childrens;
	}
}