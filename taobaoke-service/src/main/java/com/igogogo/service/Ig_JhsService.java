package com.igogogo.service;

import java.util.List;

import com.igogogo.domain.Ig_Jhs;

public interface Ig_JhsService extends BaseService<Ig_Jhs> {

	public int addTemp(Ig_Jhs t);

	public int addmoreTemp(List<Ig_Jhs> ts);
	
	public Ig_Jhs checkById(Long id);
}
