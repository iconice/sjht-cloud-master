package com.sjht.cloud.framework.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 ********************************************** 
 * @ClassName: SpringContextUtil
 * @Description: spring管理环境中获取bean
 * @Author maojianyun
 * @Date 2019/12/30 14:08
 * @Version V1.0
 **********************************************
 */
@Service("springContextUtil")
public class SpringContextUtil implements ApplicationContextAware {
	
	// Spring应用上下文环境
	private static ApplicationContext applicationContext;

	/**
	 *************************************************** 
	 * @Title: setApplicationContext
	 * @Description: 实现ApplicationContextAware接口的回调方法，设置上下文环境
	 * @Param: applicationContext
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 ****************************************************
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 ********************************************************* 
	 * @Title: getBean
	 * @Description: 获取对象
	 * @Param: name
	 * @Throws BeansException
	 * @Return: Object
	 * @Author maojianyun
	 **********************************************************
	 */
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}
}
