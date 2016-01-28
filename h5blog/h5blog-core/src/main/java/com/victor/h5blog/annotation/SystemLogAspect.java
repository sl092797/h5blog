package com.victor.h5blog.annotation;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class SystemLogAspect {
	// 本地异常日志记录对象
	private static final Logger logger = LoggerFactory
			.getLogger(SystemLogAspect.class);

	private static final String newLine = "\r\n";

	// Service层切点
	@Pointcut("@annotation(com.victor.h5blog.annotation.SystemServiceLog)")
	public void serviceAspect() {

	}

	// Controller层切点
	@Pointcut("@annotation(com.victor.h5blog.annotation.SystemControllerLog)")
	public void controllerAspect() {

	}

	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 * 
	 * @param joinPoint
	 *            切点
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		String ip = request.getRemoteAddr();

		StringBuilder sb = new StringBuilder(newLine);
		try {
			sb.append("=========Controller请求=============");
			sb.append(newLine);
			sb.append("请求方法:"
					+ (joinPoint.getTarget().getClass().getName() + "."
							+ joinPoint.getSignature().getName() + "()"));
			sb.append(newLine);
			sb.append("方法描述:"
					+ getControllerMethodDescription(joinPoint));
			sb.append(newLine);
			sb.append("请求IP:" + ip);
			sb.append(newLine);
			sb.append("=====================================");
			logger.info(sb.toString());
		} catch (Exception e) {
			logger.error("============Controller请求=============");  
            logger.error("异常信息:{}", e.getMessage());  
		}
	}

	/**
	 * 异常通知 用于拦截service层记录异常日志
	 * 
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		String ip = request.getRemoteAddr();
		// 获取用户请求方法的参数并序列化为JSON格式字符串
		String params = "";
		StringBuilder sb = new StringBuilder(newLine);
		try {
			sb.append("=========Service请求异常=============");
			sb.append(newLine);
			sb.append("异常代码:" + e.getClass().getName());
			sb.append(newLine);
			sb.append("异常信息:" + e.getMessage());
			sb.append(newLine);
			sb.append("异常方法:"
					+ (joinPoint.getTarget().getClass().getName() + "."
							+ joinPoint.getSignature().getName() + "()"));
			sb.append(newLine);
			sb.append("方法描述:"
					+ getServiceMthodDescription(joinPoint));
			sb.append(newLine);
			sb.append("请求IP:" + ip);
			sb.append(newLine);
			sb.append("=====================================");
			logger.info(sb.toString());
		} catch (Exception ex) {
			logger.error("============Service请求异常=============");  
            logger.error("异常信息:{}", ex.getMessage());  
		}

	}

	/**
	 * 获取注解中对方法的描述信息 用于service层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getServiceMthodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(SystemServiceLog.class)
							.description();
					break;
				}
			}
		}
		return description;
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getControllerMethodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(
							SystemControllerLog.class).description();
					break;
				}
			}
		}
		return description;
	}
}
