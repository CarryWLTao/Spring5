package com.wlt.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wlt.service.AccountService;

import config.SpringConfiguration;

/**
 * 模拟一个表现层调用业务层
 * @author Administrator
 *
 */
class AccountServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
		AccountService accountService = ac.getBean("accountService",AccountService.class);
		accountService.saveAccount();
		
	}
	
	
}
