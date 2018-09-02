package com.igogogo.domain;

import java.io.Serializable;
import java.util.Date;

public class Ig_Itemcoupon implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer itemcouponId;

	private Long numIid;

	private String title;

	private String itemUrl;

	private String couponClickUrl;

	private String couponInfo;

	private String pictUrl;

	private String smallImages;

	private String itemDescription;

	private Long sellerId;

	private String couponAmount;

	private String couponStartTime;

	private String couponEndTime;

	private String shopTitle;

	private Long volume;

	private Double zkFinalPrice;

	private Double reservePrice;

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

	public Integer getItemcouponId() {
		return itemcouponId;
	}

	public void setItemcouponId(Integer itemcouponId) {
		this.itemcouponId = itemcouponId;
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

	public String getItemUrl() {
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	public String getCouponClickUrl() {
		return couponClickUrl;
	}

	public void setCouponClickUrl(String couponClickUrl) {
		this.couponClickUrl = couponClickUrl;
	}

	public String getCouponInfo() {
		return couponInfo;
	}

	public void setCouponInfo(String couponInfo) {
		this.couponInfo = couponInfo;
	}

	public String getPictUrl() {
		return pictUrl;
	}

	public void setPictUrl(String pictUrl) {
		this.pictUrl = pictUrl;
	}

	public String getSmallImages() {
		return smallImages;
	}

	public void setSmallImages(String smallImages) {
		this.smallImages = smallImages;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(String couponAmount) {
		this.couponAmount = couponAmount;
	}

	public String getCouponStartTime() {
		return couponStartTime;
	}

	public void setCouponStartTime(String couponStartTime) {
		this.couponStartTime = couponStartTime;
	}

	public String getCouponEndTime() {
		return couponEndTime;
	}

	public void setCouponEndTime(String couponEndTime) {
		this.couponEndTime = couponEndTime;
	}

	public String getShopTitle() {
		return shopTitle;
	}

	public void setShopTitle(String shopTitle) {
		this.shopTitle = shopTitle;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public Double getZkFinalPrice() {
		return zkFinalPrice;
	}

	public void setZkFinalPrice(Double zkFinalPrice) {
		this.zkFinalPrice = zkFinalPrice;
	}

	public Double getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(Double reservePrice) {
		this.reservePrice = reservePrice;
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