package com.igogogo.dao;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {

	public int deleteByPrimaryKey(Integer id);

	public int deleteByMoreId(List<Integer> ids);

	public int insertSelective(T t);

	public T selectByPrimaryKey(Integer id);

	public int updateByPrimaryKeySelective(T t);

	public List<T> query();

	public T queryById(Integer id);

	public int queryCount();

	public int queryCountByKeyWord(String keyword);

	public List<T> queryByPage(Map<String, Object> map);

	public List<T> queryKeyWordByPage(Map<String, Object> map);

	public List<T> queryByCondition(Map<String, Object> condition);
	
	public List<T> queryByConditionByPage(Map<String, Object> condition);
	
}
