package com.victor.h5blog.rss;

import java.util.List;

public class Weibo {
	private String title;
	private String quote;
	private String time;
	private List<String> pictureList;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<String> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<String> pictureList) {
		this.pictureList = pictureList;
	}

}
