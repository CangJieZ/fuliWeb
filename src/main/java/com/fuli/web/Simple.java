//package com.fuli.web;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.fuli.web.dao.gif.GifDao;
//import com.fuli.web.pojo.GifInfo;
//import com.fuli.web.service.gif.GifService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
//public class Simple {
//	private ApplicationContext ac = null;
//	
//	@Autowired
//	private GifDao gifDao;
//	
//
//	@Before
//	public void before() {
////		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
////		caseService = (ICaseService) ac.getBean("caseService");
//	}
//
//	@Test
//	public void test1() {
//		for (int i = 0; i < 100; i++) {
//			GifInfo gifInfo = new GifInfo();
//			gifInfo.setDesignation("番号");
//			gifInfo.setPath("http://ww3.sinaimg.cn/mw690/006fl9Dwjw1f5p37nwltdg30dw07tx6p.gif");
//			gifDao.insert(gifInfo);
//		}
//		
//	}
//}
