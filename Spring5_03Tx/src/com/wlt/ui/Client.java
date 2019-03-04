package com.wlt.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wlt.domain.Account;
import com.wlt.service.AccountService;

/**
 * 测试转账
 * @author Administrator
 *
 */
public class Client {
	
	public static void main(String[] args) {
		//获取容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		//根据bean的id获取对象
		
		AccountService as = ac.getBean("accountService",AccountService.class);
		
		Account account = as.findAccountById(1);
		System.out.println(account);
		
		as.transfer("aaa","bbb", 100f);
		
	}

}
