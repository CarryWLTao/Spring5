package com.wlt.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wlt.domain.Account;
import com.wlt.service.AccountService;
/**
 * spring整合Junit
 * 	第一步:拷贝整合的jar包spring-test-5.1.4.RELEASE.jar
 * 	第二部:使用Junit提供的@RunWith注解把原有的运行器替换掉
 * 	第三部:使用spring提供的@ContextConfiguration注解
 * 		   告知运行器spring配置文件的位置
 * @author Administrator
 *
 */
//使用Junit提供的@RunWith注解把原有的运行器替换掉,替换成spring提供的
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bean.xml")//使用spring提供的一个注解告知运行器spring配置文件的位置
public class AccountServiceTest {
	@Autowired
	private AccountService accountService;
	

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
