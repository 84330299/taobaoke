package com.igogogo.domain;

public class Ig_Recommends {
	private Integer recommendid;

	private String recommendtitle;

	private String recommendimg;

	private String recommendclickurl;

	private Integer recommendsort;

	private Integer isdisplay;

	public Integer getRecommendid() {
		return recommendid;
	}

	public void setRecommendid(Integer recommendid) {
		this.recommendid = recommendid;
	}

	public String getRecommendtitle() {
		return recommendtitle;
	}

	public void setRecommendtitle(String recommendtitle) {
		this.recommendtitle = recommendtitle == null ? null : recommendtitle.trim();
	}

	public String getRecommendimg() {
		return recommendimg;
	}

	public void setRecommendimg(String recommendimg) {
		this.recommendimg = recommendimg == null ? null : recommendimg.trim();
	}

	public String getRecommendclickurl() {
		return recommendclickurl;
	}

	public void setRecommendclickurl(String recommendclickurl) {
		this.recommendclickurl = recommendclickurl == null ? null : recommendclickurl.trim();
	}

	public Integer getRecommendsort() {
		return recommendsort;
	}

	public void setRecommendsort(Integer recommendsort) {
		this.recommendsort = recommendsort;
	}

	public Integer getIsdisplay() {
		return isdisplay;
	}

	public void setIsdisplay(Integer isdisplay) {
		this.isdisplay = isdisplay;
	}
}