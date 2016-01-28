package com.victor.h5blog.plugin;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.victor.h5blog.util.SSUtils;

import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateModelException;

@Service
public abstract class TagPlugin extends ApplicationObjectSupport implements
		TemplateDirectiveModel, Plugin {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@PostConstruct
	public void init() throws TemplateModelException {
		String className = this.getClass().getName()
				.substring(this.getClass().getName().lastIndexOf(".") + 1);
		String beanName = StringUtils.uncapitalize(className);
		String tagName = "shishuo_" + SSUtils.toUnderline(beanName);
		String legooTagName = "legoo_" + SSUtils.toUnderline(beanName);
		logger.info(tagName);
		freeMarkerConfigurer.getConfiguration().setSharedVariable(tagName,
				this.getApplicationContext().getBean(beanName));
		freeMarkerConfigurer.getConfiguration().setSharedVariable(legooTagName,
				this.getApplicationContext().getBean(beanName));
	}

}
