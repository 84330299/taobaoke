package com.igogogo.service;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {

	public int add(T t);

	public int addmore(List<T> ts);

	public int delete(Integer id);

	public int deleteByMoreId(List<Integer> ids);

	// @CachePut(key = "#id")
	public int update(Integer id, T t);

	public int updatemore(List<T> ts);

	public List<T> query();

	// @Cacheable(key = "#id")
	public T queryById(Integer id);

	public int queryCount();

	public int queryCountByKeyWord(String keyword);

	public List<T> queryByPage(Map<String, Object> map);

	public List<T> queryKeyWordByPage(Map<String, Object> map);

	public List<T> queryByCondition(Map<String, Object> condition);
	
	public List<T> queryByConditionByPage(Map<String, Object> condition);
	
}
