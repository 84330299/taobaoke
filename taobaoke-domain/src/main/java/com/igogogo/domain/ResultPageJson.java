package com.igogogo.domain;

import java.io.Serializable;

public class ResultPageJson implements Serializable {
	private static final long serialVersionUID = 1L;
	private static volatile ResultPageJson instance = null;
	private String msg;
	private Integer code;
	private Integer totalcount;
	private Integer totalpage;
	private Object data;

	private ResultPageJson() {
	}

	public static ResultPageJson getInstance() {
		if (instance == null) {
			synchronized (ResultPageJson.class) {
				if (instance == null) {
					instance = new ResultPageJson();
				}
			}
		}
		return instance;
	}

	public Integer getTotalCount() {
		return totalcount;
	}

	public ResultPageJson setTotalCount(Integer totalcount) {
		this.totalcount = totalcount;
		return this;
	}

	public Integer getTotalPage() {
		return totalpage;
	}

	public ResultPageJson setTotalPage(Integer totalpage) {
		this.totalpage = totalpage;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResultPageJson setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Integer getCode() {
		return code;
	}

	public ResultPageJson setCode(Integer code) {
		this.code = code;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ResultPageJson setData(Object data) {
		this.data = data;
		return this;
	}
}
