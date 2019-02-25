package com.wlt.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wlt.service.AccountService;

/**
 * 模拟一个表现层调用业务层
 * @author Administrator
 *
 */
class AccountServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		AccountService accountService = ac.getBean("accountService",AccountService.class);
		accountService.saveAccount();
		accountService.updateAccount(10);
	}
	
	
}
