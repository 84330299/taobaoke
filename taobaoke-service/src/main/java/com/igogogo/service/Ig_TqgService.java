package com.igogogo.service;

import java.util.List;

import com.igogogo.domain.Ig_Tqg;

public interface Ig_TqgService extends BaseService<Ig_Tqg> {

	public int addTemp(Ig_Tqg t);

	public int addmoreTemp(List<Ig_Tqg> ts);

	public Ig_Tqg checkById(Long id);
}
