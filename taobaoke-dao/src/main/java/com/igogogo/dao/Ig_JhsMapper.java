package com.igogogo.dao;

import com.igogogo.domain.Ig_Jhs;

public interface Ig_JhsMapper extends BaseMapper<Ig_Jhs> {

	public int insertSelectiveTemp(Ig_Jhs t);

	public Ig_Jhs checkById(Long id);

}