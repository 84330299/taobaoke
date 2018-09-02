package com.igogogo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igogogo.dao.Ig_JhsMapper;
import com.igogogo.domain.Ig_Jhs;
import com.igogogo.service.Ig_JhsService;
import com.igogogo.service.TaobaokeService;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.response.TbkSpreadGetResponse.TbkSpread;
import com.taobao.api.response.TbkTpwdCreateResponse.MapData;

@Service
@Transactional
public class Ig_JhsServiceImpl implements Ig_JhsService {

	@Autowired
	private Ig_JhsMapper ig_JhsMapper;

	@Autowired
	private TaobaokeService taobaokeService;

	@Override
	public int add(Ig_Jhs t) {
		List<NTbkItem> list = taobaokeService.queryItemsByIds(t.getItemId().toString());
		if (list != null && list.size() > 0) {
			// 获取商品项
			NTbkItem item = list.get(0);
			// 小图列表
			t.setSmallImages(item.getSmallImages().toString().replace("[", "").replace("]", ""));
			// 生成短链接
			List<TbkSpread> shortLinkList = taobaokeService.shortLink(t.getPcUrl());
			t.setShortUrl(shortLinkList.get(0).getContent());
			// 淘口令
			MapData mapData = taobaokeService.createCode(t.getTitle(), t.getPcUrl(), t.getPicUrlForWL());
			t.setTpwd(mapData.getModel());
		}
		return ig_JhsMapper.insertSelective(t);
	}

	@Override
	public int addmore(List<Ig_Jhs> ts) {
		int result = 0;
		try {
			for (Ig_Jhs t : ts) {
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
		return ig_JhsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Integer id, Ig_Jhs t) {
		t.setJhsId(id);
		return ig_JhsMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public List<Ig_Jhs> query() {
		return ig_JhsMapper.query();
	}

	@Override
	public Ig_Jhs queryById(Integer id) {
		return ig_JhsMapper.queryById(id);
	}

	@Override
	public List<Ig_Jhs> queryByPage(Map<String, Object> map) {
		return ig_JhsMapper.queryByPage(map);
	}

	@Override
	public List<Ig_Jhs> queryByCondition(Map<String, Object> condition) {
		return ig_JhsMapper.queryByCondition(condition);
	}

	@Override
	public int deleteByMoreId(List<Integer> ids) {
		return ig_JhsMapper.deleteByMoreId(ids);
	}

	@Override
	public int updatemore(List<Ig_Jhs> ts) {
		int result = 0;
		try {
			for (Ig_Jhs ig_Jhs : ts) {
				ig_JhsMapper.updateByPrimaryKeySelective(ig_Jhs);
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int queryCount() {
		return ig_JhsMapper.queryCount();
	}

	@Override
	public List<Ig_Jhs> queryKeyWordByPage(Map<String, Object> map) {
		return ig_JhsMapper.queryKeyWordByPage(map);
	}

	@Override
	public int queryCountByKeyWord(String keyword) {
		return ig_JhsMapper.queryCountByKeyWord(keyword);
	}

	@Override
	public Ig_Jhs checkById(Long id) {
		return ig_JhsMapper.checkById(id);
	}

	@Override
	public int addTemp(Ig_Jhs t) {
		return ig_JhsMapper.insertSelectiveTemp(t);
	}

	@Override
	public int addmoreTemp(List<Ig_Jhs> ts) {
		int result = 0;
		try {
			for (Ig_Jhs t : ts) {
				addTemp(t);
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Ig_Jhs> queryByConditionByPage(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
