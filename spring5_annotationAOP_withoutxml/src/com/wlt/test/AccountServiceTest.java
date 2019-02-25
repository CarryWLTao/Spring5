package com.wlt.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wlt.service.AccountService;

import config.SpringConfiguration;

/**
 * ģ��һ�����ֲ����ҵ���
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
