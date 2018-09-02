package com.igogogo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igogogo.dao.Ig_RecommendsMapper;
import com.igogogo.domain.Ig_Recommends;
import com.igogogo.service.Ig_RecommendsService;

@Service
@Transactional
public class Ig_RecommendsServiceImpl implements Ig_RecommendsService {

	@Autowired
	private Ig_RecommendsMapper ig_RecommendsMapper;

	@Override
	public int add(Ig_Recommends t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addmore(List<Ig_Recommends> ts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByMoreId(List<Integer> ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Integer id, Ig_Recommends t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatemore(List<Ig_Recommends> ts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ig_Recommends> query() {
		return ig_RecommendsMapper.query();
	}

	@Override
	public Ig_Recommends queryById(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Ig_Recommends> queryByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Recommends> queryKeyWordByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Recommends> queryByCondition(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Recommends> queryByConditionByPage(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
