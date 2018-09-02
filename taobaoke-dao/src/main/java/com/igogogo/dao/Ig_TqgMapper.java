package com.igogogo.dao;

import com.igogogo.domain.Ig_Tqg;

public interface Ig_TqgMapper extends BaseMapper<Ig_Tqg> {

	public int insertSelectiveTemp(Ig_Tqg t);
	
	public Ig_Tqg checkById(Long id);
}