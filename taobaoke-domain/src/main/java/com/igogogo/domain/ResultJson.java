package com.igogogo.domain;

import java.io.Serializable;

public class ResultJson implements Serializable {

	private static final long serialVersionUID = 1L;
	private static volatile ResultJson instance = null;
	private String msg;
	private Integer code;
	private Object data;

	private ResultJson() {
	}

	public static ResultJson getInstance() {
		if (instance == null) {
			synchronized (ResultJson.class) {
				if (instance == null) {
					instance = new ResultJson();
				}
			}
		}
		return instance;
	}

	public String getMsg() {
		return msg;
	}

	public ResultJson setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Integer getCode() {
		return code;
	}

	public ResultJson setCode(Integer code) {
		this.code = code;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ResultJson setData(Object data) {
		this.data = data;
		return this;
	}

	// public ResultJson getMsg() {
	// return this;
	// }
	//
	// public ResultJson setMsg(String msg) {
	// this.msg = msg;
	// return this;
	// }
	//
	// public ResultJson getCode() {
	// return this;
	// }
	//
	// public ResultJson setCode(Integer code) {
	// this.code = code;
	// return this;
	// }
	//
	// public ResultJson getData() {
	// return this;
	// }
	//
	// public ResultJson setData(Object data) {
	// this.data = data;
	// return this;
	// }

}
