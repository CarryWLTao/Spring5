package com.wlt.service.impl;

import java.util.List;

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

	@Override
	public void saveAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.save(account);

	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.update(account);

	}

	@Override
	public void deleteAccount(Integer accountId) {
		// TODO Auto-generated method stub
		accountDao.delete(accountId);

	}

	@Override
	public Account findAccountById(Integer accountId) {
		// TODO Auto-generated method stub
		
		return accountDao.findById(accountId);
	}

	@Override
	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		return accountDao.findAll();
	}

}
