package com.wlt.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wlt.dao.AccountDao;
import com.wlt.service.AccountService;

/**
 * 模拟一个表现层,调用业务层
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		AccountService as=ac.getBean("accountService",AccountService.class);
		AccountService as2=ac.getBean("accountService",AccountService.class);
		System.out.println(as==as2);
		
		//AccountDao ad=ac.getBean("accountDao",AccountDao.class);
		as.saveAccount();
		
	}

}
