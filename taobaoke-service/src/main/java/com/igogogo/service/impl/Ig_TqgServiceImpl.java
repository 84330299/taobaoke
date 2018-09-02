package com.igogogo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igogogo.dao.Ig_TqgMapper;
import com.igogogo.domain.Ig_Tqg;
import com.igogogo.service.Ig_TqgService;
import com.igogogo.service.TaobaokeService;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.response.TbkSpreadGetResponse.TbkSpread;
import com.taobao.api.response.TbkTpwdCreateResponse.MapData;

@Service
@Transactional
public class Ig_TqgServiceImpl implements Ig_TqgService {

	@Autowired
	private Ig_TqgMapper ig_TqgMapper;

	@Autowired
	private TaobaokeService taobaokeService;

	@Override
	public int add(Ig_Tqg t) {

		List<NTbkItem> list = taobaokeService.queryItemsByIds(t.getNumIid().toString());
		if (list != null && list.size() > 0) {
			// 获取商品项
			NTbkItem item = list.get(0);
			// 小图列表
			t.setSmallImages(item.getSmallImages().toString().replace("[", "").replace("]", ""));
			// 生成短链接
			List<TbkSpread> shortLinkList = taobaokeService.shortLink(t.getClickUrl());
			t.setShortUrl(shortLinkList.get(0).getContent());
			// 淘口令
			MapData mapData = taobaokeService.createCode(t.getTitle(), t.getClickUrl(), t.getPicUrl());
			t.setTpwd(mapData.getModel());
		}
		return ig_TqgMapper.insertSelective(t);
	}

	@Override
	public int addmore(List<Ig_Tqg> ts) {
		int result = 0;
		try {
			for (Ig_Tqg t : ts) {
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
		return ig_TqgMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Integer id, Ig_Tqg t) {
		t.setTqgId(id);
		return ig_TqgMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public List<Ig_Tqg> query() {
		return ig_TqgMapper.query();
	}

	@Override
	public Ig_Tqg queryById(Integer id) {
		return ig_TqgMapper.queryById(id);
	}

	@Override
	public List<Ig_Tqg> queryByPage(Map<String, Object> map) {
		return ig_TqgMapper.queryByPage(map);
	}

	@Override
	public List<Ig_Tqg> queryByCondition(Map<String, Object> condition) {
		return ig_TqgMapper.queryByCondition(condition);
	}

	@Override
	public int deleteByMoreId(List<Integer> ids) {
		return ig_TqgMapper.deleteByMoreId(ids);
	}

	@Override
	public int updatemore(List<Ig_Tqg> ts) {
		int result = 0;
		try {
			for (Ig_Tqg ig_Tqg : ts) {
				ig_TqgMapper.updateByPrimaryKeySelective(ig_Tqg);
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int queryCount() {
		return ig_TqgMapper.queryCount();
	}

	@Override
	public List<Ig_Tqg> queryKeyWordByPage(Map<String, Object> map) {
		return ig_TqgMapper.queryKeyWordByPage(map);
	}

	@Override
	public int queryCountByKeyWord(String keyword) {
		return ig_TqgMapper.queryCountByKeyWord(keyword);
	}

	@Override
	public Ig_Tqg checkById(Long id) {
		return ig_TqgMapper.checkById(id);
	}

	@Override
	public int addTemp(Ig_Tqg t) {
		return ig_TqgMapper.insertSelectiveTemp(t);
	}

	@Override
	public int addmoreTemp(List<Ig_Tqg> ts) {
		int result = 0;
		try {
			for (Ig_Tqg t : ts) {
				addTemp(t);
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Ig_Tqg> queryByConditionByPage(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
