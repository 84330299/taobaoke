package com.igogogo.dao;

import com.igogogo.domain.Ig_Admin;

public interface Ig_AdminMapper extends BaseMapper<Ig_Admin> {

	public Ig_Admin login(Ig_Admin admin);

	public int regist(Ig_Admin admin);

	public Ig_Admin checkAccount(Ig_Admin admin);

}