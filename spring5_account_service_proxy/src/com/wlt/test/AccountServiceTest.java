package com.wlt.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.wlt.domain.Account;
import com.wlt.factory.BeanFactory;
import com.wlt.service.AccountService;

public class AccountServiceTest {
	private AccountService accountService=BeanFactory.getProxyAccountService();
	@Test
	public void testSaveAccount() {
		Account account=new Account();
		account.setName("test");
		account.setMoney(10000f);
		accountService.saveAccount(account);
	}

	@Test
	public void testUpdateAccount() {
		Account account = accountService.findAccountById(2);
		account.setMoney(34567f);
		accountService.updateAccount(account);
	}

	@Test
	public void testDeleteAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAccountById() {
		Account account = accountService.findAccountById(2);
		System.out.println(account);
	}

	@Test
	public void testFindAllAccount() {
		List<Account> findAllAccount = accountService.findAllAccount();
		System.out.println(findAllAccount);
	}
	@Test
	public void testTransfer() {
		accountService.transfer("aaa", "bbb", 100f);
	}

}
