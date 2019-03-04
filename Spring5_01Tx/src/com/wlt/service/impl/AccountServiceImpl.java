package com.wlt.service.impl;

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
	public void transfer(String sourceName, String targetName, Float money) {
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

	}

	@Override
	public Account findAccountById(Integer accountId) {
		// TODO Auto-generated method stub
		return accountDao.findAccountById(accountId);
	}

}
