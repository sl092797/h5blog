package com.victor.h5blog.service;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

@Service
public class KeyGeneratorService implements KeyGenerator {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * if params' length more than one,than change them to string and join with '-'
	 */
	@Override
	public Object generate(Object target, Method method, Object... params) {
//		String key = method.getName().toLowerCase() + "_" + StringUtils.join(params, "_");
		if(params.length == 1){
			return params[0];
		}
		String key = StringUtils.join(params, "_");
		logger.debug("KEY："+key);
		return key;
	}

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		EvaluationContext context = new StandardEvaluationContext();  
		context.setVariable("pcVo", new Long(3L));
		String result1 = parser.parseExpression("new String(#pcVo).concat('_123')").getValue(context, String.class);
		System.out.println(result1);
	}
}
