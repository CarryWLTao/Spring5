package com.wlt.service.impl;

import java.util.List;

import com.wlt.dao.AccountDao;
import com.wlt.dao.impl.AccountDaoImpl;
import com.wlt.domain.Account;
import com.wlt.service.AccountService;
import com.wlt.util.TransactionManager;
/**
 * 账户的业务层实现类
 * @author Administrator
 * 在javaee分层开发中,事物一般都是出于业务层的
 *
 */
public class AccountServiceImpl_OLD implements AccountService {
	
	private AccountDao accountDao =new AccountDaoImpl();
	@Override
	public void saveAccount(Account account) {
		try {
			//开启事务
			TransactionManager.beginTransaction();
			//执行调用业务层方法
			accountDao.save(account);
			//提交事务
			TransactionManager.commit();
		} catch (Exception e) {
			//回滚事务
			TransactionManager.rollback();
			e.printStackTrace();
		}finally {
			//释放资源
			TransactionManager.release();
		}
	}

	@Override
	public void updateAccount(Account account) {
		try {
			//开启事务
			TransactionManager.beginTransaction();
			//执行调用业务层方法
			accountDao.update(account);
			//提交事务
			TransactionManager.commit();
		} catch (Exception e) {
			//回滚事务
			TransactionManager.rollback();
			e.printStackTrace();
		}finally {
			//释放资源
			TransactionManager.release();
		}

	}

	@Override
	public void deleteAccount(Integer accountId) {
		try {
			//开启事务
			TransactionManager.beginTransaction();
			//执行调用业务层方法
			accountDao.delete(accountId);
			//提交事务
			TransactionManager.commit();
		} catch (Exception e) {
			//回滚事务
			TransactionManager.rollback();
			e.printStackTrace();
		}finally {
			//释放资源
			TransactionManager.release();
		}

	}

	@Override
	public Account findAccountById(Integer accountId) {
		try {
			//开启事务
			TransactionManager.beginTransaction();
			//执行调用业务层方法
			Account account = accountDao.findById(accountId);
			//提交事务
			TransactionManager.commit();
			return account;
		} catch (Exception e) {
			//回滚事务
			TransactionManager.rollback();
			throw new RuntimeException(e);
		}finally {
			//释放资源
			TransactionManager.release();
		}
		
	}

	@Override
	public List<Account> findAllAccount() {
		try {
			//开启事务
			TransactionManager.beginTransaction();
			//执行调用业务层方法
			List<Account> accounts = accountDao.findAll();
			//提交事务
			TransactionManager.commit();
			return accounts;
		} catch (Exception e) {
			//回滚事务
			TransactionManager.rollback();
			throw new RuntimeException(e);
		}finally {
			//释放资源
			TransactionManager.release();
		}
	}

	@Override
	public void transfer(String sourceName, String targetName, Float money) {
		try {
			//开启事务
			TransactionManager.beginTransaction();
			//执行调用业务层方法
			//根据名称查询转出账户
			Account source=accountDao.findByName(sourceName);
			//根据名称查询转入账户
			Account target=accountDao.findByName(targetName);
			//转出账户减钱
			source.setMoney(source.getMoney()-money);
			//转入账户加钱
			target.setMoney(target.getMoney()+money);
			//更新转出账户
			accountDao.update(source);
			//int i=1/0;
			//更新转入账户
			accountDao.update(target);
			//提交事务
			TransactionManager.commit();
		} catch (Exception e) {
			//回滚事务
			TransactionManager.rollback();
			throw new RuntimeException(e);
		}finally {
			//释放资源
			TransactionManager.release();
		}
		
	}

}
