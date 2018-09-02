package com.igogogo.domain;

import java.util.Date;

public class Ig_Alievents {
	private Integer eventid;

	private String eventpic;

	private String eventtitle;

	private String eventurl;

	private Integer eventorder;

	private String eventplatform;

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

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
}