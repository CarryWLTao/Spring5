package com.wlt.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.config.TxNamespaceHandler;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.wlt.dao.AccountDao;
import com.wlt.domain.Account;
import com.wlt.service.AccountService;
/**
 * 账户的业务层实现类
 * @author Administrator
 *
 */
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	private  PlatformTransactionManager txManager;
	
	public void setTxManager(PlatformTransactionManager txManager) {
		this.txManager = txManager;
	}

	@Override
	public void transfer(String sourceName, String targetName, Float money) {
		
		TransactionStatus status=null;
		try {
			TransactionDefinition definition=new DefaultTransactionDefinition();
			//设置定义信息
			txManager.getTransaction(definition);
			// 根据用户名称查询两个账户
			Account source=accountDao.findAccountByName(sourceName);
			Account target=accountDao.findAccountByName(targetName);
			//转出账户减钱转入账户加钱
			source.setMoney(source.getMoney()-money);
			target.setMoney(target.getMoney()+money);
			//更新两个账户
			accountDao.updateAccount(source);
			//模拟转账异常
			int i=1/0;
			accountDao.updateAccount(target);
			txManager.commit(status);
		} catch (Exception e) {
			txManager.rollback(status);
			e.printStackTrace();
		}
		

	}

	@Override
	public Account findAccountById(Integer accountId) {
		// TODO Auto-generated method stub
		return accountDao.findAccountById(accountId);
	}

}
