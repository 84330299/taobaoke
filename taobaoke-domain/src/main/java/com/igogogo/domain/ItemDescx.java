package com.igogogo.domain;

public class ItemDescx {

	private String api;
	private String[] ret;
	private String v;
	private Data data;

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String[] getRet() {
		return ret;
	}

	public void setRet(String[] ret) {
		this.ret = ret;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public class Data {
		private String[] pages;
		private String[] images;

		public String[] getPages() {
			return pages;
		}

		public void setPages(String[] pages) {
			this.pages = pages;
		}

		public String[] getImages() {
			return images;
		}

		public void setImages(String[] images) {
			this.images = images;
		}

	}

}
