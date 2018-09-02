package com.igogogo.domain;

import java.io.Serializable;

public class TbkPageRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer size;
	private Integer page;
	private String keyword;

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
