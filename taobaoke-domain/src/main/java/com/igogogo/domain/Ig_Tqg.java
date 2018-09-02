package com.igogogo.domain;

import java.io.Serializable;
import java.util.Date;

public class Ig_Tqg implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer tqgId;

	private Long numIid;

	private String title;

	private String picUrl;

	private String smallImages;

	private String categoryName;

	private String clickUrl;

	private String startTime;

	private String endTime;

	private Double reservePrice;

	private Double zkFinalPrice;

	private Long soldNum;

	private Ig_Category category;

	private Date addTime = new Date();

	private String shortUrl;

	private String tpwd;

	public String getTpwd() {
		return tpwd;
	}

	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}

	public Integer getTqgId() {
		return tqgId;
	}

	public void setTqgId(Integer tqgId) {
		this.tqgId = tqgId;
	}

	public Long getNumIid() {
		return numIid;
	}

	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getSmallImages() {
		return smallImages;
	}

	public void setSmallImages(String smallImages) {
		this.smallImages = smallImages;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getClickUrl() {
		return clickUrl;
	}

	public void setClickUrl(String clickUrl) {
		this.clickUrl = clickUrl;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Double getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(Double reservePrice) {
		this.reservePrice = reservePrice;
	}

	public Double getZkFinalPrice() {
		return zkFinalPrice;
	}

	public void setZkFinalPrice(Double zkFinalPrice) {
		this.zkFinalPrice = zkFinalPrice;
	}

	public Long getSoldNum() {
		return soldNum;
	}

	public void setSoldNum(Long soldNum) {
		this.soldNum = soldNum;
	}

	public Ig_Category getCategory() {
		return category;
	}

	public void setCategory(Ig_Category category) {
		this.category = category;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

}