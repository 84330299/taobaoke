package com.igogogo.service;

import java.util.List;

import com.igogogo.domain.Ig_Category;

//@CacheConfig(cacheNames = "category")
public interface Ig_CategoryService extends BaseService<Ig_Category> {

	public List<Ig_Category> queryAllParent();

	public List<Ig_Category> queryAllChildrenByParentId(Integer id);

}
