package com.igogogo.domain;

public class Ig_Keyword {
	private Integer keyid;

	private String keyword;

	private Integer keycount = 1;

	private Integer isdisplay = 1;

	public Integer getKeyid() {
		return keyid;
	}

	public void setKeyid(Integer keyid) {
		this.keyid = keyid;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword == null ? null : keyword.trim();
	}

	public Integer getKeycount() {
		return keycount;
	}

	public void setKeycount(Integer keycount) {
		this.keycount = keycount;
	}

	public Integer getIsdisplay() {
		return isdisplay;
	}

	public void setIsdisplay(Integer isdisplay) {
		this.isdisplay = isdisplay;
	}
}