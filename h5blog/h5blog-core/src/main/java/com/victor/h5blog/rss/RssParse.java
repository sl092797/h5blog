package com.victor.h5blog.rss;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.xml.sax.helpers.DefaultHandler;

public class RssParse {

	public static void main(String[] args) throws MalformedURLException {
		
		String s="<a href=\"http://sinacn.weibodangan.com/user/2803301701/?status=3966302421343143#utm_source=rsspic\" rel=\"nofollow\" target=\"_blank\" title=\"点击看大图\"> <img src=\"http://ww3.sinaimg.cn/large/a716fd45jw1f330nfrahqj20go0la77b.jpg\" > </a>";
		String r = s.replaceFirst("/large/", "/thumb180/");
		System.out.println(r);
	}
	

	public static List<Weibo> parseRss() {
		
		String rss = "http://rss.weibodangan.com/weibo/rss/1881670192/";
		
		try {
			CloseableHttpClient client = HttpClients.createDefault(); 
			    HttpPost post = new HttpPost(rss);
			    try {
			        ContentProducer cp = new ContentProducer() {
			            public void writeTo(OutputStream outstream) throws IOException {
			                Writer writer = new OutputStreamWriter(outstream, "UTF-8");
			                writer.write("");
			                writer.flush();
			            }

			        };
			        post.setEntity(new EntityTemplate(cp));
			        HttpResponse response = client.execute(post);
			        String xmlString = EntityUtils.toString(response.getEntity());
			        InputStream   xmlStream   =   new   ByteArrayInputStream(xmlString.getBytes("UTF-8"));  
			        SAXParserFactory factory = SAXParserFactory.newInstance();  
		            SAXParser parser = factory.newSAXParser();  
		            //SAX处理xml文本内容。将当前handler传入，由SAXParser回调  
		            RssObjectHandler handler = new RssObjectHandler();  
		            parser.parse(xmlStream, handler);  
		            List<Weibo> returnList = new ArrayList<Weibo>();
		            for(int i =0;i<handler.getRssObjects().size();i++){
		            	RssObject r = handler.getRssObjects().get(i);
		            	Weibo w = transform(r);
		            	returnList.add(w);
		            }
		           return returnList;
		            
			    } catch (ClientProtocolException e) {
			        e.printStackTrace();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Weibo transform(RssObject r){
		Weibo w = new Weibo();
		if( r.getDescription().split("RT", 2).length>1){
			//转载微博
			String title = r.getDescription().split("RT", 2)[0];
			String detail =  r.getDescription().split("RT", 2)[1];
			String time = r.getPubDate().substring(0,r.getPubDate().length()-5);
			String[] quotelist = detail.split("<br/>",0);
			List<String> linkList = new ArrayList<String>();
			w.setTitle(title);
			w.setTime(time);
			w.setQuote(quotelist[0]);
			for(int i = 1;i< quotelist.length-2;i++){
				String link = quotelist[i].replaceFirst("/large/", "/thumb180/");
				linkList.add(link);
			}
			w.setPictureList(linkList);
		}else{
			//原创微博
			String title = r.getTitle();
			String detail = r.getDescription().split("<br/>",2)[1];
			String time = r.getPubDate().substring(0,r.getPubDate().length()-5);
			String[] quotelist = detail.split("<br/>",0);
			List<String> linkList = new ArrayList<String>();
			w.setTitle(title);
			w.setTime(time);
			for(int i = 0;i< quotelist.length-1;i++){
				String link = quotelist[i].replaceFirst("/large/", "/thumb180/");
				linkList.add(link);
			}
			w.setPictureList(linkList);
		}
		
		
		return w;
	}
}
