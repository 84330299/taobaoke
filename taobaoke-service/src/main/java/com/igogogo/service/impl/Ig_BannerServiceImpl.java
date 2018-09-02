package com.igogogo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igogogo.dao.Ig_BannerMapper;
import com.igogogo.domain.Ig_Banner;
import com.igogogo.service.Ig_BannerService;

@Service
@Transactional
public class Ig_BannerServiceImpl implements Ig_BannerService {

	@Autowired
	private Ig_BannerMapper ig_BannerMapper;

	@Override
	public int add(Ig_Banner t) {
		return ig_BannerMapper.insertSelective(t);
	}

	@Override
	public int addmore(List<Ig_Banner> ts) {
		int result = 0;
		try {
			for (Ig_Banner t : ts) {
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
		return ig_BannerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteByMoreId(List<Integer> ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Integer id, Ig_Banner t) {
		t.setBannerid(id);
		return ig_BannerMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updatemore(List<Ig_Banner> ts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ig_Banner> query() {
		return ig_BannerMapper.query();
	}

	@Override
	public Ig_Banner queryById(Integer id) {
		return ig_BannerMapper.queryById(id);
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryCountByKeyWord(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ig_Banner> queryByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Banner> queryKeyWordByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Banner> queryByCondition(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Banner> queryByConditionByPage(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
