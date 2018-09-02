package com.igogogo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igogogo.dao.Ig_WxMapper;
import com.igogogo.domain.Ig_Wx;
import com.igogogo.service.Ig_WxService;

@Service
@Transactional
public class Ig_WxServiceImpl implements Ig_WxService {

	@Autowired
	private Ig_WxMapper ig_WxMapper;

	@Override
	public int add(Ig_Wx t) {
		return ig_WxMapper.insertSelective(t);
	}

	@Override
	public int addmore(List<Ig_Wx> ts) {
		int result = 0;
		try {
			for (Ig_Wx t : ts) {
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
		return ig_WxMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteByMoreId(List<Integer> ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Integer id, Ig_Wx t) {
		t.setWxid(id);
		return ig_WxMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updatemore(List<Ig_Wx> ts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ig_Wx> query() {
		return ig_WxMapper.query();
	}

	@Override
	public Ig_Wx queryById(Integer id) {
		return ig_WxMapper.queryById(id);
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
	public List<Ig_Wx> queryByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Wx> queryKeyWordByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Wx> queryByCondition(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Wx> queryByConditionByPage(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
