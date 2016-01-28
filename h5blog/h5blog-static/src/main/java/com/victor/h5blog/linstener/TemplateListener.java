package com.victor.h5blog.linstener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class TemplateListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent ev) {
		//防止重复执行。
        if(ev.getApplicationContext().getParent() == null){
        	
        }
	}

}
