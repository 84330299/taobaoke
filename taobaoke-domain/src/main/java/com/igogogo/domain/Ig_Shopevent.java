package com.igogogo.domain;

import java.util.Date;

public class Ig_Shopevent {
	private Integer eventid;

	private String eventpic;

	private String eventtitle;

	private String eventurl;

	private Integer eventorder;

	private String eventplatform;

	private String shopname;

	private String eventtype;

	private String eventstarttime;

	private String eventendtime;

	private Date addtime = new Date();

	public Integer getEventid() {
		return eventid;
	}

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	public String getEventpic() {
		return eventpic;
	}

	public void setEventpic(String eventpic) {
		this.eventpic = eventpic == null ? null : eventpic.trim();
	}

	public String getEventtitle() {
		return eventtitle;
	}

	public void setEventtitle(String eventtitle) {
		this.eventtitle = eventtitle == null ? null : eventtitle.trim();
	}

	public String getEventurl() {
		return eventurl;
	}

	public void setEventurl(String eventurl) {
		this.eventurl = eventurl == null ? null : eventurl.trim();
	}

	public Integer getEventorder() {
		return eventorder;
	}

	public void setEventorder(Integer eventorder) {
		this.eventorder = eventorder;
	}

	public String getEventplatform() {
		return eventplatform;
	}

	public void setEventplatform(String eventplatform) {
		this.eventplatform = eventplatform == null ? null : eventplatform.trim();
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname == null ? null : shopname.trim();
	}

	public String getEventtype() {
		return eventtype;
	}

	public void setEventtype(String eventtype) {
		this.eventtype = eventtype == null ? null : eventtype.trim();
	}

	public String getEventstarttime() {
		return eventstarttime;
	}

	public void setEventstarttime(String eventstarttime) {
		this.eventstarttime = eventstarttime == null ? null : eventstarttime.trim();
	}

	public String getEventendtime() {
		return eventendtime;
	}

	public void setEventendtime(String eventendtime) {
		this.eventendtime = eventendtime == null ? null : eventendtime.trim();
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
}