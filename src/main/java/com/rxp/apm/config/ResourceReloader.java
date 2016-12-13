package com.rxp.apm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ResourceReloader {//extends AbstractRefreshableApplicationContext{

	@Autowired
	ConfigurableListableBeanFactory beanFactory;

	@Autowired
	ApplicationContext context;
	
	public void reload(String fileName){
		Resource resource = context.getResource(fileName);
		XmlBeanDefinitionReader mFactory = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		mFactory.loadBeanDefinitions(resource);
	}

}
