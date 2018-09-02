package com.igogogo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igogogo.dao.Ig_ItemcouponMapper;
import com.igogogo.domain.Ig_Itemcoupon;
import com.igogogo.service.Ig_ItemcouponService;
import com.igogogo.service.TaobaokeService;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.response.TbkSpreadGetResponse.TbkSpread;
import com.taobao.api.response.TbkTpwdCreateResponse.MapData;

@Service
@Transactional
public class Ig_ItemcouponServiceImpl implements Ig_ItemcouponService {

	@Autowired
	private Ig_ItemcouponMapper ig_ItemcouponMapper;

	@Autowired
	private TaobaokeService taobaokeService;

	@Override
	public int add(Ig_Itemcoupon t) {
		List<NTbkItem> list = taobaokeService.queryItemsByIds(t.getNumIid().toString());
		if (list != null && list.size() > 0) {
			// 获取商品项
			NTbkItem item = list.get(0);
			// 小图列表
			if (item.getSmallImages() != null && item.getSmallImages().size() > 0) {
				t.setSmallImages(item.getSmallImages().toString().replace("[", "").replace("]", ""));
			}
			// 生成短链接
			List<TbkSpread> shortLinkList = taobaokeService.shortLink(t.getCouponClickUrl());
			t.setShortUrl(shortLinkList.get(0).getContent());
			// 淘口令
			MapData mapData = taobaokeService.createCode(t.getTitle(), t.getCouponClickUrl(), t.getPictUrl());
			t.setTpwd(mapData.getModel());
		}
		return ig_ItemcouponMapper.insertSelective(t);
	}

	@Override
	public int addmore(List<Ig_Itemcoupon> ts) {
		int result = 0;
		try {
			for (Ig_Itemcoupon t : ts) {
				add(t);
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Integer id) {
		return ig_ItemcouponMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Integer id, Ig_Itemcoupon t) {
		t.setItemcouponId(id);
		return ig_ItemcouponMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public List<Ig_Itemcoupon> query() {
		return ig_ItemcouponMapper.query();
	}

	@Override
	public Ig_Itemcoupon queryById(Integer id) {
		return ig_ItemcouponMapper.queryById(id);
	}

	@Override
	public List<Ig_Itemcoupon> queryByPage(Map<String, Object> map) {
		return ig_ItemcouponMapper.queryByPage(map);
	}

	@Override
	public List<Ig_Itemcoupon> queryByCondition(Map<String, Object> condition) {
		return ig_ItemcouponMapper.queryByCondition(condition);
	}

	@Override
	public int deleteByMoreId(List<Integer> ids) {
		return ig_ItemcouponMapper.deleteByMoreId(ids);
	}

	@Override
	public int updatemore(List<Ig_Itemcoupon> ts) {
		int result = 0;
		try {
			for (Ig_Itemcoupon ig_Itemcoupon : ts) {
				ig_ItemcouponMapper.updateByPrimaryKeySelective(ig_Itemcoupon);
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int queryCount() {
		return ig_ItemcouponMapper.queryCount();
	}

	@Override
	public List<Ig_Itemcoupon> queryKeyWordByPage(Map<String, Object> map) {
		return ig_ItemcouponMapper.queryKeyWordByPage(map);
	}

	@Override
	public int queryCountByKeyWord(String keyword) {
		return ig_ItemcouponMapper.queryCountByKeyWord(keyword);
	}

	@Override
	public int addTemp(Ig_Itemcoupon t) {
		return ig_ItemcouponMapper.insertSelectiveTemp(t);
	}

	@Override
	public int addmoreTemp(List<Ig_Itemcoupon> ts) {
		int result = 0;
		try {
			for (Ig_Itemcoupon t : ts) {
				addTemp(t);
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Ig_Itemcoupon checkById(Long id) {
		return ig_ItemcouponMapper.checkById(id);
	}

	@Override
	public List<Ig_Itemcoupon> queryByConditionByPage(Map<String, Object> condition) {
		return ig_ItemcouponMapper.queryByConditionByPage(condition);
	}

}
