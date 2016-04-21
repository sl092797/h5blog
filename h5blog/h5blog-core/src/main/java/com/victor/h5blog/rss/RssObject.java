package com.victor.h5blog.rss;
/** 
 * RSS 部分节点封装 
 *  
 * @author sl 
 * @version 2016-02-20 
 */  
public class RssObject {  
    private String title;  
    private String description;  
    private String pubDate;  
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
  
 
}  