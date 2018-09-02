package com.igogogo.domain;

import java.util.List;

public class ItemRate {

	private Paginator paginator;
	private RateCount rateCount;
	private RateDanceInfo rateDanceInfo;
	private List<RateList> rateList;

	private String searchinfo;
	private String tags;

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

	public RateCount getRateCount() {
		return rateCount;
	}

	public void setRateCount(RateCount rateCount) {
		this.rateCount = rateCount;
	}

	public RateDanceInfo getRateDanceInfo() {
		return rateDanceInfo;
	}

	public void setRateDanceInfo(RateDanceInfo rateDanceInfo) {
		this.rateDanceInfo = rateDanceInfo;
	}

	public String getSearchinfo() {
		return searchinfo;
	}

	public void setSearchinfo(String searchinfo) {
		this.searchinfo = searchinfo;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public List<RateList> getRateList() {
		return rateList;
	}

	public void setRateList(List<RateList> rateList) {
		this.rateList = rateList;
	}

	public class Paginator {
		private Long items;
		private Long lastPage;
		private Long page;

		public Long getItems() {
			return items;
		}

		public void setItems(Long items) {
			this.items = items;
		}

		public Long getLastPage() {
			return lastPage;
		}

		public void setLastPage(Long lastPage) {
			this.lastPage = lastPage;
		}

		public Long getPage() {
			return page;
		}

		public void setPage(Long page) {
			this.page = page;
		}

	}

	public class RateCount {
		private Long picNum;
		private Long shop;
		private Long total;
		private Long used;

		public Long getPicNum() {
			return picNum;
		}

		public void setPicNum(Long picNum) {
			this.picNum = picNum;
		}

		public Long getShop() {
			return shop;
		}

		public void setShop(Long shop) {
			this.shop = shop;
		}

		public Long getTotal() {
			return total;
		}

		public void setTotal(Long total) {
			this.total = total;
		}

		public Long getUsed() {
			return used;
		}

		public void setUsed(Long used) {
			this.used = used;
		}

	}

	public class RateDanceInfo {
		private Long currentMilles;
		private Long intervalMilles;
		private Boolean showChooseTopic;
		private Integer storeType;

		public Long getCurrentMilles() {
			return currentMilles;
		}

		public void setCurrentMilles(Long currentMilles) {
			this.currentMilles = currentMilles;
		}

		public Long getIntervalMilles() {
			return intervalMilles;
		}

		public void setIntervalMilles(Long intervalMilles) {
			this.intervalMilles = intervalMilles;
		}

		public Boolean getShowChooseTopic() {
			return showChooseTopic;
		}

		public void setShowChooseTopic(Boolean showChooseTopic) {
			this.showChooseTopic = showChooseTopic;
		}

		public Integer getStoreType() {
			return storeType;
		}

		public void setStoreType(Integer storeType) {
			this.storeType = storeType;
		}
	}

	public class RateList {
		private Boolean aliMallSeller;
		private Boolean anony;
		private String appendComment;
		private String attributes;
		private String attributesMap;
		private String aucNumId;
		private String auctionPicUrl;
		private String auctionPrice;
		private String auctionSku;
		private String auctionTitle;
		private Long buyCount;
		private String carServiceLocation;
		private String cmsSource;
		private String displayRatePic;
		private Long displayRateSum;
		private String displayUserLink;
		private String displayUserNick;
		private String displayUserNumId;
		private String displayUserRateLink;
		private Long dsr;
		private Boolean fromMall;
		private Long fromMemory;
		private Long gmtCreateTime;
		private Boolean goldUser;
		private String headExtraPic;
		private Long id;
		private String memberIcon;
		private String[] pics;
		private String picsSmall;
		private String position;
		private String rateContent;
		private String rateDate;
		private String reply;
		private Long sellerId;
		private String serviceRateContent;
		private String[] structuredRateList;
		private Long tamllSweetLevel;
		private String tmallSweetPic;
		private Long tradeEndTime;
		private String tradeId;
		private Boolean useful;
		private String userIdEncryption;
		private String userInfo;
		private Long userVipLevel;
		private String userVipPic;

		public Boolean getAliMallSeller() {
			return aliMallSeller;
		}

		public void setAliMallSeller(Boolean aliMallSeller) {
			this.aliMallSeller = aliMallSeller;
		}

		public Boolean getAnony() {
			return anony;
		}

		public void setAnony(Boolean anony) {
			this.anony = anony;
		}

		public String getAppendComment() {
			return appendComment;
		}

		public void setAppendComment(String appendComment) {
			this.appendComment = appendComment;
		}

		public String getAttributes() {
			return attributes;
		}

		public void setAttributes(String attributes) {
			this.attributes = attributes;
		}

		public String getAttributesMap() {
			return attributesMap;
		}

		public void setAttributesMap(String attributesMap) {
			this.attributesMap = attributesMap;
		}

		public String getAucNumId() {
			return aucNumId;
		}

		public void setAucNumId(String aucNumId) {
			this.aucNumId = aucNumId;
		}

		public String getAuctionPicUrl() {
			return auctionPicUrl;
		}

		public void setAuctionPicUrl(String auctionPicUrl) {
			this.auctionPicUrl = auctionPicUrl;
		}

		public String getAuctionPrice() {
			return auctionPrice;
		}

		public void setAuctionPrice(String auctionPrice) {
			this.auctionPrice = auctionPrice;
		}

		public String getAuctionSku() {
			return auctionSku;
		}

		public void setAuctionSku(String auctionSku) {
			this.auctionSku = auctionSku;
		}

		public String getAuctionTitle() {
			return auctionTitle;
		}

		public void setAuctionTitle(String auctionTitle) {
			this.auctionTitle = auctionTitle;
		}

		public Long getBuyCount() {
			return buyCount;
		}

		public void setBuyCount(Long buyCount) {
			this.buyCount = buyCount;
		}

		public String getCarServiceLocation() {
			return carServiceLocation;
		}

		public void setCarServiceLocation(String carServiceLocation) {
			this.carServiceLocation = carServiceLocation;
		}

		public String getCmsSource() {
			return cmsSource;
		}

		public void setCmsSource(String cmsSource) {
			this.cmsSource = cmsSource;
		}

		public String getDisplayRatePic() {
			return displayRatePic;
		}

		public void setDisplayRatePic(String displayRatePic) {
			this.displayRatePic = displayRatePic;
		}

		public Long getDisplayRateSum() {
			return displayRateSum;
		}

		public void setDisplayRateSum(Long displayRateSum) {
			this.displayRateSum = displayRateSum;
		}

		public String getDisplayUserLink() {
			return displayUserLink;
		}

		public void setDisplayUserLink(String displayUserLink) {
			this.displayUserLink = displayUserLink;
		}

		public String getDisplayUserNick() {
			return displayUserNick;
		}

		public void setDisplayUserNick(String displayUserNick) {
			this.displayUserNick = displayUserNick;
		}

		public String getDisplayUserNumId() {
			return displayUserNumId;
		}

		public void setDisplayUserNumId(String displayUserNumId) {
			this.displayUserNumId = displayUserNumId;
		}

		public String getDisplayUserRateLink() {
			return displayUserRateLink;
		}

		public void setDisplayUserRateLink(String displayUserRateLink) {
			this.displayUserRateLink = displayUserRateLink;
		}

		public Long getDsr() {
			return dsr;
		}

		public void setDsr(Long dsr) {
			this.dsr = dsr;
		}

		public Boolean getFromMall() {
			return fromMall;
		}

		public void setFromMall(Boolean fromMall) {
			this.fromMall = fromMall;
		}

		public Long getFromMemory() {
			return fromMemory;
		}

		public void setFromMemory(Long fromMemory) {
			this.fromMemory = fromMemory;
		}

		public Long getGmtCreateTime() {
			return gmtCreateTime;
		}

		public void setGmtCreateTime(Long gmtCreateTime) {
			this.gmtCreateTime = gmtCreateTime;
		}

		public Boolean getGoldUser() {
			return goldUser;
		}

		public void setGoldUser(Boolean goldUser) {
			this.goldUser = goldUser;
		}

		public String getHeadExtraPic() {
			return headExtraPic;
		}

		public void setHeadExtraPic(String headExtraPic) {
			this.headExtraPic = headExtraPic;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getMemberIcon() {
			return memberIcon;
		}

		public void setMemberIcon(String memberIcon) {
			this.memberIcon = memberIcon;
		}

		public String[] getPics() {
			return pics;
		}

		public void setPics(String[] pics) {
			this.pics = pics;
		}

		public String getPicsSmall() {
			return picsSmall;
		}

		public void setPicsSmall(String picsSmall) {
			this.picsSmall = picsSmall;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getRateContent() {
			return rateContent;
		}

		public void setRateContent(String rateContent) {
			this.rateContent = rateContent;
		}

		public String getRateDate() {
			return rateDate;
		}

		public void setRateDate(String rateDate) {
			this.rateDate = rateDate;
		}

		public String getReply() {
			return reply;
		}

		public void setReply(String reply) {
			this.reply = reply;
		}

		public Long getSellerId() {
			return sellerId;
		}

		public void setSellerId(Long sellerId) {
			this.sellerId = sellerId;
		}

		public String getServiceRateContent() {
			return serviceRateContent;
		}

		public void setServiceRateContent(String serviceRateContent) {
			this.serviceRateContent = serviceRateContent;
		}

		public String[] getStructuredRateList() {
			return structuredRateList;
		}

		public void setStructuredRateList(String[] structuredRateList) {
			this.structuredRateList = structuredRateList;
		}

		public Long getTamllSweetLevel() {
			return tamllSweetLevel;
		}

		public void setTamllSweetLevel(Long tamllSweetLevel) {
			this.tamllSweetLevel = tamllSweetLevel;
		}

		public String getTmallSweetPic() {
			return tmallSweetPic;
		}

		public void setTmallSweetPic(String tmallSweetPic) {
			this.tmallSweetPic = tmallSweetPic;
		}

		public Long getTradeEndTime() {
			return tradeEndTime;
		}

		public void setTradeEndTime(Long tradeEndTime) {
			this.tradeEndTime = tradeEndTime;
		}

		public String getTradeId() {
			return tradeId;
		}

		public void setTradeId(String tradeId) {
			this.tradeId = tradeId;
		}

		public Boolean getUseful() {
			return useful;
		}

		public void setUseful(Boolean useful) {
			this.useful = useful;
		}

		public String getUserIdEncryption() {
			return userIdEncryption;
		}

		public void setUserIdEncryption(String userIdEncryption) {
			this.userIdEncryption = userIdEncryption;
		}

		public String getUserInfo() {
			return userInfo;
		}

		public void setUserInfo(String userInfo) {
			this.userInfo = userInfo;
		}

		public Long getUserVipLevel() {
			return userVipLevel;
		}

		public void setUserVipLevel(Long userVipLevel) {
			this.userVipLevel = userVipLevel;
		}

		public String getUserVipPic() {
			return userVipPic;
		}

		public void setUserVipPic(String userVipPic) {
			this.userVipPic = userVipPic;
		}

	}
}
