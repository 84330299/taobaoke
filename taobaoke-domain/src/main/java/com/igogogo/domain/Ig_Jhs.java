package com.igogogo.domain;

import java.io.Serializable;
import java.util.Date;

public class Ig_Jhs implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer jhsId;

	private Long itemId;

	private String pcUrl;

	private String picUrlForWL;

	private String smallImages;

	private String title;

	private String categoryName;

	private Double origPrice;

	private Double actPrice;

	private Long onlineStartTime;

	private Long onlineEndTime;

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

	public Integer getJhsId() {
		return jhsId;
	}

	public void setJhsId(Integer jhsId) {
		this.jhsId = jhsId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getPcUrl() {
		return pcUrl;
	}

	public void setPcUrl(String pcUrl) {
		this.pcUrl = pcUrl;
	}

	public String getPicUrlForWL() {
		return picUrlForWL;
	}

	public void setPicUrlForWL(String picUrlForWL) {
		this.picUrlForWL = picUrlForWL;
	}

	public String getSmallImages() {
		return smallImages;
	}

	public void setSmallImages(String smallImages) {
		this.smallImages = smallImages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Double getOrigPrice() {
		return origPrice;
	}

	public void setOrigPrice(Double origPrice) {
		this.origPrice = origPrice;
	}

	public Double getActPrice() {
		return actPrice;
	}

	public void setActPrice(Double actPrice) {
		this.actPrice = actPrice;
	}

	public Long getOnlineStartTime() {
		return onlineStartTime;
	}

	public void setOnlineStartTime(Long onlineStartTime) {
		this.onlineStartTime = onlineStartTime;
	}

	public Long getOnlineEndTime() {
		return onlineEndTime;
	}

	public void setOnlineEndTime(Long onlineEndTime) {
		this.onlineEndTime = onlineEndTime;
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