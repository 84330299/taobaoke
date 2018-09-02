package com.igogogo.dao;

import com.igogogo.domain.Ig_Itemcoupon;

public interface Ig_ItemcouponMapper extends BaseMapper<Ig_Itemcoupon> {

	public int insertSelectiveTemp(Ig_Itemcoupon t);
	
	public Ig_Itemcoupon checkById(Long id);
}