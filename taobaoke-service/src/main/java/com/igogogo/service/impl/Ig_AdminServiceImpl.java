package com.igogogo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igogogo.dao.Ig_AdminMapper;
import com.igogogo.domain.Ig_Admin;
import com.igogogo.service.Ig_AdminService;
import com.igogogo.utils.PropertyUtil;
import com.igogogo.utils.StringUtils;

@Service
@Transactional
public class Ig_AdminServiceImpl implements Ig_AdminService {

	@Autowired
	private Ig_AdminMapper ig_AdminMapper;

	@Override
	public int add(Ig_Admin t) {
		return ig_AdminMapper.insertSelective(t);
	}

	@Override
	public int delete(Integer id) {
		return ig_AdminMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Integer id, Ig_Admin t) {
		t.setAdminid(id);
		return ig_AdminMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public List<Ig_Admin> query() {
		return ig_AdminMapper.query();
	}

	@Override
	public Ig_Admin queryById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Admin> queryByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ig_Admin> queryByCondition(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ig_Admin login(Ig_Admin admin) {
		admin.setAdminpwd(StringUtils.md5(admin.getAdminname() + admin.getAdminpwd()
				+ PropertyUtil.getProperty("application.properties", "salt")));
		return ig_AdminMapper.login(admin);
	}

	@Override
	public int regist(Ig_Admin admin) {
		admin.setAdminpwd(StringUtils.md5(admin.getAdminname() + admin.getAdminpwd()
				+ PropertyUtil.getProperty("application.properties", "salt")));
		return ig_AdminMapper.insertSelective(admin);
	}

	@Override
	public int addmore(List<Ig_Admin> ts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByMoreId(List<Integer> ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatemore(List<Ig_Admin> ts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ig_Admin> queryKeyWordByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryCountByKeyWord(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Ig_Admin checkAccount(Ig_Admin admin) {
		return ig_AdminMapper.checkAccount(admin);
	}

	@Override
	public List<Ig_Admin> queryByConditionByPage(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
