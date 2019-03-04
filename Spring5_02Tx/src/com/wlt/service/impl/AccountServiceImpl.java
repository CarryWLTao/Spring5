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
 * 账户的业务层实现类
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
		//使用Spring提供事务同步管理器对象实现把Connection和线程绑定
		TransactionSynchronizationManager.initSynchronization();
		//获取当前正在执行的Connection对象
		connection = DataSourceUtils.getConnection(dataSource);
		//改变Connection事务提交为手动提交
		connection.setAutoCommit(false);
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
		//提交事务
		connection.commit();
		} catch (SQLException e) {
			//回滚事务
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
