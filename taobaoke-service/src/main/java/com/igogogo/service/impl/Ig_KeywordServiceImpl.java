package com.igogogo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igogogo.dao.Ig_KeywordMapper;
import com.igogogo.domain.Ig_Keyword;
import com.igogogo.service.Ig_KeywordService;

@Service
@Transactional
public class Ig_KeywordServiceImpl implements Ig_KeywordService {

	@Autowired
	private Ig_KeywordMapper ig_KeywordMapper;

	@Override
	public int add(Ig_Keyword t) {
		return ig_KeywordMapper.insertSelective(t);
	}

	@Override
	public int addmore(List<Ig_Keyword> ts) {
		int result = 0;
		try {
			for (Ig_Keyword t : ts) {
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
		return ig_KeywordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteByMoreId(List<Integer> ids) {
		return 0;
	}

	@Override
	public int update(Integer id, Ig_Keyword t) {
		t.setKeyid(id);
		return ig_KeywordMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updatemore(List<Ig_Keyword> ts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ig_Keyword> query() {
		return ig_KeywordMapper.query();
	}

	@Override
	public Ig_Keyword queryById(Integer id) {
		return ig_KeywordMapper.queryById(id);
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
	public List<Ig_Keyword> queryByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Keyword> queryKeyWordByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Keyword> queryByCondition(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Keyword> queryByConditionByPage(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
