package com.igogogo.service;

import java.util.List;

import com.igogogo.domain.Ig_Admin;

public interface Ig_AdminService extends BaseService<Ig_Admin> {

	List<Ig_Admin> query();

	Ig_Admin login(Ig_Admin admin);

	int regist(Ig_Admin admin);

	Ig_Admin checkAccount(Ig_Admin admin);
}
