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
 * spring����Junit
 * 	��һ��:�������ϵ�jar��spring-test-5.1.4.RELEASE.jar
 * 	�ڶ���:ʹ��Junit�ṩ��@RunWithע���ԭ�е��������滻��
 * 	������:ʹ��spring�ṩ��@ContextConfigurationע��
 * 		   ��֪������spring�����ļ���λ��
 * @author Administrator
 *
 */
//ʹ��Junit�ṩ��@RunWithע���ԭ�е��������滻��,�滻��spring�ṩ��
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bean.xml")//ʹ��spring�ṩ��һ��ע���֪������spring�����ļ���λ��
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
