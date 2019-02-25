package com.wlt.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wlt.service.AccountService;

/**
 * ģ��һ�����ֲ����ҵ���
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
