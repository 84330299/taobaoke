package com.igogogo.domain;

public class Ig_Banner {
	private Integer bannerid;

	private String bannertitle;

	private String bannerimg;

	private String bannerclickurl;

	private Integer bannersort;

	private Integer isdisplay = 1;

	public Integer getBannerid() {
		return bannerid;
	}

	public void setBannerid(Integer bannerid) {
		this.bannerid = bannerid;
	}

	public String getBannertitle() {
		return bannertitle;
	}

	public void setBannertitle(String bannertitle) {
		this.bannertitle = bannertitle == null ? null : bannertitle.trim();
	}

	public String getBannerimg() {
		return bannerimg;
	}

	public void setBannerimg(String bannerimg) {
		this.bannerimg = bannerimg == null ? null : bannerimg.trim();
	}

	public String getBannerclickurl() {
		return bannerclickurl;
	}

	public void setBannerclickurl(String bannerclickurl) {
		this.bannerclickurl = bannerclickurl == null ? null : bannerclickurl.trim();
	}

	public Integer getBannersort() {
		return bannersort;
	}

	public void setBannersort(Integer bannersort) {
		this.bannersort = bannersort;
	}

	public Integer getIsdisplay() {
		return isdisplay;
	}

	public void setIsdisplay(Integer isdisplay) {
		this.isdisplay = isdisplay;
	}
}