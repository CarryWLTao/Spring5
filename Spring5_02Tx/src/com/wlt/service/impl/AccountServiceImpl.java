package com.wlt.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
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
	 
	 private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String sourceName, String targetName, Float money) {
		Connection connection =null;
		try {
		//ʹ��Spring�ṩ����ͬ������������ʵ�ְ�Connection���̰߳�
		TransactionSynchronizationManager.initSynchronization();
		//��ȡ��ǰ����ִ�е�Connection����
		connection = DataSourceUtils.getConnection(dataSource);
		//�ı�Connection�����ύΪ�ֶ��ύ
		connection.setAutoCommit(false);
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
		//�ύ����
		connection.commit();
		} catch (SQLException e) {
			//�ع�����
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		

	}

	@Override
	public Account findAccountById(Integer accountId) {
		// TODO Auto-generated method stub
		return accountDao.findAccountById(accountId);
	}

}
