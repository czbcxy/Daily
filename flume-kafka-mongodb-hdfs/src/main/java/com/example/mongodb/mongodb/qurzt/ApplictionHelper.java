package com.ledong.p2c.webapps.wwwp.weblogic.customer.activityQuartz;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.google.common.base.Optional;

@Component
public class ApplictionHelper implements ApplicationContextAware{
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplictionHelper.applicationContext = applicationContext;
	}
	
	public static Object getBean(String beanName) {
		return Optional.fromNullable(applicationContext.getBean(beanName)).orNull();
	}
	
}
