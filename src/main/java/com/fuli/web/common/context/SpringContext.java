package com.fuli.web.common.context;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;


public class SpringContext {
	private static final Log log = LogFactory.getLog(SpringContext.class);
	/**
	 * spring应用上下文
	 */
	private static ApplicationContext applicationContext;

	/**
	 * 初始化spring上下文
	 * 
	 * @Description
	 * @param app
	 * 
	 */
	public static void init(ApplicationContext app) {
		applicationContext = app;
		if (log.isDebugEnabled()) {
			log.debug("初始化SpringContext，设置ApplicationContext");
		}
	}

	/**
	 * 取spring应用上下文
	 * 
	 * @Description
	 * @return
	 * 
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 取spring中定义的bean
	 * 
	 * @Description
	 * @param name
	 * @return
	 * 
	 */
	public static Object getBean(String name) {
		if (applicationContext == null) {
			log.error("spring应用上下文为空SpringContext.applicationConext=null");
			return null;
		}

		return applicationContext.getBean(name);
	}
	
	
	 /**
     * 根据bean的id来查找对象
     * @param id
     * @return
     */
    public static Object getBeanById(String id){
        return applicationContext.getBean(id);
    }
     
    /**
     * 根据bean的class来查找对象
     * @param c
     * @return
     */
    public static Object getBeanByClass(Class c){
        return applicationContext.getBean(c);
    }
     
    /**
     * 根据bean的class来查找所有的对象(包括子类)
     * @param c
     * @return
     */
    public static Map getBeansByClass(Class c){
        return applicationContext.getBeansOfType(c);
    }
}
