package com.victor.h5blog.rss;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.util.EntityUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 继承SAX的DefaultHandler用于处理xml文件内容。
 * 实现HttpClientResponseHandler接口，处理HttpClient返回数据
 * @author boyce
 * @version 2014-1-24
 */
public class RssObjectHandler extends DefaultHandler {
	/**
	 * 保存正在读取的标签名称
	 */
	private final static Stack<String> STACK = new Stack<String>();
	
	/**
	 * 保存HunteronObservation对象集合
	 */
	private final List<RssObject> RSS_OBJECTS = new ArrayList<RssObject>();
	
	 private String title;  
    private String description;  
    private String pubDate;  
	private final static String ITEM = "item";
	private final static String TITLE = "title";
	private final static String DESCRIPTION = "description";
	private final static String PUBDATE = "pubDate";
	
	//是否开始读取
	private boolean start = false;
	
	
	public List<RssObject> getRssObjects() {
		return RSS_OBJECTS;
	}
	
	/**
	 * 开始读取元素
	 */
	public void startElement(String uri, String localName, String qName,  
			Attributes attributes) throws SAXException  
	{  
		//遇到item标签，开始保存有效属性
		if (ITEM.equals(qName)) {
			start = true;
		}
		
		//保存当前读取的标签到栈顶
		if (start) {
			if (ITEM.equals(qName) || TITLE.equals(qName) ||
					DESCRIPTION.equals(qName) ||PUBDATE.equals(qName)) 
				STACK.push(qName);
		}
	}  
	
	/**
	 * 元素标签读取结束
	 */
	public void endElement(String uri, String localName, String qName)  
			throws SAXException  
	{  
		//弹出栈顶标签  
        if (!STACK.isEmpty() &&(ITEM.equals(qName) || TITLE.equals(qName) ||
				DESCRIPTION.equals(qName) ||PUBDATE.equals(qName)) )  
            STACK.pop();
		
		//如果一个item结束，保存一个HunteronObservation
		if (ITEM.equals(qName)) {
			RssObject rssObject = new RssObject();
			rssObject.setTitle(title);
			rssObject.setDescription(description);
			rssObject.setPubDate(pubDate);
			RSS_OBJECTS.add(rssObject);
		}
	} 
	
	/**
	 *
	 */
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (!STACK.isEmpty()) {
			String qName = STACK.peek();
			//title
			if (TITLE.equals(qName)&&!new String(ch, start, length).equalsIgnoreCase("\n"))
				this.title = new String(ch, start, length);
			
			//防止标签和ICDATA之间有\n
			if (DESCRIPTION.equals(qName)&&!new String(ch, start, length).equalsIgnoreCase("\n"))
				this.description = new String(ch, start, length);
			
			if (PUBDATE.equals(qName))
				this.pubDate = new String(ch, start, length);
			
		}
	}
}

