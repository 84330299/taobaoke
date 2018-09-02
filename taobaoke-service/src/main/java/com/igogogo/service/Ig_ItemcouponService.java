package com.igogogo.service;

import java.util.List;

import com.igogogo.domain.Ig_Itemcoupon;

//@CacheConfig(cacheNames = "itemcoupon")
public interface Ig_ItemcouponService extends BaseService<Ig_Itemcoupon> {
	public int addTemp(Ig_Itemcoupon t);

	public int addmoreTemp(List<Ig_Itemcoupon> ts);
	
	public Ig_Itemcoupon checkById(Long id);
}
