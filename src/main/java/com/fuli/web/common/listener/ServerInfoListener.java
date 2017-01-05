package com.fuli.web.common.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fuli.web.common.context.SpringContext;
import com.fuli.web.common.server.AppServer;
import com.fuli.web.common.server.ImageServer;


public class ServerInfoListener implements ServletContextListener {
	
	/**
	 * 日志
	 */
	protected Logger log = Logger.getLogger(ServerInfoListener.class);  
	/**
	 * Servlet上下文
	 */
	private ServletContext servletContext;
	/**
	 * spring上下文
	 */
	private ApplicationContext applicationContext;
	
	public void contextDestroyed(ServletContextEvent arg0) {
		servletContext = null;
		applicationContext = null;
	}

	public void contextInitialized(ServletContextEvent sce) {
		servletContext = sce.getServletContext();
		
		applicationContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
		// 初始化spring上下文
		SpringContext.init(applicationContext);
		// 初始化全局上下文
		setupContext(servletContext);
		//初始化memcached
//		initMemcached(servletContext);
	}

	
	/**
	 * 初始化memcached
	 * @param context
	 */
	/*private void initMemcached(ServletContext context) {
		try {
			CacheContext.init((MemCachedClient)SpringContext.getBeanById("memcachedPool"));
			context.setAttribute("app_memcahced", CacheContext.getCacheContext());
			log.debug("initMemcached  初始化成功...");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("initMemcached  初始化失败...",e);
		}
	}*/

	private void setupContext(ServletContext context) {
		// 初始化imageServer图片域名
		ImageServer imageServer = (ImageServer) applicationContext.getBean("imageServer");
		context.setAttribute("imageServer", imageServer.bulidImageServerPath());
		// 初始化appServer
		AppServer appServer = (AppServer) applicationContext.getBean("appServer");
		context.setAttribute("appServer", appServer.bulidImageServerPath());
		
	}
}
