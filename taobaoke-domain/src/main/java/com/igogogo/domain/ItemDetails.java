package com.igogogo.domain;

import com.taobao.api.domain.NTbkItem;
import com.taobao.api.response.TbkCouponGetResponse;
import com.taobao.api.response.TbkTpwdCreateResponse;

public class ItemDetails {

	// 商品基础信息
	private NTbkItem itemBase;

	// 商品图文信息
	private ItemDescx itemDesc;

	// 优惠券信息
	private TbkCouponGetResponse.MapData couponInfo;
	// 淘口令
	private TbkTpwdCreateResponse.MapData code;

	public NTbkItem getItemBase() {
		return itemBase;
	}

	public void setItemBase(NTbkItem itemBase) {
		this.itemBase = itemBase;
	}

	public ItemDescx getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(ItemDescx itemDesc) {
		this.itemDesc = itemDesc;
	}

	public TbkCouponGetResponse.MapData getCouponInfo() {
		return couponInfo;
	}

	public void setCouponInfo(TbkCouponGetResponse.MapData couponInfo) {
		this.couponInfo = couponInfo;
	}

	public TbkTpwdCreateResponse.MapData getCode() {
		return code;
	}

	public void setCode(TbkTpwdCreateResponse.MapData code) {
		this.code = code;
	}

}
