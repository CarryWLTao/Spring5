package com.wlt.test;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wlt.domain.Account;
import com.wlt.service.AccountService;

public class AccountServiceTest {
	private ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
	private AccountService accountService = ac.getBean("accountService",AccountService.class);
	

	@Test
	public void testSaveAccount() {
		Account account =new Account();
		account.setName("springIOC account2");
		account.setMoney(1234f);
		accountService.saveAccount(account);
	}

	@Test
	public void testUpdateAccount() {
		Account account = accountService.findAccountById(1);
		account.setMoney(6666f);
		accountService.updateAccount(account);
	}

	@Test
	public void testDeleteAccount() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		AccountService accountService = ac.getBean("accountService",AccountService.class);
		accountService.deleteAccount(1);
	}

	@Test
	public void testFindAccountById() {
		Account account = accountService.findAccountById(1);
		System.out.println(account.getName()+"---"+account.getMoney());
	}

	@Test
	public void testFindAllAccount() {
		List<Account> list = accountService.findAllAccount();
		System.out.println(list);
	}

}
