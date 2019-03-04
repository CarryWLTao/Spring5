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
 * �˻���ҵ���ʵ����
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
			//���ö�����Ϣ
			txManager.getTransaction(definition);
			// �����û����Ʋ�ѯ�����˻�
			Account source=accountDao.findAccountByName(sourceName);
			Account target=accountDao.findAccountByName(targetName);
			//ת���˻���Ǯת���˻���Ǯ
			source.setMoney(source.getMoney()-money);
			target.setMoney(target.getMoney()+money);
			//���������˻�
			accountDao.updateAccount(source);
			//ģ��ת���쳣
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
