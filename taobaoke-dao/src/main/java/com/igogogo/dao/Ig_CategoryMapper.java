package com.igogogo.dao;

import java.util.List;

import com.igogogo.domain.Ig_Category;

public interface Ig_CategoryMapper extends BaseMapper<Ig_Category> {

	public List<Ig_Category> queryAllParent();

	public List<Ig_Category> queryAllChildrenByParentId(Integer id);
}