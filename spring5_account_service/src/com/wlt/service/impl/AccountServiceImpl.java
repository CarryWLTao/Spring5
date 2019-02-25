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
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao =new AccountDaoImpl();
	@Override
	public void saveAccount(Account account) {
			accountDao.save(account);
	}

	@Override
	public void updateAccount(Account account) {
			accountDao.update(account);

	}

	@Override
	public void deleteAccount(Integer accountId) {
			accountDao.delete(accountId);
	}

	@Override
	public Account findAccountById(Integer accountId) {
			return accountDao.findById(accountId);
	}

	@Override
	public List<Account> findAllAccount() {
			List<Account> accounts = accountDao.findAll();
			return accounts;
	}

	@Override
	public void transfer(String sourceName, String targetName, Float money) {
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
	}

}
