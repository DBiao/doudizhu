package com.db.doudizhu.server.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * date: 2020/1/16 17:08
 * author: DengBiao
 */
@Component
public final class SpringBeanFactory implements ApplicationContextAware {
	private static ApplicationContext context;
	
	public static <T> T getBean(Class<T> c){
		return context.getBean(c);
	}


	public static <T> T getBean(String name,Class<T> clazz){
		return context.getBean(name,clazz);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
}
