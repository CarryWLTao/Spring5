package com.wlt.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wlt.domain.Account;
import com.wlt.service.AccountService;

/**
 * ����ת��
 * @author Administrator
 *
 */
public class Client {
	
	public static void main(String[] args) {
		//��ȡ����
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		//����bean��id��ȡ����
		
		AccountService as = ac.getBean("accountService",AccountService.class);
		
		Account account = as.findAccountById(1);
		System.out.println(account);
		
		as.transfer("aaa","bbb", 100f);
		
	}

}
