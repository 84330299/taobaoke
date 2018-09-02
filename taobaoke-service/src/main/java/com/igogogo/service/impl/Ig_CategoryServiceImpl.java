package com.igogogo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igogogo.dao.Ig_CategoryMapper;
import com.igogogo.domain.Ig_Category;
import com.igogogo.service.Ig_CategoryService;

@Service
@Transactional
public class Ig_CategoryServiceImpl implements Ig_CategoryService {

	@Autowired
	private Ig_CategoryMapper igCategoryMapper;

	@Override
	public int add(Ig_Category t) {
		return igCategoryMapper.insertSelective(t);
	}

	@Override
	public int delete(Integer id) {
		return igCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Integer id, Ig_Category t) {
		t.setCategoryid(id);
		return igCategoryMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public List<Ig_Category> queryByPage(Map<String, Object> map) {
		return igCategoryMapper.queryByPage(map);
	}

	@Override
	public List<Ig_Category> queryByCondition(Map<String, Object> condition) {
		return igCategoryMapper.queryByCondition(condition);
	}

	@Override
	public int addmore(List<Ig_Category> ts) {
		int result = 0;
		try {
			for (Ig_Category igCategory : ts) {
				igCategoryMapper.insertSelective(igCategory);
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteByMoreId(List<Integer> ids) {
		return igCategoryMapper.deleteByMoreId(ids);
	}

	@Override
	public int updatemore(List<Ig_Category> ts) {
		int result = 0;
		try {
			for (Ig_Category igCategory : ts) {
				igCategoryMapper.updateByPrimaryKeySelective(igCategory);
			}
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int queryCount() {
		return igCategoryMapper.queryCount();
	}

	@Override
	public List<Ig_Category> queryKeyWordByPage(Map<String, Object> map) {
		return igCategoryMapper.queryKeyWordByPage(map);
	}

	@Override
	public int queryCountByKeyWord(String keyword) {
		return igCategoryMapper.queryCountByKeyWord(keyword);
	}

	@Override
	public List<Ig_Category> queryAllParent() {
		return igCategoryMapper.queryAllParent();
	}

	@Override
	public List<Ig_Category> queryAllChildrenByParentId(Integer id) {
		return igCategoryMapper.queryAllChildrenByParentId(id);
	}

	@Override
	public List<Ig_Category> query() {
		List<Ig_Category> cateTree = new ArrayList<Ig_Category>();
		List<Ig_Category> allParent = queryAllParent();
		for (Ig_Category currentParent : allParent) {
			List<Ig_Category> allChildrens = queryAllChildrenByParentId(currentParent.getCategoryid());
			Ig_Category currentCate = new Ig_Category();
			currentCate = currentParent;
			currentCate.setChildrens(allChildrens);
			cateTree.add(currentCate);
		}
		return cateTree;
	}

	@Override
	public Ig_Category queryById(Integer id) {
		return igCategoryMapper.queryById(id);
	}

	@Override
	public List<Ig_Category> queryByConditionByPage(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}
}
